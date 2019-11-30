package gerenciarrecursos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class GerenciarRecursos {
    public static void main(String[] args) throws FileNotFoundException {
       
        //String path = System.getProperty("user.dir");
        //System.out.println(path);
        Video v1 = new Video();
        Scanner scanner = new Scanner(new FileReader("atualizarValores.txt")).useDelimiter("\\||\\n");
        Scanner scanner2 = new Scanner(new FileReader("diminuirValores.txt")).useDelimiter("\\||\\n");
       
        while(scanner.hasNext() && scanner2.hasNext()){
            v1.addViews(scanner.nextInt());
            v1.removeViews(scanner2.nextInt());
            v1.addLikes(scanner.nextInt());
            v1.removeLikes(scanner2.nextInt());
            v1.addDislikes(scanner.nextInt());
            v1.removeDislikes(scanner2.nextInt());
        }
        
        System.out.println("views:" + v1.getViews());
        System.out.println("likes:" + v1.getLikes());
        System.out.println("dislikes:" + v1.getDislikes());
   
    }    
}
