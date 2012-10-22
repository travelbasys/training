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

		model = new YesNoModel();
		control = new YesNoControl(model);
		view = new YesNoView(model, control);
		view.run();
	}

	public boolean getFlag() {
		return model.getDeleteFlag();
	}
}
