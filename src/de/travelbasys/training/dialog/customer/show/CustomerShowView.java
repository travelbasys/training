package de.travelbasys.training.dialog.customer.show;

import java.util.ArrayList;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.UiComponent;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;

/**
 */
public class CustomerShowView extends ArrayList<UiComponent> implements View {
	private static final long serialVersionUID = 1L;
	private static final String CUSTOMERID = "CustomerId";
	private static final String START = "AttentionIntPrompt";
	private UiComponent customerIdComponent;
	private CustomerShowModel model;

	public AbstractUiComponent getCustomerIdComponent() {
		return customerIdComponent;
	}

	public void init(Model model) {
		this.model = (CustomerShowModel) model;

		customerIdComponent = new UiComponent();
		customerIdComponent.setName(CUSTOMERID);
		customerIdComponent.setValue(this.model.getCustomerId());
		add(customerIdComponent);
	}

	public void run() {
		// Vorher
		AppContext.printMessage(START);

		// Standardaktion
		for (UiComponent uiComponent : this) {
			uiComponent.run();
		}

		// Nachher
		Customer customer = model.getCustomer();
		if (null != customer)
			AppContext.println(customer);
		
		AppContext.println("");
	}

}