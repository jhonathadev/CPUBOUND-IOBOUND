package gerenciarrecursos;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class DecrementaAtributos extends Thread{
	Semaphore sem2;
	public static int i;
	int thread_n, likes=-1, views=-1, dislikes=-1, j;
	
	public DecrementaAtributos() {}
	public DecrementaAtributos(Semaphore sem2, int thread_n) {
		this.sem2 = sem2;
		this.thread_n = thread_n;
	}
	
	@Override
	public void run(){
		while(i < LeitorEscritor.likes_vetor.size()) {
			try {
					//Atualizando dados.
				sem2.acquire();
				if(i<LeitorEscritor.likes_vetor.size()){
					
					j = i;
					i += 1;
					sem2.release();
					
					//Likes -
					likes = LeitorEscritor.likes_vetor_r.get(j);
				
					//Views - 
					views = LeitorEscritor.views_vetor_r.get(j);
				
					//Dislikes - 
					dislikes = LeitorEscritor.dislikes_vetor_r.get(j);
					
					GerenciarRecursos.video.removeLikes(likes);
					System.out.println(likes + " removidos em Likes na thread " + thread_n);
					GerenciarRecursos.video.removeViews(views);
					System.out.println(views + " removidos em Views na thread " + thread_n);
					GerenciarRecursos.video.removeDislikes(dislikes);
					System.out.println(dislikes + " removidos em Dislikes na thread " + thread_n);
				}//if
				else {
					sem2.release();
				}//else
			}//try
			catch(InterruptedException e) {
				e.printStackTrace();
				sem2.release();
			}
		}//while
	}//run	
}
