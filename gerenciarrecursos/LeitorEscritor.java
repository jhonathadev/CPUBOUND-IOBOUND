package gerenciarrecursos;

import java.util.concurrent.Semaphore;

public class LeitorEscritor extends Thread {

    private int views, likes, dislikes, iViews, iLikes, iDislikes; // variaveis auxiliares
    Video v1 = new Video();
    Semaphore sem;

    public LeitorEscritor() {
    }

    public LeitorEscritor(Semaphore sem) {
        super();
        this.sem = sem;
    }

    @Override
    public void run() {
        while (GerenciarRecursos.scanner.hasNext() && GerenciarRecursos.scanner2.hasNext()) {
            try {
                if (GerenciarRecursos.scanner.hasNext() && GerenciarRecursos.scanner2.hasNext()) {
                    sem.acquire();
                    this.addViews(GerenciarRecursos.scanner.nextInt());
                    this.addInvalidViews(GerenciarRecursos.scanner2.nextInt());
                    this.addLikes(GerenciarRecursos.scanner.nextInt());
                    this.addInvalidLikes(GerenciarRecursos.scanner2.nextInt());
                    this.addDislikes(GerenciarRecursos.scanner.nextInt());
                    this.addInvalidDislikes(GerenciarRecursos.scanner2.nextInt());
//                  System.out.println("Lendo valores...");
                    System.out.printf("%d|%d|%d\n", views, likes, dislikes);
//                  System.out.printf("Valores lidos: Views:%d Likes: %d Dislikes: %d\n", views, likes, dislikes);
//                  System.out.printf("Valores invalidos: \nViews:%d Likes: %d Dislikes: %d\n", iViews, iLikes, iDislikes);
//                  System.out.println("Escrevendo valores...");
                    v1.addViews(views);
                    v1.removeViews(iViews);
                    v1.addLikes(likes);
                    v1.removeLikes(iLikes);
                    v1.addDislikes(dislikes);
                    v1.removeDislikes(iDislikes);
                }//if
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            sem.release();
        }//while
    }

    public synchronized void addInvalidLikes(int iLikes) {
        this.iLikes = iLikes;
    }

    public synchronized void addInvalidViews(int iViews) {
        this.iViews = iViews;
    }

    public synchronized void addInvalidDislikes(int iDislikes) {
        this.iDislikes = iDislikes;
    }

    public synchronized void addLikes(int likes) {
        this.likes = likes;
    }

    public synchronized void addDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public synchronized void addViews(int views) {
        this.views = views;
    }

}
