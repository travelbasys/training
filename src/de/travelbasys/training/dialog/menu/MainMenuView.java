package de.travelbasys.training.dialog.menu;

import java.util.ArrayList;

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
public class MainMenuView extends ArrayList<UiComponent> implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainMenuModel model;
	private UiComponent customerDecisionComponent;

	public MainMenuView(Model model) {
		this.model = (MainMenuModel) model;
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
