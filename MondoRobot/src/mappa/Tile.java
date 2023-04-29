package mappa;

import java.awt.image.BufferedImage;

public class Tile {
    private BufferedImage image;
    private boolean collision;
    
    public BufferedImage getImage () {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    
}
