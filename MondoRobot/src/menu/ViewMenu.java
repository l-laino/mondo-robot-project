package menu;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class ViewMenu implements PropertyChangeListener{
	private JFrame frame, subFrame;
	private JPanel panelCenter, panelSouth, subPanel;
	private JLabel label, subLabel;
	private JButton btnNew, btnContinue, subBtn;
	private JTextField subField;
	private JSeparator subSeparator;
	
	public ViewMenu() 
	{
		//inizializzazione dei campi
		frame = new JFrame();
		panelCenter = new JPanel();
		panelSouth = new JPanel();
		label = new JLabel("Benvenuto!");
		btnNew = new JButton("Nuova Partita");
		subBtn = new JButton("Invia");
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
	
	//subButton viene inizializzato prima per evitare un errore
	//secondo me questo è sbagliato, da riguardare
	public void SubMenu() {
		this.subFrame = new JFrame();
		this.subPanel = new JPanel(new GridLayout(0,2));
		this.subLabel = new JLabel(" Inserisci la dimensione della mappa: ");
		this.subField = new JTextField();
		this.subSeparator = new JSeparator();


		subPanel.add(subLabel);
		subPanel.add(subField);
		subPanel.add(subSeparator);
		subPanel.add(subBtn);
		subFrame.add(subPanel, BorderLayout.CENTER);
		
		subFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		subFrame.setLocationRelativeTo(frame);
		subFrame.pack();
		subFrame.setVisible(true);
	}
	public void addListener(ActionListener controller) {
		this.btnNew.addActionListener(controller);
		this.btnContinue.addActionListener(controller);
		this.subBtn.addActionListener(controller);
	}
	//da fare ancora la verifica se è testo o no 
	public int getTextField() {
		return Integer.parseInt(this.subField.getText());
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}
	
}
