package gerenciarrecursos;

//Segundo trabalho avaliativo SIN-142
//Desenvolvido por: Jhonatha Cordeiro 5984, Júlia Mendonça 5956, Lincoln Dandson 5993,
//Victor Hugo 5962,Viviane Mendes Silva 5209

import java.util.concurrent.*;

public class Index {

    public static void main(String[] args) {

        //String path = System.getProperty("user.dir");
        //System.out.println(path);

        Semaphore sem = new Semaphore(1);
        ReaderWriter t1 = new ReaderWriter(sem);
        ReaderWriter t2 = new ReaderWriter(sem);
        ReaderWriter t3 = new ReaderWriter(sem);
        ReaderWriter t4 = new ReaderWriter(sem);
        ReaderWriter t5 = new ReaderWriter(sem);
        ReaderWriter t6 = new ReaderWriter(sem);
        ReaderWriter t7 = new ReaderWriter(sem);
        ReaderWriter t8 = new ReaderWriter(sem);
        ReaderWriter t9 = new ReaderWriter(sem);
        ReaderWriter t10 = new ReaderWriter(sem);
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        
        System.out.println("-------------------------");
        System.out.println(".:Valores finais:.\n");
        System.out.println("Views:" + t1.v.getViews());
        System.out.println("Likes:" + t1.v.getLikes());
        System.out.println("Dislikes:" + t1.v.getDislikes());
        System.out.println("-------------------------");

    }    
}
