package de.travelbasys.training.dialog.customer.find;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.Dialog;

/**
 */
public class CustomerFindDialog implements Dialog {
	private CustomerFindModel model;
	private CustomerFindView view;
	private CustomerFindControl control;

	public void init() {
		model = new CustomerFindModel();
		control = new CustomerFindControl();
		view = new CustomerFindView();

		view.init(model);
		control.init(model, view);
	}

	@Override
	public void run() {
		view.run();
	}

	public Customer getCustomer() {
		return model.getCustomer();
	}

	public int getCustomerID(){
		return model.getCustomerId();
	}
}
