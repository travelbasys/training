package de.travelbasys.training.dialog.customer.find;

import java.util.List;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.framework.AbstractControl;
import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

/**
 * hat die Aufgabe, einen View innerhalb des Find-Dialoges zu steuern.
 */
public class CustomerFindControl extends AbstractControl {

	private CustomerFindModel model;
	private CustomerFindView view;
	/**
	 * Initialisiert den Controller mit Model und View des Packages.
	 * 
	 * Weißt einer Komponente eine Methode zur Behandlung des Inhaltes zu.
	 */
	public CustomerFindControl(Model model, View view) {
		this.model = (CustomerFindModel) model;
		this.view = (CustomerFindView) view;

		AbstractUiComponent uic;
		uic = this.view.getCustomerIdComponent();

		uic.setControl(new AbstractControl() {
			/**
			 * Ruft eine Methode zur Prüfung des Wertes einer Komponente.
			 */
			public void handleInput(Object value) throws Exception {
				checkCustomerId(value);
			}
		});

	}

	private void checkCustomerId(Object value) throws Exception {

		int id = (Integer) value;

		// When value is zero, we return without doing anything.
		if (0 == id)
			return;

		// Try to find customer by id.
		List<Customer> customers = CustomerDAO.findCustomerById(id);

		// When found...
		if (!customers.isEmpty()) {
			// store customer and id in model.
			model.setCustomer(customers.get(0));
			model.setCustomerId(id);
		} else {
			// or else indicate failure.
			throw new Exception("IDNotFoundErr");
		}

	}

}
