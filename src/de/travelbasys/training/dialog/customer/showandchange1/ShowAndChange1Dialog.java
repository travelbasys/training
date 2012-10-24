package de.travelbasys.training.dialog.customer.showandchange1;

import de.travelbasys.training.framework.Dialog;

/**
 * f�hrt einen Dialog mit dem Benutzer der nach der gew�nschten Funktion gefragt wird.
 */
public class ShowAndChange1Dialog implements Dialog {

	private ShowAndChange1Model model;
	private ShowAndChange1View view;
	private ShowAndChange1Control control;
	
	/**
	 * f�hrt den Dialog aus.
	 */
	@Override
	public void run() {
		view.run();
	}
	/**
	 * @return Die ausgew�hlte Funktion des Benutzers
	 */
	public int getIndex() {
		return model.getIndex();
	}
	/**
	 * Initialisiert die ben�tigten Componenten f�r den Dialog.
	 */
	public void init() {
		model = new ShowAndChange1Model();
		control = new ShowAndChange1Control();
		view = new ShowAndChange1View();

		view.init(model);
		control.init(model, view);
	}

}
