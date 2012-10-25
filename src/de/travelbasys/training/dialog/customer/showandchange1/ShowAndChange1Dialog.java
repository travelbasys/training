package de.travelbasys.training.dialog.customer.showandchange1;

import de.travelbasys.training.framework.Dialog;

/**
 * zeigt dem Benutzer ein Menü und lässt ihn darin einen Menüpunkt auswählen.
 */
public class ShowAndChange1Dialog implements Dialog {

	private ShowAndChange1Model model;
	private ShowAndChange1View view;
	private ShowAndChange1Control control;

	/**
	 * führt den Dialog aus. Am Ende kann durch die {@see #getIndex} Methode
	 * festgestellt werden, welchen Menüpunkt der Benutzer ausgewählt hat.
	 */
	@Override
	public void run() {
		view.run();
	}

	/**
	 * Gibt den Index des vom Benutzer gewünschten Menüpunktes zurück.
	 * Vorher muss die {@link run} Methode ausgeführt werden, damit der
	 * Benutzer einen Menüpunkt auswählen kann.
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
