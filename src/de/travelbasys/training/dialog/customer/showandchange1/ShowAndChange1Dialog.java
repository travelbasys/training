package de.travelbasys.training.dialog.customer.showandchange1;

import de.travelbasys.training.framework.Dialog;

/**
 * zeigt dem Benutzer ein Men� und l�sst ihn darin einen Men�punkt ausw�hlen.
 */
public class ShowAndChange1Dialog implements Dialog {

	private ShowAndChange1Model model;
	private ShowAndChange1View view;
	private ShowAndChange1Control control;

	/**
	 * f�hrt den Dialog aus. Am Ende kann durch die {@see #getIndex} Methode
	 * festgestellt werden, welchen Men�punkt der Benutzer ausgew�hlt hat.
	 */
	@Override
	public void run() {
		view.run();
	}

	/**
	 * Gibt den Index des vom Benutzer gew�nschten Men�punktes zur�ck.
	 * Vorher muss die {@link run} Methode ausgef�hrt werden, damit der
	 * Benutzer einen Men�punkt ausw�hlen kann.
	 * 
	 * @return der Index.
	 */
	public int getIndex() {
		return model.getIndex();
	}

	/**
	 * Erzeugt interne Model, View und Control Instanzen und initialisiert diese.
	 */
	public void init() {
		model = new ShowAndChange1Model();
		control = new ShowAndChange1Control();
		view = new ShowAndChange1View();

		view.init(model);
		control.init(model, view);
	}

}
