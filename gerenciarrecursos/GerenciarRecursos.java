package gerenciarrecursos;

import java.util.concurrent.Semaphore;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GerenciarRecursos {
	public static Video video = new Video();
    static Scanner scanner = new Scanner(System.in);
    static Scanner scanner2 = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException, InterruptedException, IOException {
        FileReader atualizar = new FileReader("atualizarValores.txt");
        FileReader diminuir = new FileReader("diminuirValores.txt");
        GerenciarRecursos.scanner = new Scanner(atualizar).useDelimiter("\\||\\n");
        GerenciarRecursos.scanner2 = new Scanner(diminuir).useDelimiter("\\||\\n");
        int i = 0, x = 0, num_threads;
        Semaphore sem = new Semaphore(1, true);
        Semaphore sem2 = new Semaphore(1, true);
        LeitorEscritor l1 = new LeitorEscritor();
        
        //Lê arquivos
        l1.start();
        l1.join();
        
        //Verifica se a leitura foi correta.
//        for(i=0; i<LeitorEscritor.likes_vetor.size(); i++) {
//        	System.out.printf("\n%d %d %d", LeitorEscritor.views_vetor.get(i), LeitorEscritor.likes_vetor.get(i), LeitorEscritor.dislikes_vetor.get(i));
//        }
        
//        for(i=0; i<LeitorEscritor.likes_vetor.size(); i++) {
//        	System.out.printf("\n%d %d %d", LeitorEscritor.views_vetor_r.get(i), LeitorEscritor.likes_vetor_r.get(i), LeitorEscritor.dislikes_vetor_r.get(i));
//        }
        
        
        System.out.println();
        AtualizarAtributos.i = 0;
        DecrementaAtributos.i = 0;
        for(i=0; i<10; i++) {
        	AtualizarAtributos att_updater = new AtualizarAtributos(sem, i+1);
        	DecrementaAtributos invalid_att_updater = new DecrementaAtributos(sem, i+11);
        	att_updater.start();
        	invalid_att_updater.start();
        }
        
        Thread.sleep(300);
        
        atualizar.close();
        diminuir.close();
        System.out.println();
        System.out.println("views:" + video.getViews());
        System.out.println("likes:" + video.getLikes());
        System.out.println("dislikes:" + video.getDislikes()); 
        
        
    }    
}
