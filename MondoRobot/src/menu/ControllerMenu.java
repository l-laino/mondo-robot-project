package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerMenu implements ActionListener{
	//il controller deve ricevere il modello e la vista cui deve controllare
	private ModelMenu m;
	private ViewMenu v;
	
	public ControllerMenu(ModelMenu model, ViewMenu view) {
		this.m = model;
		this.v = view;
		
		//il controller deve "ascoltare" la vista per prendere la interazione con l'utente
		v.addListener(this);
		//la vista ascolta il modello per compiere il doppio aggancio (?)
		m.addListener(this.v);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="Nuova Partita") {
			this.v.CreaSubMenu(this);;
		}
		if(e.getActionCommand()=="Continua") {
			//code
		}//verificando che prende e aggiorna la variabile dal campo di testo
		if(e.getActionCommand()=="Invia") {
			m.setDim(v.getTextField());
			System.out.println(m.getDim());
		}
		if(e.getActionCommand()=="Indietro"){
			this.v.closeSubMenu();
		}
	}
}

