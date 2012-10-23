package de.travelbasys.training.dialog.customer.yesno;

import de.travelbasys.training.framework.Dialog;

/**
 * ist verantwortlich für das löschen eines Benutzers aus der Datenbank
 * 
 * @author tba
 * 
 */
public class YesNoDialog implements Dialog {
	private YesNoModel model;
	private YesNoView view;
	private YesNoControl control;

	@Override
	public void run() {
		view.run();
	}
//KEY MUSS VORHANDEN SEIN (FRAGESTELLUNG DES PROGRAMMES AN USER)
	public void init(String key) {
		model = new YesNoModel(key);
		control = new YesNoControl(model);
		view = new YesNoView(model, control);
		view.init(model);
		control.init(model, view);
	}

	public boolean getFlag() {
		return model.getFlag();
	}
}
