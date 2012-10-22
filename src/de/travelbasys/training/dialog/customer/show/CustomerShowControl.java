package de.travelbasys.training.dialog.customer.show;

import java.util.List;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.framework.AbstractControl;
import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

/**
 */
public class CustomerShowControl extends AbstractControl {

	private CustomerShowModel model;
	private CustomerShowView view;

	public void init(Model model, View view) {
		this.model = (CustomerShowModel) model;
		this.view = (CustomerShowView) view;

		AbstractUiComponent uic;
		uic = this.view.getCustomerIdComponent();

		uic.setControl(new AbstractControl() {
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
		List<Customer> customers = CustomerDAO.findUserByID(id);

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
