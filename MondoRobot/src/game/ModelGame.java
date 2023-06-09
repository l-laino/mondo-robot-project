package game;

import javax.swing.JPanel;

import mappa.ControllerMappa.ModelMappa;
import menu.ControllerMenu;
import menu.ControllerMenu.ModelMenu;

public class ModelGame extends JPanel{       // Bisogna aggiungere implements Runnable per i metodi dei thread 
    
	private final int SIZE = 16;
	private final int SCALE = 3;
    private final int TILESIZE = SIZE * SCALE;
    private int dim;
    private int WIDTH;
    private int HEIGHT;
    private final int FPS = 60;
    private final int INTERVAL = 1000000000 / getFPS();

    public int getTILESIZE() {
		return TILESIZE;
	}

	public int getFPS() {
		return FPS;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public int getWIDTH() {
		return WIDTH;
	}
	
	public void setHEIGHT(int dim) {
		this.HEIGHT = dim;
	}

	public void setWIDTH(int dim) {
		this.WIDTH = dim;
	}

	public int getDim() {
		return dim;
	}

	public void setDim(int dim) {
		this.dim = dim;
	}
}
