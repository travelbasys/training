package de.travelbasys.training.dialog.customer.common.find;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.Dao;
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
	 * Wei�t einer Komponente eine Methode zur Behandlung des Inhaltes zu.
	 */
	public CustomerFindControl(Model model, View view) {
		this.model = (CustomerFindModel) model;
		this.view = (CustomerFindView) view;

		AbstractUiComponent uic;
		uic = this.view.getCustomerIdComponent();

		uic.setControl(new AbstractControl() {
			/**
			 * Ruft eine Methode zur Pr�fung des Wertes einer Komponente.
			 */
			public void handleInput(Object value) throws Exception {
				checkCustomerId(value);
			}
		});

	}

	private void checkCustomerId(Object value) throws Exception {

		int id = (Integer) value;

		// When value is zero, we return without doing anything.
		if (id == 0)
			return;

		// Try to find customer by id.
		Customer customer = Dao.getDAO().findById(id);

		if (customer == null) {
			throw new Exception("IDNotFoundErr");
		}

		// store customer and id in model.
		model.setCustomer(customer);
		model.setCustomerId(id);
	}

}
