package de.travelbasys.training.dialog.customer.yesno;

import de.travelbasys.training.framework.AbstractControl;
import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.util.AppContext;

/**
 * Diese Klasse Kontrolliert Benutzereingaben.
 * 
 * @author tba
 * 
 */

public class YesNoControl {
	private YesNoModel model;
	private YesNoView view;

	public YesNoControl(YesNoModel model) {
		this.model = model;
	}

	private void checkdecision(Object value) throws Exception {

		int decision = (Integer) value;
		if (decision >= 1 && decision <= 2) {
			model.setEndFlag();
		}
		switch (decision) {
		case 1:
			model.setDeleteFlag(true);
			break;
		case 2:
			model.setDeleteFlag(false);
			AppContext.printMessage("Abort");
			break;
		default:
			AppContext.printErrString("ChooseErr");
			break;
		}

	}

	public void init(YesNoModel model, YesNoView view) {
		this.model = (YesNoModel) model;
		this.view = (YesNoView) view;

		AbstractUiComponent uic;

		uic = this.view.getcustomerdecisionComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				checkdecision(value);
				YesNoControl.this.model.setDecision((Integer) value);
			}
		});
	}
}
