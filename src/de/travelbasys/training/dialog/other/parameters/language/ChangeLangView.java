package de.travelbasys.training.dialog.other.parameters.language;

import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.UiComponent;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.Console;

/**
 * ist verantwortlich für den Dialog mit dem Benutzer, um alle Daten für das
 * changelangieren der Datenbank abzufragen.
 * 
 * @author tba
 */
public class ChangeLangView implements View {

	/**
	 * 
	 */
	private ChangeLangModel model;
	private UiComponent customerDecisionComponent;

	public ChangeLangView(Model model) {
		this.model = (ChangeLangModel) model;
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
