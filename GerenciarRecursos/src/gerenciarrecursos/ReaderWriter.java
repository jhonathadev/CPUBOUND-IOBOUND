package gerenciarrecursos;

import java.io.*;
import java.util.concurrent.Semaphore;

public class ReaderWriter extends Thread {

    private int views, likes, dislikes; // variaveis auxiliares
    Video v = new Video();
    Semaphore sem;
    
    public ReaderWriter(Semaphore sem) {
        super();
        this.sem = sem;
    }

    @Override
    public void run() {
        System.out.println("Iniciando " + Thread.currentThread().getName());
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        try{
            LineNumberReader arcValid = new LineNumberReader(new FileReader("atualizarValores.txt"));
            LineNumberReader arcInvalid = new LineNumberReader(new FileReader("diminuirValores.txt"));
            // variaveis auxiliares
            String lineValid = arcValid.readLine();
            String lineInvalid = arcInvalid.readLine();
            String auxValid[];
            String auxInvalid[];
            int currentLine = 0;
            while (lineValid != null && lineInvalid != null) {
                try {
                    sem.acquire(); // adquire o recurso
                    if (arcValid.getLineNumber() != arcInvalid.getLineNumber()) { // garante a sincronização dos dois arquivos
                        System.out.println("Erro - Arquivos desincronizados");
                        // fecha arquivos
                        arcValid.close();
                        arcInvalid.close();
                        return;
                    } 
                    currentLine = arcValid.getLineNumber(); 
                    v.controlArrayList(currentLine); // verifica se a linha atual já foi lida
                    // delimita os valores salvo, para poder serem separados
                    auxValid = lineValid.split(" ");
                    auxInvalid = lineInvalid.split(" ");
                    // atribui valores as variaveis auxiliares
                    addViews(Integer.parseInt(auxValid[0]));
                    addInvalidViews(Integer.parseInt(auxInvalid[0]));
                    addLikes(Integer.parseInt(auxValid[1]));
                    addInvalidLikes(Integer.parseInt(auxInvalid[1]));
                    addDislikes(Integer.parseInt(auxValid[2]));
                    addInvalidDislikes(Integer.parseInt(auxInvalid[2]));
                    System.out.printf("Views: %d | Likes: %d | Dislikes: %d\n", views, likes, dislikes);
                    // pula para a proxima linha do arquivo
                    lineValid = arcValid.readLine();
                    lineInvalid = arcInvalid.readLine();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }  
                sem.release(); // libera o recurso
            }
            // atribui valores finais a classe Video
            v.setLikes(likes);
            v.setViews(views);
            v.setDislikes(dislikes);
            // fecha arquivos
            arcValid.close();
            arcInvalid.close();
        } catch(FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public synchronized void addInvalidLikes(int iLikes) {
        this.likes -= iLikes;
    }

    public synchronized void addInvalidViews(int iViews) {
        this.views -= iViews;
    }

    public synchronized void addInvalidDislikes(int iDislikes) {
        this.dislikes -= iDislikes;
    }

    public synchronized void addLikes(int likes) {
        this.likes += likes;
    }

    public synchronized void addDislikes(int dislikes) {
        this.dislikes += dislikes;
    }

    public synchronized void addViews(int views) {
        this.views += views;
    }

}
