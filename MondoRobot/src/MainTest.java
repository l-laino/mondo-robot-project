import menu.ControllerMenu;
import menu.ModelMenu;
import menu.ViewMenu;

public class MainTest {

	public static void main(String[] args) {
		//inizia modello, vista e poi utilizza entrambi per creare il controller
		ModelMenu m = new ModelMenu();
		ViewMenu v = new ViewMenu();
		ControllerMenu c = new ControllerMenu(m,v);
	}
}
