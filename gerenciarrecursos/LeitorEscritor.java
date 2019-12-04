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
    String aux, aux2;
    int k =0;
    int results[] = new int[3];
    int results2[] = new int[3];
    

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
			aux = GerenciarRecursos.scanner.next();
			aux2 = GerenciarRecursos.scanner2.next();
			Scanner scn = new Scanner(aux);
			Scanner scn2 = new Scanner(aux2);
			for(k = 0; k < 3; k++) {
				results[k] = scn.nextInt();
				results2[k] = scn2.nextInt();
			}
			LeitorEscritor.views_vetor.add(results[0]);
			LeitorEscritor.views_vetor_r.add(results2[0]); 
			LeitorEscritor.likes_vetor.add(results[1]);
			LeitorEscritor.likes_vetor_r.add(results2[1]);
			LeitorEscritor.dislikes_vetor.add(results[2]);
			LeitorEscritor.dislikes_vetor_r.add(results2[2]);
          scn.close();
          scn2.close();
        }//while
    }
}
