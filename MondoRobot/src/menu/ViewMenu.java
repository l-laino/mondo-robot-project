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
import javax.swing.JTextField;

public class ViewMenu implements PropertyChangeListener{
	private JFrame frame;
	private JPanel panelCenter, panelSouth;
	private JLabel label;
	private JButton btnNew, btnContinue;
	private SubMenu v2;
	
	public ViewMenu() 
	{
		//inizializzazione dei campi
		frame = new JFrame();
		panelCenter = new JPanel();
		panelSouth = new JPanel();
		label = new JLabel("Benvenuto!");
		btnNew = new JButton("Nuova Partita");
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
	public void CreaSubMenu(ControllerMenu controller) {
		SubMenu v2 = new SubMenu();
		this.v2 = v2;
		v2.addListener(controller);
		
	}
	
	//subButton viene inizializzato prima per evitare un errore
	//secondo me questo è sbagliato, da riguardare
	public void addListener(ActionListener controller) {
		this.btnNew.addActionListener(controller);
		this.btnContinue.addActionListener(controller);
	}
	//da fare ancora la verifica se è testo o no 
	public int getTextField() {
		try {
			return Integer.parseInt(this.v2.subField.getText());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	public void closeSubMenu() {
		v2.subFrame.dispose();
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}
	public class SubMenu implements PropertyChangeListener{
		private JFrame subFrame;
		private JPanel subPanel;
		private JLabel subLabel;
		private JTextField subField;
		private JButton subBtnBack, subBtnInvia;
		
		public SubMenu() {
			this.subFrame = new JFrame();
			this.subPanel = new JPanel(new GridLayout(0,2));
			this.subLabel = new JLabel(" Inserisci la dimensione della mappa: ");
			this.subField = new JTextField();
			this.subBtnBack = new JButton("Indietro");
			this.subBtnInvia = new JButton("Invia");

			subPanel.add(subLabel);
			subPanel.add(subField);
			subPanel.add(subBtnBack);
			subPanel.add(subBtnInvia);
			subFrame.add(subPanel, BorderLayout.CENTER);
			
			subFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			subFrame.setLocationRelativeTo(frame);
			subFrame.pack();
			subFrame.setVisible(true);
		}
		public void addListener(ActionListener controller) {
			this.subBtnBack.addActionListener(controller);
			this.subBtnInvia.addActionListener(controller);
		}
		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			// TODO Auto-generated method stub
		}
		
	}
	
}
