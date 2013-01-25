package de.travelbasys.training.dialog.other.parameters.database;

import de.travelbasys.training.framework.AbstractControl;
import de.travelbasys.training.framework.AbstractUiComponent;

/**
 * Diese Klasse Kontrolliert Benutzereingaben.
 * 
 * @author tba
 * 
 */
public class ChangeDBControl {

	public void check(Object value) throws Exception {
		if (((String) value).isEmpty())
			throw new Exception("EmptyFieldErr");

	}

	public ChangeDBControl(final ChangeDBModel model, ChangeDBView view) {

		AbstractUiComponent uic;

		uic = view.getchangeDBComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				check(value);
				model.setDBkey((String) value);
			}
		});
	}
}
