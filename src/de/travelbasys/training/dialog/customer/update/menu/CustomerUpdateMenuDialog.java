package de.travelbasys.training.dialog.customer.update.menu;

import de.travelbasys.training.framework.Dialog;

/**
 * zeigt dem Benutzer ein Menü und lässt ihn darin einen Menüpunkt auswählen.
 */
public class CustomerUpdateMenuDialog implements Dialog {

	private CustomerUpdateMenuModel model;
	private CustomerUpdateMenuView view;
	@SuppressWarnings("unused")
	private CustomerUpdateMenuControl control;

	/**
	 * Erzeugt interne Model, View und Control Instanzen und initialisiert
	 * diese.
	 */
	public CustomerUpdateMenuDialog() {
		model = new CustomerUpdateMenuModel();
		view = new CustomerUpdateMenuView(model);
		control = new CustomerUpdateMenuControl(model, view);
	}

	/**
	 * führt den Dialog aus. Am Ende kann durch die {@link #getSelectedIndex} Methode
	 * festgestellt werden, welchen Menüpunkt der Benutzer ausgewählt hat.
	 */
	@Override
	public void run() {
		view.run();
	}

	/**
	 * Gibt den Index des vom Benutzer gewünschten Menüpunktes zurück. Vorher
	 * muss die {@link #run} Methode ausgeführt werden, damit der Benutzer einen
	 * Menüpunkt auswählen kann.
	 * 
	 * @return der Index.
	 */
	public int getSelectedIndex() {
		return model.getIndex();
	}

}
