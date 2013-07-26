package de.travelbasys.training.dialog.customer.update.menu;

import de.travelbasys.training.framework.Dialog;

/**
 * zeigt dem Benutzer ein Men� und l�sst ihn darin einen Men�punkt ausw�hlen.
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
	 * f�hrt den Dialog aus. Am Ende kann durch die {@link #getSelectedIndex} Methode
	 * festgestellt werden, welchen Men�punkt der Benutzer ausgew�hlt hat.
	 */
	@Override
	public void run() {
		view.run();
	}

	/**
	 * Gibt den Index des vom Benutzer gew�nschten Men�punktes zur�ck. Vorher
	 * muss die {@link #run} Methode ausgef�hrt werden, damit der Benutzer einen
	 * Men�punkt ausw�hlen kann.
	 * 
	 * @return der Index.
	 */
	public int getSelectedIndex() {
		return model.getIndex();
	}

}
