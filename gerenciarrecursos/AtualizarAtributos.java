package gerenciarrecursos;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class AtualizarAtributos extends Thread{
	Semaphore sem;
	public static int i;
	int thread_n, likes=-1, dislikes=-1, views=-1, j;
	
	public AtualizarAtributos() {}
	public AtualizarAtributos(Semaphore sem, int thread_n) {
		this.sem = sem;
		this.thread_n = thread_n;
	}
	@Override
	public void run(){
		while(AtualizarAtributos.i < LeitorEscritor.likes_vetor.size()) {
			try {
				sem.acquire();
				//Atualizando dados.
				if(i < LeitorEscritor.likes_vetor.size()){
					
					j = i;
					i += 1;
					
					//Likes +
					likes = LeitorEscritor.likes_vetor.get(j);
					
					//Views +
					views = LeitorEscritor.views_vetor.get(j);
					
					//Dislikes +
					dislikes = LeitorEscritor.dislikes_vetor.get(j);
					
					GerenciarRecursos.video.addLikes(likes);
//					System.out.println(likes + " adicionados em Likes na thread " + thread_n);
					GerenciarRecursos.video.addViews(views);
//					System.out.println(views + " adicionados em Views na thread " + thread_n);
					GerenciarRecursos.video.addDislikes(dislikes);
//					System.out.println(dislikes + " adicionados em Dislikes na thread " + thread_n);
					
					GerenciarRecursos.video.imprimeVideo();
					
					sem.release();
				}//if i
				else {
					sem.release();
				}//else
			}//try
			catch(InterruptedException e) {
				e.printStackTrace();
				sem.release();
			}
		}//while
	}//run	
}
