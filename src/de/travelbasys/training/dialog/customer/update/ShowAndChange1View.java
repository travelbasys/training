package de.travelbasys.training.dialog.customer.update;

import java.util.ArrayList;

import de.travelbasys.training.dialog.customer.create.CustomerCreateModel;
import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.UiComponent;
import de.travelbasys.training.framework.View;

/**
 */
public class ShowAndChange1View extends ArrayList<UiComponent> implements View {
	private static final long serialVersionUID = 1L;
	private CustomerCreateModel model;

	private static final String CUSTOMERLASTNAME = "LastName";
	private UiComponent customerLastnameComponent;

	private static final String CUSTOMERFIRSTNAME = "FirstName";
	private UiComponent customerFirstnameComponent;

	private static final String CUSTOMERAGE = "Age";
	private UiComponent customerAgeComponent;

	private static final String CUSTOMERADRESS = "Adress";
	private UiComponent customerAdressComponent;

	private static final String CUSTOMERPOSTALCODE = "Postal";
	private UiComponent customerPostalcodeComponent;

	private static final String CUSTOMEREMAIL = "EMail";
	private UiComponent customerEMailComponent;

	public AbstractUiComponent getCustomerLastnameComponent() {
		return customerLastnameComponent;
	}

	public AbstractUiComponent getCustomerFirstnameComponent() {
		return customerFirstnameComponent;
	}

	public AbstractUiComponent getCustomerAgeComponent() {
		return customerAgeComponent;
	}

	public AbstractUiComponent getCustomerAdressComponent() {
		return customerAdressComponent;
	}

	public AbstractUiComponent getCustomerPostalcodeComponent() {
		return customerPostalcodeComponent;
	}

	public AbstractUiComponent getCustomerEMailComponent() {
		return customerEMailComponent;
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

		customerAgeComponent = new UiComponent();
		customerAgeComponent.setName(CUSTOMERAGE);
		customerAgeComponent.setValue(this.model.getCustomerAge());
		add(customerAgeComponent);

		customerAdressComponent = new UiComponent();
		customerAdressComponent.setName(CUSTOMERADRESS);
		customerAdressComponent.setValue(this.model.getCustomerAdress());
		add(customerAdressComponent);

		customerPostalcodeComponent = new UiComponent();
		customerPostalcodeComponent.setName(CUSTOMERPOSTALCODE);
		customerPostalcodeComponent
				.setValue(this.model.getCustomerPostalcode());
		add(customerPostalcodeComponent);

		customerEMailComponent = new UiComponent();
		customerEMailComponent.setName(CUSTOMEREMAIL);
		customerEMailComponent.setValue(this.model.getCustomerEMail());
		add(customerEMailComponent);

	}

	public void run(int index) {
		UiComponent uic = this.get(index);
		uic.run();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}