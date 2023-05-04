package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import game.ControllerGame;

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
				// Avvio il thread del conteggio dei secondi
				new ControllerGame();						 
			}catch(Exception invalidInput){
				v.errorLaunch();
			}
		}
		//chiude il submenu
		if(e.getActionCommand()=="Indietro"){
			this.v.closeSubMenu();
		}
	}
	public class ModelMenu {
		//campo dim per la creazione della matrice LxL per la mappa e support per assegnare i listener
		//e capire quando ci sia stato qualche cambiamento di parametro
		private int dim;
		private PropertyChangeSupport support;
		
		public ModelMenu() {
			this.dim = 0;
			this.support = new PropertyChangeSupport(this);
		}
		public int getDim() {
			return this.dim;
		}
		public void setDim(int d) {
			int temp = this.dim;
			this.dim = d;
			this.support.firePropertyChange("dim",temp,d);
		}
		public void addListener(PropertyChangeListener listener) {
			this.support.addPropertyChangeListener(listener);
		}
	}
}

