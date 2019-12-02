package gerenciarrecursos;

public class Video{
    private int likes = 0;
    private int dislikes = 0;
    private int views = 0;
   
    /*
    public synchronized void addAll(int likes, int views, int dislikes){
        this.addViews(views);
        this.addLikes(likes);
        this.addDislikes(dislikes);
    }
    
    public synchronized void removeAll(int likes, int views, int dislikes){
        this.removeViews(views);
        this.removeLikes(likes);
        this.removeDislikes(dislikes);
    }
    */
    
    public synchronized void removeLikes(int likes){
        this.likes -= likes;
    }
    
    public synchronized void removeViews(int views){
        this.views -= views;
    }
    
    public synchronized void removeDislikes(int dislikes){
        this.dislikes -= dislikes;
    }
    
    public synchronized void addLikes(int likes){
        this.likes += likes;
    }
    
    public synchronized void addDislikes(int dislikes){
        this.dislikes += dislikes;
    }
    
    public synchronized void addViews(int views){
        this.views += views;
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
