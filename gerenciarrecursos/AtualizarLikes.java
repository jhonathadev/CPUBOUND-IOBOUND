package gerenciarrecursos;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.*;
import java.lang.Thread;

public class AtualizarLikes extends Thread{
	Semaphore sem;
	int i = 0, thread_n;
	
	public AtualizarLikes() {}
	public AtualizarLikes(Semaphore sem, int i, int thread_n) {
		this.sem = sem;
		this.i = i;
		this.thread_n = thread_n;
	}
	@Override
	public void run(){
		while(i<LeitorEscritor.likes_vetor.size()) {
			try {
				sem.acquire();
				if(i<LeitorEscritor.likes_vetor.size())
				{
					GerenciarRecursos.video.addLikes(LeitorEscritor.views_vetor.get(i));
					i += 1;
					System.out.println(LeitorEscritor.views_vetor.get(i-1) + " contabilizados em Likes na thread " + thread_n);
					sem.release();
				}
			}//try
			catch(InterruptedException e) {
				e.printStackTrace();
				sem.release();
			}
		}//while
	}//run	
}
