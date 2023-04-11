package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerMenu implements ActionListener{
	private ModelMenu m;
	private ViewMenu v;
	
	public ControllerMenu() {
		//inizio una nuova istanza dell modello e della vista
		this.m = new ModelMenu();
		this.v = new ViewMenu();
		
		//il controller deve "ascoltare" la vista per prendere la interazione con l'utente
		//la vista ascolta il modello per il doppio riaggancio
		v.addListener(this);
		m.addListener(this.v);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Inizia il sub menu
		if(e.getActionCommand()=="Nuova Partita") {
			this.v.CreaSubMenu(this);
		}
		//ancora da implementare dopo aver una cartella con le risorse
		if(e.getActionCommand()=="Continua") {
			try {
				//
			} catch (Exception noSavedGame) {
				// TODO: handle exception
			}
		}
		//da fare il controlo se il numero è maggiore di 10 crea la matrice e dispose entrambi i menu
		if(e.getActionCommand()=="Invia") {
			try{
				m.setDim(v.getTextField());
				if(m.getDim() < 10) new Exception();
			}catch(Exception invalidInput){
				v.errorLaunch();
			}
		}
		//chiude il submenu
		if(e.getActionCommand()=="Indietro"){
			this.v.closeSubMenu();
		}
	}
}

