import menu.ControllerMenu;
import menu.ModelMenu;
import menu.ViewMenu;

public class MainTest {

	public static void main(String[] args) {
		/*Ho spostato la inizializzazione del modello e della vista
		 * dentro al controller dal menu.
		 * essendo il menu la prima cosa a inizializzare,
		 * tanto vale inizializzarli dentro del costruttore dell controller
		 * (secondo me)
		 */
		ControllerMenu c = new ControllerMenu();
	}
}
