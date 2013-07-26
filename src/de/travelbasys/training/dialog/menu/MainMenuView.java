package de.travelbasys.training.dialog.menu;

import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.UiComponent;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.Console;

/**
 * Ist verantwortlich dem Benutzer ein Hauptmenü zur Verfügung zu stellen,
 * welches weitere Komponenten aufrufen kann.
 * 
 * @author tba
 */
public class MainMenuView implements View {

	/**
	 * 
	 */
	private MainMenuModel model;
	private UiComponent customerDecisionComponent;

	public MainMenuView(Model model) {
		this.model = (MainMenuModel) model;
		customerDecisionComponent = new UiComponent();
		customerDecisionComponent.setType(Integer.class);
	}

	public AbstractUiComponent getcustomerDecisionComponent() {
		return customerDecisionComponent;
	}

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
