package gerenciarrecursos;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.*; 

// RED LEITOR

// GREEN ESCRITOR
public class LeitorEscritor extends Thread{
    private boolean colorChanged, stop, reader; 
    private ColorSemaphore color;
    private String name;
    int leitor, escritor;

    private int views, likes, dislikes, iViews, iLikes, iDislikes; // variaveis auxiliares
    Video v1 = new Video();
    
    public LeitorEscritor(){}
    public LeitorEscritor(String name){
        super(name);
        this.name = name;
        this.color = ColorSemaphore.RED;
    }
    
    @Override
    public void run(){
        while(!stop){
            try {
                switch(this.color){
                    case RED:
                        if(reader){
                        Thread.sleep(70);
                            System.out.println("Lendo valores...");
                            System.out.printf("Valores lidos: \nViews:%d Likes: %d Dislikes: %d\n", views, likes, dislikes);
                            System.out.printf("Valores invalidos: \nViews:%d Likes: %d Dislikes: %d\n", iViews, iLikes, iDislikes);   
                        }
                        this.setReader(false); // acabou de ler
                        break;
                    case GREEN:
                        if(!reader){
                            Thread.sleep(70);
                            System.out.println("Escrevendo valores...");
                            v1.addViews(views);
                            v1.removeViews(iViews);
                            v1.addLikes(likes);
                            v1.removeLikes(iLikes);
                            v1.addDislikes(dislikes);
                            v1.removeDislikes(iDislikes);
                        }
                        this.setReader(true); // inicia leitura
                        break;
                }
                this.changeColor();
            }catch(InterruptedException ex){
                System.out.println("%s"+ ex);
            }
        }  
    }
    
    public synchronized void setReader(boolean reader){
        this.reader = reader;
    }
    
    public boolean getReader(){
        return this.reader;
    }
    
    public synchronized void stopSemaphoro(){
        this.stop = true;
    }
    
    private synchronized void changeColor(){
        switch(this.color){
            case RED:
                this.color = ColorSemaphore.GREEN;
                break;
            case GREEN:
                this.color = ColorSemaphore.RED;
                break;
        }
        this.colorChanged = true;
        notify();
    }
    
    public synchronized void waitColorChange(){
        while(!this.colorChanged){
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("%s"+ ex);
            }
        }
        this.colorChanged = false;
    }
    
    public ColorSemaphore getColor(){
        return color;
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
