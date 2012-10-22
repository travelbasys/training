package de.travelbasys.training.db;

import de.travelbasys.training.framework.AbstractControl;
import de.travelbasys.training.framework.AbstractUiComponent;

/**
 * Diese Klasse Kontrolliert Benutzereingaben.
 * 
 * @author tba
 * 
 */
public class ChangeDBControl {

	private ChangeDBModel model;
	private ChangeDBView view;

	public ChangeDBControl(ChangeDBModel model) {
		this.model = model;
	}

	public void check(Object value) throws Exception {
		if (((String) value).isEmpty())
			throw new Exception("EmptyFieldErr");

	}

	public void init(ChangeDBModel model, ChangeDBView view) {
		this.model = (ChangeDBModel) model;
		this.view = (ChangeDBView) view;

		AbstractUiComponent uic;

		uic = this.view.getchangeDBComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				check(value);
				ChangeDBControl.this.model.setDBkey((String) value);
			}
		});
	}
}
