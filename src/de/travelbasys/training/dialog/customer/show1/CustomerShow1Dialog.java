package de.travelbasys.training.dialog.customer.show1;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.Dialog;

/**
 */
public class CustomerShow1Dialog implements Dialog {
	private CustomerShow1Model model;
	private CustomerShow1View view;
	private Customer customer;
	@SuppressWarnings("unused")
	private CustomerShow1Control control;

	@Override
	public void run() {
		view.run();
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void init() {
		model = new CustomerShow1Model();
		control = new CustomerShow1Control();
		view = new CustomerShow1View();

		view.init(model);
		model.setCustomer(customer);
	}

}
