package de.travelbasys.training.dialog.customer.common.print;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;

/**
 * zeigt den im Model gespeichertes Customer an.
 */
public class CustomerPrintView implements View {
	private CustomerPrintModel model;

	/**
	 * Speichert das gegebene Model Objekt.
	 */
	public CustomerPrintView(Model model) {
		this.model = (CustomerPrintModel) model;
	}

	/**
	 * Schreibt aus dem Model das Customer Objekt und zusätlich eine Leerzeile
	 * aus (,auf den Bildschirm).
	 */
	public void run() {
		Customer customer = model.getCustomer();
		if (null != customer)
			AppContext.println(customer);

		AppContext.println("");
	}

}