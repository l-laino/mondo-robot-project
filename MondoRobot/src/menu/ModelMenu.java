package menu;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelMenu {
	//campo dim per la creazione della matrice LxL per il mappa e support per assegnare i listener
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
