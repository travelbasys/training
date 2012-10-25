package de.travelbasys.training.dialog.customer.update.attributes;

import java.util.ArrayList;

import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.UiComponent;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;

/**
 * Fragt den Anwender nach dem gewünschten Attribut.
 */
@SuppressWarnings("serial")
public class CustomerAttributesUpdateView extends ArrayList<UiComponent>
		implements View {
	
	private CustomerAttributesUpdateModel model;

	private static final String LASTNAME = "LastName";
	private UiComponent lastnameComponent;

	private static final String FIRSTNAME = "FirstName";
	private UiComponent firstnameComponent;

	private static final String AGE = "Age";
	private UiComponent ageComponent;

	private static final String ADRESS = "Adress";
	private UiComponent adressComponent;

	private static final String POSTALCODE = "Postal";
	private UiComponent postalcodeComponent;

	private static final String EMAIL = "EMail";
	private UiComponent eMailComponent;


	public UiComponent getLastnameComponent() {
		return lastnameComponent;
	}

	public UiComponent getFirstnameComponent() {
		return firstnameComponent;
	}

	public UiComponent getAgeComponent() {
		return ageComponent;
	}

	public UiComponent getAdressComponent() {
		return adressComponent;
	}

	public UiComponent getPostalcodeComponent() {
		return postalcodeComponent;
	}

	public UiComponent getEMailComponent() {
		return eMailComponent;
	}

	/**
	 * Speichert das gegebene Model Objekt. Speichert das gegebene Controller
	 * Objekt. Erzeugt einen Wert für die UiComponents Eigenschaft mit
	 * bestimmten Typen die es vom Model erhält.
	 */
	public void init(Model model1) {
		model = (CustomerAttributesUpdateModel) model1;
		
		firstnameComponent = new UiComponent();
		firstnameComponent.setName(FIRSTNAME);
		firstnameComponent.setValue(model.getFirstName());
		add(firstnameComponent);

		lastnameComponent = new UiComponent();
		lastnameComponent.setName(LASTNAME);
		lastnameComponent.setValue(model.getLastName());
		add(lastnameComponent);

		ageComponent = new UiComponent();
		ageComponent.setName(AGE);
		ageComponent.setValue(model.getAge());
		add(ageComponent);

		adressComponent = new UiComponent();
		adressComponent.setName(ADRESS);
		adressComponent.setValue(model.getAdress());
		add(adressComponent);

		postalcodeComponent = new UiComponent();
		postalcodeComponent.setName(POSTALCODE);
		postalcodeComponent.setValue(model.getPostalcode());
		add(postalcodeComponent);

		eMailComponent = new UiComponent();
		eMailComponent.setName(EMAIL);
		eMailComponent.setValue(model.getEMail());
		add(eMailComponent);

	}

	/**
	 * Diese Methode stellt einen View innerhalb des ShowAndChange Dialogs dar.
	 * Sie übergibt einer internen Komponente die Aufgabe den Benutzer nach dem
	 * zu ändernden Wert z.B. Vorname abzufragen.
	 * */
	public void run() {

		try {
			UiComponent uic = get(model.getComponentIndex());
			uic.run();
		} catch (IndexOutOfBoundsException e) {
			AppContext.printErrString("ChooseErr");
			return;
		}
	}

}
