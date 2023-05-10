package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewMenu implements PropertyChangeListener {
	private JFrame frame;
	private JPanel panelCenter, panelSouth;
	private JLabel label;
	private JButton btnNew, btnContinue;
	private SubMenu v2;

	public ViewMenu() {
		// inizializzazione dei campi
		frame = new JFrame();
		panelCenter = new JPanel();
		panelSouth = new JPanel();
		label = new JLabel("Benvenuto!");

		btnNew = new JButton("Nuova Partita");
		btnContinue = new JButton("Continua");

		// assemblaggio dei panneli e configurazioni di dimensioni
		panelCenter.add(label);
		panelCenter.setPreferredSize(new Dimension(700, 300));

		panelSouth.add(btnNew);
		panelSouth.add(btnContinue);
		panelSouth.setPreferredSize(new Dimension(100, 100));

		// assemblaggio del frame
		frame.add(panelCenter, BorderLayout.CENTER);
		frame.add(panelSouth, BorderLayout.SOUTH);

		/*
		 * parte di "default"
		 * define il titolo dellpa aplicazione
		 * definisce il mentodo di finalizzazione
		 * definisce che viene aperto nel centro della pagina
		 */
		frame.setTitle("Mondo Robot");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	public void CreaSubMenu(ControllerMenu controller) {
		SubMenu v2 = new SubMenu();
		this.v2 = v2;
		v2.addListener(controller);

	}

	public void addListener(ActionListener controller) {
		this.btnNew.addActionListener(controller);
		this.btnContinue.addActionListener(controller);
	}

	// da fare la eccezione
	public int getTextField() {
		return Integer.parseInt(this.v2.subField.getText());
	}

	public void closeViewMenu() {
		this.frame.dispose();
	}

	public void closeSubMenu() {
		v2.subFrame.dispose();
	}

	public void errorLaunch() {
		JLabel subError = new JLabel("Devi inserire un numero pari o maggiore di 10.");
		v2.subPanel.add(subError);
		subError.setForeground(Color.red);
		v2.subFrame.pack();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub

	}

	public class SubMenu implements PropertyChangeListener {
		private JFrame subFrame;
		private JPanel subPanel;
		private JLabel subLabel;
		private JTextField subField;
		private JButton subBtnBack, subBtnInvia;

		public SubMenu() {
			this.subFrame = new JFrame();
			this.subPanel = new JPanel(new GridLayout(0, 2));
			this.subLabel = new JLabel(" Inserisci la dimensione della mappa: ");
			this.subField = new JTextField();
			this.subBtnBack = new JButton("Indietro");
			this.subBtnInvia = new JButton("Invia");

			subPanel.add(subLabel);
			subPanel.add(subField);
			subPanel.add(subBtnBack);
			subPanel.add(subBtnInvia);
			subFrame.add(subPanel, BorderLayout.CENTER);

			subFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			subFrame.pack();
			subFrame.setVisible(true);
			subFrame.setLocationRelativeTo(null);
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
