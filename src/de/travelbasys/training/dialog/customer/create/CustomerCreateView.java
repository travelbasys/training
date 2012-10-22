package de.travelbasys.training.dialog.customer.create;

import java.util.ArrayList;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.UiComponent;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;

/**
 */
public class CustomerCreateView extends ArrayList<UiComponent> implements View {
	private static final long serialVersionUID = 1L;
	private CustomerCreateModel model;

	private static final String START = "AttentionIntPrompt";
	
	private static final String CUSTOMERLASTNAME = "CustomerLastname";
	private UiComponent customerLastnameComponent;
	
	private static final String CUSTOMERFIRSTNAME = "CustomerFirstname";
	private UiComponent customerFirstnameComponent;
	

	public AbstractUiComponent getCustomerLastnameComponent() {
		return customerLastnameComponent;
	}

	public AbstractUiComponent getCustomerFirstnameComponent() {
		return customerFirstnameComponent;
	}

	public void init(Model model) {
		this.model = (CustomerCreateModel) model;

		customerLastnameComponent = new UiComponent();
		customerLastnameComponent.setName(CUSTOMERLASTNAME);
		customerLastnameComponent.setValue(this.model.getCustomerLastname());
		add(customerLastnameComponent);
		
		customerFirstnameComponent = new UiComponent();
		customerFirstnameComponent.setName(CUSTOMERFIRSTNAME);
		customerFirstnameComponent.setValue(this.model.getCustomerFirstname());
		add(customerFirstnameComponent);
		
		// ...
		
	}

	public void run() {
		// Vorher

		// Standardaktion
		for (UiComponent uiComponent : this) {
			uiComponent.run();
		}

		// Nachher
	}

}