package menu;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewMenu implements PropertyChangeListener{
	private JFrame frame;
	private JPanel panelCenter;
	private JPanel panelSouth;
	private JLabel label;
	private JButton btnNew;
	private JButton btnContinue;
	
	public ViewMenu() 
	{
		//inizializzazione dei campi
		frame = new JFrame();
		panelCenter = new JPanel();
		panelSouth = new JPanel();
		label = new JLabel("Benvenuto!");
		btnNew = new JButton("Nuova partita");
		btnContinue = new JButton("Continua");
		
		//i componendi vengono messi nei panelli, che vengono messi nel frame
		panelCenter.add(label);
		panelSouth.add(btnNew);
		panelSouth.add(btnContinue);

		frame.add(panelCenter, BorderLayout.CENTER);
		frame.add(panelSouth,BorderLayout.SOUTH);
		
		/*parte di "default"
		 * define il titolo dellpa aplicazione
		 * definisce il mentodo di finalizzazione
		 * definisce che viene aperto nel centro della pagina
		 * 
		 * */
		frame.setTitle("Mondo Robot");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}
	public void addListener(ActionListener controller) {
		this.btnNew.addActionListener(controller);
		this.btnContinue.addActionListener(controller);
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}
	
}
