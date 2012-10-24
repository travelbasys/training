package de.travelbasys.training.dialog.customer.yesno;

import de.travelbasys.training.framework.AbstractControl;
import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.util.AppContext;

/**
 * hat die Aufgabe, einen View innerhalb des Ja/Nein-Dialoges zu steuern.
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
			model.setDeleteFlag(true);
			break;
		case 2:
			model.setDeleteFlag(false);
			AppContext.printMessage("Abort");
			break;
		default:
			// VORERST CHOOSERRCOMP ALS ALTERNATIVE FEHLERAUSGABE!!!
			throw new Exception("ChooseErrComp");
		}

	}

	/**
	 * Weißt einer Komponente eine Methode zur Prüfung des Inhaltes zu.
	 */
	public void init(YesNoModel model, YesNoView view) {
		this.model = (YesNoModel) model;
		this.view = (YesNoView) view;

		AbstractUiComponent uic;

		uic = this.view.getcustomerdecisionComponent();
		uic.setControl(new AbstractControl() {
			/**
			 * Prüft den Wert den eine Komponente liefert und schreibt in ins
			 * Model.
			 */
			public void handleInput(Object value) throws Exception {
				checkdecision(value);
				YesNoControl.this.model.setDecision((Integer) value);
			}
		});
	}
}
