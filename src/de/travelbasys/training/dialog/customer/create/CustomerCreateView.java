package de.travelbasys.training.dialog.customer.create;

import java.util.ArrayList;

import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.UiComponent;
import de.travelbasys.training.framework.View;

/**
 * stellt einen View innerhalb des CustomerCreate Dialoges dar.
 * 
 * Die aktuelle Implementierung fragt nach den Werten der verschiedenen
 * Attribute eines Customer Objekts.
 */
public class CustomerCreateView extends ArrayList<UiComponent> implements View {
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

	/**
	 * Initialisiert den aktuellen View.
	 * 
	 * Speichert das gegebene Model Objekt.
	 * 
	 * Erzeugt UiComponents für alle Attribute des Customer Typs: Lastname,
	 * Firstname, Age, usw.
	 */
	public CustomerCreateView(Model model) {
		this.model = (CustomerCreateModel) model;

		customerLastnameComponent = new UiComponent();
		customerLastnameComponent.setName(CUSTOMERLASTNAME);
		customerLastnameComponent.setValue(this.model.getLastname());
		add(customerLastnameComponent);

		customerFirstnameComponent = new UiComponent();
		customerFirstnameComponent.setName(CUSTOMERFIRSTNAME);
		customerFirstnameComponent.setValue(this.model.getFirstname());
		add(customerFirstnameComponent);

		customerAgeComponent = new UiComponent();
		customerAgeComponent.setName(CUSTOMERAGE);
		customerAgeComponent.setValue(this.model.getAge());
		add(customerAgeComponent);

		customerAdressComponent = new UiComponent();
		customerAdressComponent.setName(CUSTOMERADRESS);
		customerAdressComponent.setValue(this.model.getAdress());
		add(customerAdressComponent);

		customerPostalcodeComponent = new UiComponent();
		customerPostalcodeComponent.setName(CUSTOMERPOSTALCODE);
		customerPostalcodeComponent.setValue(this.model.getPostalcode());
		add(customerPostalcodeComponent);

		customerEMailComponent = new UiComponent();
		customerEMailComponent.setName(CUSTOMEREMAIL);
		customerEMailComponent.setValue(this.model.getEMail());
		add(customerEMailComponent);

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