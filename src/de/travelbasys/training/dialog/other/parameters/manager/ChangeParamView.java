package de.travelbasys.training.dialog.other.parameters.manager;

import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.UiComponent;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.Console;

/**
 * ist verantwortlich f�r den Dialog mit dem Benutzer, um alle Daten f�r das
 * changeparamieren der Datenbank abzufragen.
 * 
 * @author tba
 */
public class ChangeParamView implements View {

	/**
	 * 
	 */
	private ChangeParamModel model;
	private UiComponent customerDecisionComponent;

	public ChangeParamView(Model model) {
		this.model = (ChangeParamModel) model;
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
