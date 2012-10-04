package de.travelbasys.training.dialog.customer;

import java.util.HashMap;

import de.travelbasys.training.util.AppContext;

public class CustomerCreateModel extends HashMap<String, String> {

	/**
	 * Erzeugt eine Instanz der Klasse...
	 */
	public CustomerCreateModel() {
		super();

		put("promptLastName", AppContext.getMessage("LastNamePrompt"));
		put("promptFirstName", AppContext.getMessage("FirstNamePrompt"));
		put("promptAge", AppContext.getMessage("AgePrompt"));
		put("promptAdress", AppContext.getMessage("AdressPrompt"));
		put("promptPostalCode", AppContext.getMessage("PostalPrompt"));
		put("promptEMail", AppContext.getMessage("eMailPrompt"));
	}

	public String getPrompt(String fieldName) {
		return get("prompt" + fieldName);
	}

	public int getAge(){
		return Integer.parseInt(get("Age"));
	}

}
