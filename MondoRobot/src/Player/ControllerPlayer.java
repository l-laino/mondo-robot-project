package Player;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.ControllerGame;
import handlers.KeyHandler;
import handlers.PlayableHandler;

public class ControllerPlayer extends PlayableHandler{

    public ControllerPlayer(ControllerGame gc, KeyHandler kplayer){

    }
    public class ModelPlayer{
        private ControllerGame gc;
        private KeyHandler kp;
    
        public ModelPlayer(ControllerGame gc, KeyHandler k){
            this.gc = gc;
            this.kp = k;
            defaultValues();
        }

        public void defaultValues() {
            setX(gc.getTileSize());
            setY(gc.getTileSize()*2-2);
            setSpeed(gc.getTileSize());
            setDirection("down");
            setSpriteCounter(0);
            setSpriteNum(0);
        }

        public void getPlayerImage() {
            try {
                setUp1(ImageIO.read(getClass().getResourceAsStream("/img/components/up1.png")));
                setUp2(ImageIO.read(getClass().getResourceAsStream("/img/components/up2.png")));
                setLeft1(ImageIO.read(getClass().getResourceAsStream("/img/components/left1.png")));
                setLeft2(ImageIO.read(getClass().getResourceAsStream("/img/components/left2.png")));
                setRight1(ImageIO.read(getClass().getResourceAsStream("/img/components/right1.png")));
                setRight2(ImageIO.read(getClass().getResourceAsStream("/img/components/right2.png")));
                setDown1(ImageIO.read(getClass().getResourceAsStream("/img/components/down1.png")));
                setDown2(ImageIO.read(getClass().getResourceAsStream("/img/components/down2.png")));
                
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
        public void update() {
            if(kp.isPressed()) {
                if (kp.isUp() == true) {
                    setDirection("up");
                    setY(getY() - getSpeed());
                }
                else if (kp.isDown() == true) {
                    setDirection("down");
                    setY(getY() + getSpeed());
                    
                }
                else if (kp.isLeft() == true) {
                    setDirection("left");
                    setX(getX() - getSpeed());
                }
                else if (kp.isRight() == true) {
                    setDirection("right");
                    setX(getX() + getSpeed()); 
                }
                
                //Animation Handler
                if(getSpriteNum() == 0) {
                    setSpriteNum(1);
                    setSpriteCounter(1);
                }
                else {
                    setSpriteNum(0);
                    setSpriteCounter(0);
                }		
            }
        }
        
        public void draw(Graphics2D g) {
            BufferedImage image = null;
            switch(getDirection()) {
            case "up":
                if (getSpriteNum() == 0) {
                    image = getUp1();				
                }
                else image = getUp2();
                break;
            case "down":
                if(getSpriteNum() == 0) {
                    image = getLeft1();
                }
                else image = getLeft2();
                break;
            case "left":
                if(getSpriteNum() == 0) {
                    image = getLeft1();
                }
                else image = getLeft2();
                break;
            case "right":
                if(getSpriteNum() == 0) {
                    image = getRight1();
                }
                else image = getRight2();
                break;
            }
            g.drawImage(image, getX(), getY(), gc.getTileSize(), gc.getTileSize(), null);
        }

    }



}

