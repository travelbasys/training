package de.travelbasys.training.dialog.menu.dbtype;

import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.UiComponent;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.Console;

/**
 * Ist verantwortlich dem Benutzer ein Hauptmenü zur Verfügung zu stellen,
 * welches weitere Komponenten aufrufen kann.
 * 
 * @autor tba
 */
public class ChooseDatabaseTypeView implements View {

	/**
	 * 
	 */
	private ChooseDatabaseTypeModel model;
	private UiComponent customerDecisionComponent;

	public ChooseDatabaseTypeView(Model model) {
		this.model = (ChooseDatabaseTypeModel) model;
		customerDecisionComponent = new UiComponent();
		customerDecisionComponent.setType(Integer.class);
	}

	public AbstractUiComponent getcustomerDecisionComponent() {
		return customerDecisionComponent;
	}

	/**
	 * Diese Methode startet den Dialog.
	 */
	public void run() {
		if (model.isLanguageChanged()) {
			model.init();
		}

		for (String s : model) {
			Console.println(s);
		}
		customerDecisionComponent.run2();
	}
}
