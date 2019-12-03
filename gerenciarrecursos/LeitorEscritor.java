package gerenciarrecursos;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class LeitorEscritor extends Thread {

//    private int views, likes, dislikes, iViews, iLikes, iDislikes; // variaveis auxiliares
    public static ArrayList<Integer> views_vetor = new ArrayList<Integer>();
    public static ArrayList<Integer> likes_vetor = new ArrayList<Integer>();
    public static ArrayList<Integer> dislikes_vetor = new ArrayList<Integer>();

    public LeitorEscritor() {}

    public static ArrayList<Integer> getViews_vetor() {
		return views_vetor;
	}

	public static void setViews_vetor(ArrayList<Integer> views_vetor) {
		LeitorEscritor.views_vetor = views_vetor;
	}

	public static ArrayList<Integer> getLikes_vetor() {
		return likes_vetor;
	}

	public static void setLikes_vetor(ArrayList<Integer> likes_vetor) {
		LeitorEscritor.likes_vetor = likes_vetor;
	}

	public static ArrayList<Integer> getDislikes_vetor() {
		return dislikes_vetor;
	}

	public static void setDislikes_vetor(ArrayList<Integer> dislikes_vetor) {
		LeitorEscritor.dislikes_vetor = dislikes_vetor;
	}

	@Override
    public void run() {
        while (GerenciarRecursos.scanner.hasNext() && GerenciarRecursos.scanner2.hasNext()) {
            LeitorEscritor.views_vetor.add(GerenciarRecursos.scanner.nextInt());
            LeitorEscritor.views_vetor.add(-(GerenciarRecursos.scanner2.nextInt()));
            LeitorEscritor.likes_vetor.add(GerenciarRecursos.scanner.nextInt());
            LeitorEscritor.likes_vetor.add(-(GerenciarRecursos.scanner2.nextInt()));
            LeitorEscritor.dislikes_vetor.add(GerenciarRecursos.scanner.nextInt());
            LeitorEscritor.dislikes_vetor.add(-(GerenciarRecursos.scanner2.nextInt()));
//            System.out.println("Lendo valores...");
//            System.out.printf("%d|%d|%d\n", views, likes, dislikes);
//            System.out.printf("Valores lidos: Views:%d Likes: %d Dislikes: %d\n", views, likes, dislikes);
//            System.out.printf("Valores invalidos: \nViews:%d Likes: %d Dislikes: %d\n", iViews, iLikes, iDislikes);
//            System.out.println("Escrevendo valores...");
//            v1.addViews(views);
//            v1.removeViews(iViews);
//            v1.addLikes(likes);
//            v1.removeLikes(iLikes);
//            v1.addDislikes(dislikes);
//            v1.removeDislikes(iDislikes);
        }//while
    }

//    public synchronized void addInvalidLikes(int iLikes) {
//        this.iLikes = iLikes;
//    }
//
//    public synchronized void addInvalidViews(int iViews) {
//        this.iViews = iViews;
//    }
//
//    public synchronized void addInvalidDislikes(int iDislikes) {
//        this.iDislikes = iDislikes;
//    }
//
//    public synchronized void addLikes(int likes) {
//        this.likes = likes;
//    }
//
//    public synchronized void addDislikes(int dislikes) {
//        this.dislikes = dislikes;
//    }
//
//    public synchronized void addViews(int views) {
//        this.views = views;
//    }

}
