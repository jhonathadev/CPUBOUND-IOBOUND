package gerenciarrecursos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.*;

public class GerenciarRecursos {
	public static Video video = new Video();
    static Scanner scanner = new Scanner(System.in);
    static Scanner scanner2 = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException, InterruptedException, IOException {

        //String path = System.getProperty("user.dir");
        //System.out.println(path);
//        Video v1 = new Video();

        FileReader atualizar = new FileReader("atualizarValores.txt");
        FileReader diminuir = new FileReader("diminuirValores.txt");
        GerenciarRecursos.scanner = new Scanner(atualizar).useDelimiter("\\||\\n");
        GerenciarRecursos.scanner2 = new Scanner(diminuir).useDelimiter("\\||\\n");
        int i, num_threads;
        Semaphore sem = new Semaphore(1);
        LeitorEscritor l1 = new LeitorEscritor();
 
        l1.start();
        l1.join();
        
        for(i=0; i<LeitorEscritor.likes_vetor.size(); i++) {
        	System.out.printf("\n%d", LeitorEscritor.likes_vetor.get(i));
        }
        
        for(num_threads = 0; num_threads<10; num_threads++) {
        	AtualizarLikes like_updater = new AtualizarLikes(sem, 0, num_threads);
        	like_updater.start();
        }
        
        atualizar.close();
        diminuir.close();
        
//        System.out.println("views:" + l1.v1.getViews());
        System.out.println("likes:" + video.getLikes());
//        System.out.println("dislikes:" + l1.v1.getDislikes()); 
        
        
    }    
}
