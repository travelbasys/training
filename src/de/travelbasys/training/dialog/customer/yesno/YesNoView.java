package de.travelbasys.training.dialog.customer.yesno;

import java.util.ArrayList;

import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.UiComponent;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.Console;

/**
 * stellt einen View innerhalb des Ja/Nein-Dialoges dar.
 */
public class YesNoView extends ArrayList<UiComponent> implements View {
	private static final long serialVersionUID = 1L;
	private YesNoModel model;
	private UiComponent customerDecisionComponent;

	public AbstractUiComponent getcustomerdecisionComponent() {
		return customerDecisionComponent;
	}

	/**
	 * Weißt der Klasse ein Model zu.
	 * 
	 * @param model
	 *            Das Model des Packages.
	 */
	public YesNoView(YesNoModel model) {
		super();
		this.model = model;
	}

	/**
	 * Gibt die Liste aus dem Model aus und ruft jede Komponente aus einer Liste
	 * von Komponenten auf.
	 */
	public void run() {
		do {
			for (String s : model) {
				Console.println(s);
			}
			for (UiComponent uiComponent : this) {
				uiComponent.run2();
			}
		} while (model.getEndFlag() == false);
	}

	/**
	 * Erzeugt und initalisiert eine Komponente mit dem Model, welche einer
	 * Liste hinzugefügt wird.
	 */
	@Override
	public void init(Model model) {
		this.model = (YesNoModel) model;
		customerDecisionComponent = new UiComponent();
		customerDecisionComponent.setValue(this.model.getDecision());
		add(customerDecisionComponent);
	}
}
