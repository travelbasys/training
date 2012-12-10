package experiment.javafx.travelbasys.dialog.other.ChangeConfiguration;

import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

public class ChangeConfigurationControlGUI {

	private ChangeConfigurationViewGUI view;
	private ChangeConfigurationModelGUI model;

	public void init(Model model, View view) {
		this.view = (ChangeConfigurationViewGUI) view;
		this.model = (ChangeConfigurationModelGUI) model;
	}
}
