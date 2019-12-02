package gerenciarrecursos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LeitorEscritor extends Thread{
    private boolean colorChanged, stop; 
    private ColorSemaphore color;
    private String name;
    private int views, likes, dislikes; // variaveis auxiliares
    Video v1 = new Video();
    public LeitorEscritor(){}
    public LeitorEscritor(String name){
        this.name = name;
        this.color = ColorSemaphore.RED;
        new Thread(this).start();
    }
    
    @Override
    public void run(){
        while(!stop){
            try {
                switch(this.color){
                    case RED:
                        Thread.sleep(700);
                        break;
                    case YELLOW:
                        Thread.sleep(400);
                        break;
                    case GREEN:
                        Thread.sleep(900);
                        break;
                }
                this.changeColor();
            }catch(InterruptedException ex){
                Logger.getLogger(LeitorEscritor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public synchronized void stopSemaphoro(){
        this.stop = true;
    }
    
    private synchronized void changeColor(){
        switch(this.color){
            case RED:
                this.color = ColorSemaphore.GREEN;
                break;
            case YELLOW:
                this.color = ColorSemaphore.RED;
                break;
            case GREEN:
                this.color = ColorSemaphore.YELLOW;
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
                Logger.getLogger(LeitorEscritor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.colorChanged = false;
    }
    
    public ColorSemaphore getColor(){
        return color;
    }
    
    public void recebeValores(int views, int likes, int dislikes){
        this.views = views;
        this.likes = likes;
        this.dislikes = dislikes;
    }
    
}
