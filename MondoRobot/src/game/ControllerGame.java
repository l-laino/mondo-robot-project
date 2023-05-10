package game;

import java.awt.event.KeyListener;

import Player.ControllerPlayer;
import handlers.KeyHandler;
import mappa.ControllerMappa;

public class ControllerGame implements Runnable{
    private GameModel gm;
    private ViewGame gv;
    private KeyHandler kh;
    private ControllerMappa cm;
    private ControllerPlayer player;    

    public ControllerGame(int dim){
        this.kh = new KeyHandler();
        this.gm = new GameModel(dim);
        this.gv = new ViewGame(this);
        startGameThreads();
        cm = new ControllerMappa(dim);
        this.player = new ControllerPlayer(this, this.kh);
    }

    public void startGameThreads() {
        this.gm.gameThread = new Thread(this);
        this.gm.gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = this.gm.INTERVAL;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        
        while(this.gm.gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (delta > 1) {
                this.gv.update(null);
                this.gv.repaint();
                delta--;
            }
        }
    }
    
    public class GameModel{

        private final int SIZE = 16;
        private final int SCALE = 3;
        private final int TILESIZE = this.SIZE * this.SCALE;
        private final int FPS = 60;
	    private final int INTERVAL = 1000000000 / FPS;

        private int dim;
        private int width;
        private int heigth;

        private Thread gameThread;
        private Thread playerThread;

        //manca tile e player

        public GameModel(int dim){
            this.dim = dim;
            this.width = this.dim + 2;
            this.heigth = this.dim + 4;
        }
    }

    public int getTileSize() {
        return gm.TILESIZE;
    }

    public int getWidth() {
        return gm.width;
    }

    public int getHeigth() {
        return gm.heigth;
    }
    
    public KeyListener getKH(){
        return this.kh;
    }
}
