package gerenciarrecursos;

import java.util.ArrayList;

public class Video {
    private int likes = 0;
    private int dislikes = 0;
    private int views = 0;
    
    private static ArrayList<Integer> readLines = new ArrayList<Integer>(1000);
    
    public synchronized boolean controlArrayList(int currentLine) {
        if (!readLines.contains(currentLine)) { // se a linha atual ainda não foi lida, a mesma é adicionada ao arraylist
            readLines.add(currentLine);
            return true;
        } else {
            return false;
        }
    }
    
    public synchronized void setLikes(int likes) {
        this.likes = likes;
    }
    
    public synchronized void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }
    
    public synchronized void setViews(int views) {
        this.views = views;
    }
    
    public int getLikes() {
        return this.likes;
    }

    public int getDislikes() {
        return this.dislikes;
    }

    public int getViews() {
        return this.views;
    }
}
