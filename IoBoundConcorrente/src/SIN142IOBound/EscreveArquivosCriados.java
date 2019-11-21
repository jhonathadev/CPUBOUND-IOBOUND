package SIN142IOBound;

import java.io.File;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EscreveArquivosCriados implements Runnable {

    public int i = 0;
    public static ArrayList<File> lista_files = new ArrayList<File>();
    private static Random gerador = new Random(10);
    public boolean status;

    //Get-Sets
    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public static ArrayList<File> getLista_files() {
        return lista_files;
    }

    public static void setLista_files(ArrayList<File> lista_files) {
        EscreveArquivosCriados.lista_files = lista_files;
    }

    //Construtores
    public EscreveArquivosCriados(int i) {
        this.i = i;
    }

    public EscreveArquivosCriados(ArrayList<File> lista_recebida) {
        lista_files = lista_recebida;
    }

    public EscreveArquivosCriados() {
    }

    public void escreveVariosArquivos(ArrayList<File> lista_par) throws IOException {
        lista_files = lista_par;
        for (i = 0; i < 29990; i++) {
            EscreveArquivosCriados escritor1 = new EscreveArquivosCriados(i);
            Thread escritor_thread = new Thread(escritor1);
            escritor_thread.start();
        }//for
        for (i = 29990; i < 30000; i++) {
            EscreveArquivosCriados escritor1 = new EscreveArquivosCriados(i);
            Thread escritor_thread = new Thread(escritor1);
            escritor_thread.start();
            try {
                escritor_thread.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        status = true;
        return;
    }//fim criarVariosArquivos

    @Override
    public void run() {
        try {
            FileWriter writer;

            File file_atual = lista_files.get(i);
            writer = new FileWriter(file_atual);
            writer.write(Integer.toString(gerador.nextInt(100001)));
            System.out.printf("\nArquivo %d escrito =>(caminho: %s).", i, lista_files.get(i).toString());
            writer.close();
        }//Try
        catch (IOException e) {
            System.out.println("IOExcepetion.");
            run();
        }//Catch1 = IOException
        catch (NullPointerException e) {
            /*
			 * Corrige caminho.
			 * Tem uma brincadeirinha com cores aqui. Só funciona compilando em terminal.
			**/
            final String ANSI_BRIGHT_RED = "\u001B[91m";
            final String ANSI_RESET = "\u001B[0m";
            String[] path = lista_files.get(0).getPath().split("0.txt");
            path[0] = path[0] + Integer.toString(i) + ".txt";
            System.out.printf(ANSI_BRIGHT_RED + "\nNullPointerException. %d: %s" + ANSI_RESET, i, path[0]);
            File recover_file = new File(path[0]);
            lista_files.set(i, recover_file);

            //Tenta de novo;
            run();
        }//Catch2 = NullPointerException
        catch (IndexOutOfBoundsException e) {
            /*
			 * Corrige caminho.
			 * Tem uma brincadeirinha com cores aqui. Só funciona compilando em terminal.
			**/
            final String ANSI_BRIGHT_RED = "\u001B[91m";
            final String ANSI_RESET = "\u001B[0m";
            String[] path = lista_files.get(0).getPath().split("0.txt");
            path[0] = path[0] + Integer.toString(i) + ".txt";
            System.out.printf(ANSI_BRIGHT_RED + "\nNullPointerException. %d: %s" + ANSI_RESET, i, path[0]);
            File recover_file = new File(path[0]);
            lista_files.set(i, recover_file);

            //Tenta de novo;
            run();
        }//Catch2 = NullPointerException
    }//Run
}//Classe
