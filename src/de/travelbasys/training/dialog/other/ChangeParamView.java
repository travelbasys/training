package de.travelbasys.training.dialog.other;

import java.util.ArrayList;

import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.UiComponent;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.Console;

/**
 * ist verantwortlich für den Dialog mit dem Benutzer, um alle Daten für das
 * changeparamieren der Datenbank abzufragen.
 * 
 * @autor tba
 */
public class ChangeParamView extends ArrayList<UiComponent> implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ChangeParamModel model;
	private UiComponent customerDecisionComponent;

	public ChangeParamView(Model model) {
		this.model = (ChangeParamModel) model;
		customerDecisionComponent = new UiComponent();
		customerDecisionComponent.setType(Integer.class);
		add(customerDecisionComponent);
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
