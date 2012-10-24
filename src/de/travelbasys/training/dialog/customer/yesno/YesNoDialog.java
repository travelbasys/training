package de.travelbasys.training.dialog.customer.yesno;

import de.travelbasys.training.framework.Dialog;

/**
 * Hat die Aufgabe einen Ja/Nein Dialog mit dem Benutzer zu führen.
 * 
 * Die Implementierung muss eine Fragestellung zugewiesen bekommen.
 */
public class YesNoDialog implements Dialog {
	private YesNoModel model;
	private YesNoView view;
	private YesNoControl control;

	/**
	 * Führt den initalisierten View aus.
	 */
	@Override
	public void run() {
		view.run();
	}

	/**
	 * Initalisiert die MVC-Komponenten des Ja/Nein-Dialoges.
	 * 
	 * @param key
	 *            Der Schlüssel für die Fragestellung.
	 */
	public void init(String key) {
		model = new YesNoModel(key);
		control = new YesNoControl(model);
		view = new YesNoView(model, control);
		view.init(model);
		control.init(model, view);
	}

	/**
	 * Holt die eingegebene Wahl des Users aus dem Model.
	 * 
	 * @return Die eingegebene Wahl des Users.
	 */
	public boolean getFlag() {
		return model.getFlag();
	}
}
