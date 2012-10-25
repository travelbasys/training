package de.travelbasys.training.dialog.customer.yesno;

import de.travelbasys.training.framework.AbstractControl;
import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.util.AppContext;

/**
 * steuert den Dialog mit dem Benutzer zur Auswahl eines Menüpunktes.
 */

public class YesNoControl {
	private YesNoModel model;
	private YesNoView view;

	/**
	 * Weißt der Klasse ein Model zu.
	 * 
	 * @param model
	 *            Das Model des Packages.
	 */
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
			model.setFlag(true);
			break;
		case 2:
			model.setFlag(false);
			AppContext.printMessage("Abort");
			break;
		default:
			// VORERST CHOOSERRCOMP ALS ALTERNATIVE FEHLERAUSGABE!!!
			throw new Exception("ChooseErrComp");
		}

	}

	/**
	 * setzt den Input Handler in der DecisionComponent des View, so dass das
	 * Decision Attribut des Model den eingebenen Wert bekommt.
	 */
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
