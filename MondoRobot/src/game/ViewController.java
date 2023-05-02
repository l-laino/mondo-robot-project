package game;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewController extends JPanel{
    private JFrame window;
    private ControllerGame gc;
    public ViewController(ControllerGame gc){
        this.gc = gc;

        this.window = new JFrame("Mondo Robot");
        this.window.setResizable(false);
        this.window.setPreferredSize(new Dimension(gc.getWidth() * gc.getTileSize(), gc.getHeigth() * gc.getTileSize()));
        
        this.addKeyListener(gc.getKH());
        this.setFocusable(true);
        
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
