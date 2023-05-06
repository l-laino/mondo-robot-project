package Player;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ModelPlayer {
    
    public ModelPlayer(ModelGame gp, KeyController keyH) {
		this.gp = gp;
		this.keyH = keyH;
		defaultValues();
		getPlayerImage();
	}

    public void defaultValues() {
		setX(gp.getTILESIZE());
		setY(gp.getTILESIZE()*2-2);
		setSpeed(gp.getTILESIZE());
		setDirection("down");
		setSpriteCounter(0);
		setSpriteNum(0);
	}

    public void getPlayerImage() {
		try {
			setUp1(ImageIO.read(getClass().getResourceAsStream("/entities/up1.png")));
			setUp2(ImageIO.read(getClass().getResourceAsStream("/entities/up2.png")));
			setLeft1(ImageIO.read(getClass().getResourceAsStream("/entities/left1.png")));
			setLeft2(ImageIO.read(getClass().getResourceAsStream("/entities/left2.png")));
			setRight1(ImageIO.read(getClass().getResourceAsStream("/entities/right1.png")));
			setRight2(ImageIO.read(getClass().getResourceAsStream("/entities/right2.png")));
			setDown1(ImageIO.read(getClass().getResourceAsStream("/entities/down1.png")));
			setDown2(ImageIO.read(getClass().getResourceAsStream("/entities/down2.png")));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

    public void update() {
		if(keyH.isPressed()) {
			if (keyH.isUp() == true) {
				setDirection("up");
				setY(getY() - getSpeed());
			}
			else if (keyH.isDown() == true) {
				setDirection("down");
				setY(getY() + getSpeed());
				
			}
			else if (keyH.isLeft() == true) {
				setDirection("left");
				setX(getX() - getSpeed());
			}
			else if (keyH.isRight() == true) {
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
}

