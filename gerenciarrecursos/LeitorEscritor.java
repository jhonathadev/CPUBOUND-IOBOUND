package gerenciarrecursos;

import java.lang.Thread;
import java.util.concurrent.Semaphore;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class LeitorEscritor extends Thread {
    public static ArrayList<Integer> views_vetor = new ArrayList<Integer>();
    public static ArrayList<Integer> likes_vetor = new ArrayList<Integer>();
    public static ArrayList<Integer> dislikes_vetor = new ArrayList<Integer>();
    public static ArrayList<Integer> views_vetor_r = new ArrayList<Integer>();
    public static ArrayList<Integer> likes_vetor_r = new ArrayList<Integer>();
    public static ArrayList<Integer> dislikes_vetor_r= new ArrayList<Integer>();

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
            LeitorEscritor.views_vetor_r.add(GerenciarRecursos.scanner2.nextInt());
            LeitorEscritor.likes_vetor.add(GerenciarRecursos.scanner.nextInt());
            LeitorEscritor.likes_vetor_r.add(GerenciarRecursos.scanner2.nextInt());
            LeitorEscritor.dislikes_vetor.add(GerenciarRecursos.scanner.nextInt());
            LeitorEscritor.dislikes_vetor_r.add(GerenciarRecursos.scanner2.nextInt());
        }//while
    }
}
