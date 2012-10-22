package de.travelbasys.training.dialog.customer.show1;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;


/**
 */
public class CustomerShow1View implements View {
	private CustomerShow1Model model;

	public void init(Model model) {
		this.model = (CustomerShow1Model) model;
	}

	public void run() {
		Customer customer = model.getCustomer();
		if (null != customer)
			AppContext.println(customer);
		
		AppContext.println("");
	}

}