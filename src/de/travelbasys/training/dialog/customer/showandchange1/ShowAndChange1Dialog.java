package de.travelbasys.training.dialog.customer.showandchange1;

import de.travelbasys.training.framework.Dialog;

/**
 * führt einen Dialog mit dem Benutzer der nach der gewünschten Funktion gefragt wird.
 */
public class ShowAndChange1Dialog implements Dialog {

	private ShowAndChange1Model model;
	private ShowAndChange1View view;
	private ShowAndChange1Control control;
	
	/**
	 * führt den Dialog aus.
	 */
	@Override
	public void run() {
		view.run();
	}
	/**
	 * @return Die ausgewählte Funktion des Benutzers
	 */
	public int getIndex() {
		return model.getIndex();
	}
	/**
	 * Initialisiert die benötigten Componenten für den Dialog.
	 */
	public void init() {
		model = new ShowAndChange1Model();
		control = new ShowAndChange1Control();
		view = new ShowAndChange1View();

		view.init(model);
		control.init(model, view);
	}

}
