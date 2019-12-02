package gerenciarrecursos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.*;

public class GerenciarRecursos {
	static Scanner scanner = new Scanner(System.in);
	static Scanner scanner2 = new Scanner(System.in);
	    
    public static void main(String[] args) throws FileNotFoundException, InterruptedException, IOException{
       
        //String path = System.getProperty("user.dir");
        //System.out.println(path);
        //Video v1 = new Video();
    	FileReader atualizar = new FileReader("atualizarValores.txt");
		FileReader diminuir = new FileReader("diminuirValores.txt");
		GerenciarRecursos.scanner = new Scanner(atualizar).useDelimiter("\\||\\n");;
		GerenciarRecursos.scanner2 = new Scanner(diminuir).useDelimiter("\\||\\n");;
    	Semaphore sem = new Semaphore(1);
    	LeitorEscritor l1 = new LeitorEscritor(sem);
        LeitorEscritor l2 = new LeitorEscritor(sem);
        LeitorEscritor l3 = new LeitorEscritor(sem);
        LeitorEscritor l4 = new LeitorEscritor(sem);
        LeitorEscritor l5 = new LeitorEscritor(sem);
        LeitorEscritor l6 = new LeitorEscritor(sem);
        LeitorEscritor l7 = new LeitorEscritor(sem);
        LeitorEscritor l8 = new LeitorEscritor(sem);
        LeitorEscritor l9 = new LeitorEscritor(sem);
        LeitorEscritor l10 = new LeitorEscritor(sem);
 
        l1.start();
        l1.join();
        
        l2.start();
        l2.join();
        
        l3.start();
        l3.join();
        
        l4.start();
        l4.join();
        
        l5.start();
        l5.join();
        
        l6.start();
        l6.join();
        
        l7.start();
        l7.join();
        
        l8.start();
        l8.join();
        
        l9.start();
        l9.join();
        
        l10.start();
        l10.join();
        
        
        atualizar.close();
        diminuir.close();
        
//        System.out.println("views:" + l1.v1.getViews());
//        System.out.println("likes:" + l1.v1.getLikes());
//        System.out.println("dislikes:" + l1.v1.getDislikes()); 
        
        
    }    
}
