package de.travelbasys.training.dialog.customer.showandchange;

import java.util.ArrayList;

import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.UiComponent;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;

/**
 * Fragt den Anwender nach dem gewünschten Attribut.
 */
@SuppressWarnings("serial")
public class ShowAndChangeView extends ArrayList<UiComponent> implements View {

	private ShowAndChangeModel model;
	private ShowAndChangeControl control;
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
	 * Speichert das gegebene Model Objekt. Speichert das gegebene Controller
	 * Objekt. Erzeugt einen Wert für die UiComponents Eigenschaft mit
	 * bestimmten Typen die es vom Model erhält.
	 */
	public void init(Model model) {
		this.model = (ShowAndChangeModel) model;
		this.control = (ShowAndChangeControl) control;
		
		customerFirstnameComponent = new UiComponent();
		customerFirstnameComponent.setName(CUSTOMERFIRSTNAME);
		customerFirstnameComponent.setValue(this.model.getFirstName());
		add(customerFirstnameComponent);

		customerLastnameComponent = new UiComponent();
		customerLastnameComponent.setName(CUSTOMERLASTNAME);
		customerLastnameComponent.setValue(this.model.getLastName());
		add(customerLastnameComponent);

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
		customerPostalcodeComponent
				.setValue(this.model.getPostalcode());
		add(customerPostalcodeComponent);

		customerEMailComponent = new UiComponent();
		customerEMailComponent.setName(CUSTOMEREMAIL);
		customerEMailComponent.setValue(this.model.getEMail());
		add(customerEMailComponent);

	}

	public ShowAndChangeView(ShowAndChangeModel model,
			ShowAndChangeControl control) {
		super();
		this.model = model;
		this.control = control;
	}

	/**
	 * Diese Methode stellt einen View innerhalb des ShowAndChange Dialogs dar.
	 * Sie übergibt einer internen Komponente die Aufgabe den Benutzer nach dem
	 * zu ändernden Wert z.B. Vorname abzufragen.
	 * */
	public void run() {

		try {
			// Control.fix() führt für den Index eine Subtraktion von 1 durch.
			// Die Subtraktion ist notwendig, da die ArrayList der UIComponents
			// von 0-5 (Zulässiger Eingabebereich 1-6) reicht.
			// Wurde eine gültige Eingabe getätigt wird der Wert um 1 verringert
			// um keine IndexOutOfBoundsException zu werfen.
			control.fix();
			UiComponent uic = get(model.getIndex());
			uic.run();
		} catch (IndexOutOfBoundsException e) {
			AppContext.printErrString("ChooseErr");
			return;
		}
	}

}
