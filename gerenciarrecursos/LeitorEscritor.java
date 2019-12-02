package gerenciarrecursos;

import java.util.concurrent.Semaphore;

import sun.applet.Main;

// RED LEITOR

// GREEN ESCRITOR
public class LeitorEscritor extends Thread{
        
    private int views, likes, dislikes, iViews, iLikes, iDislikes; // variaveis auxiliares
    Video v1 = new Video();
    Semaphore sem;
    public LeitorEscritor(){}
    
    
    public LeitorEscritor(Semaphore sem) {
		super();
		this.sem = sem;
	}


	@Override
    public void run(){
		while(GerenciarRecursos.scanner.hasNext() && GerenciarRecursos.scanner2.hasNext()) {
			try {
				if(GerenciarRecursos.scanner.hasNext() && GerenciarRecursos.scanner2.hasNext()) {
					sem.acquire();
					this.addViews(GerenciarRecursos.scanner.nextInt());
			        this.removeViews(GerenciarRecursos.scanner2.nextInt());
			        this.addLikes(GerenciarRecursos.scanner.nextInt());
			        this.removeLikes(GerenciarRecursos.scanner2.nextInt());
			        this.addDislikes(GerenciarRecursos.scanner.nextInt());
			        this.removeDislikes(GerenciarRecursos.scanner2.nextInt());        
//					System.out.println("Lendo valores...");
			        System.out.printf("%d|%d|%d\n", views, likes, dislikes);
//			        System.out.printf("Valores lidos: Views:%d Likes: %d Dislikes: %d\n", views, likes, dislikes);
//			        System.out.printf("Valores invalidos: \nViews:%d Likes: %d Dislikes: %d\n", iViews, iLikes, iDislikes);
//			        System.out.println("Escrevendo valores...");
			        v1.addViews(views);
			        v1.removeViews(iViews);
			        v1.addLikes(likes);
			        v1.removeLikes(iLikes);
			        v1.addDislikes(dislikes);
			        v1.removeDislikes(iDislikes);
				}//if
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			sem.release();
		}//while
	}
      
    
    public synchronized void removeLikes(int likes){
        this.iLikes = likes;
    }
    
    public synchronized void removeViews(int views){
        this.iViews = views;
    }
    
    public synchronized void removeDislikes(int dislikes){
        this.iDislikes = dislikes;
    }
    
    public synchronized void addLikes(int likes){
        this.likes = likes;
    }
    
    public synchronized void addDislikes(int dislikes){
        this.dislikes = dislikes;
    }
    
    public synchronized void addViews(int views){
        this.views = views;
    }
    
    
}
