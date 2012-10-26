package de.travelbasys.training.dialog.customer.common.show1;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;

/**
 * zeigt den im Model gespeichertes Customer an.
 */
public class CustomerShow1View implements View {
	private CustomerShow1Model model;

	/**
	 * Speichert das gegebene Model Objekt.
	 */
	public CustomerShow1View(Model model) {
		this.model = (CustomerShow1Model) model;
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