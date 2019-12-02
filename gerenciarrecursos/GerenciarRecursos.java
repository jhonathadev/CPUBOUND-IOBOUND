package gerenciarrecursos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class GerenciarRecursos extends Thread{
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
       
        //String path = System.getProperty("user.dir");
        //System.out.println(path);
        //Video v1 = new Video();
        Scanner scanner = new Scanner(new FileReader("atualizarValores.txt")).useDelimiter("\\||\\n");
        Scanner scanner2 = new Scanner(new FileReader("diminuirValores.txt")).useDelimiter("\\||\\n");
        LeitorEscritor l1 = new LeitorEscritor("A");

        l1.start();
 
        while(scanner.hasNext() && scanner2.hasNext()){
            if(!l1.getReader()){
                l1.waitColorChange();
            }else{
                l1.addViews(scanner.nextInt());
                l1.removeViews(scanner2.nextInt());
                l1.addLikes(scanner.nextInt());
                l1.removeLikes(scanner2.nextInt());
                l1.addDislikes(scanner.nextInt());
                l1.removeDislikes(scanner2.nextInt());        
                l1.waitColorChange();
            }
        }
        
        l1.stopSemaphoro();

        System.out.println("views:" + l1.v1.getViews());
        System.out.println("likes:" + l1.v1.getLikes());
        System.out.println("dislikes:" + l1.v1.getDislikes()); 
        
    }    
}
