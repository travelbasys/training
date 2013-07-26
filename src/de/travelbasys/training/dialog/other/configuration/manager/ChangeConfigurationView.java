package de.travelbasys.training.dialog.other.configuration.manager;

import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.UiComponent;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.Console;

/**
 * ist verantwortlich für den Dialog mit dem Benutzer, um alle Daten für das
 * changeconfigurationieren der Datenbank abzufragen.
 * 
 * @author tba
 */
public class ChangeConfigurationView implements View {

	/**
	 * 
	 */
	private ChangeConfigurationModel model;
	private UiComponent customerDecisionComponent;

	public ChangeConfigurationView(Model model) {
		this.model = (ChangeConfigurationModel) model;
		customerDecisionComponent = new UiComponent();
		customerDecisionComponent.setType(Integer.class);
	}

	public AbstractUiComponent getcustomerDecisionComponent() {
		return customerDecisionComponent;
	}

	public void run() {

		for (String s : model) {
			Console.println(s);
		}
		customerDecisionComponent.run2();
	}
}
