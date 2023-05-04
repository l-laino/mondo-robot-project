package components;

import java.awt.image.BufferedImage;

public abstract class Caselle{
    private boolean atraversabile;
    private Boolean state;
    private BufferedImage image;
    private boolean collision;
    
    public Caselle(){
        this.setAtraversabile(true);
        this.setState(null);
    }

    public boolean isAtraversabile() {
        return atraversabile;
    }

    public void setAtraversabile(boolean atraversabile) {
        this.atraversabile = atraversabile;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public BufferedImage getImage () {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void setCollision(boolean col){
        this.collision = col;
    }

    public boolean getCollision(){
        return this.collision;
    }
    
}
