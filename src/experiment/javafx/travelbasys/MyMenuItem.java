package experiment.javafx.travelbasys;

import javafx.scene.control.MenuItem;
import de.travelbasys.training.util.AppContext;

public class MyMenuItem extends MenuItem {

	public MyMenuItem(String string) {
		setStyle("");
		setText(AppContext.getErrString(string));
	}
}