package de.travelbasys.training.dialog.customer.create;

import java.util.HashMap;

import de.travelbasys.training.dialog.Model;
import de.travelbasys.training.util.AppContext;
/**
 * erzeugt eine Instanz der Klasse CustomerCreateDialog
 * und verwaltet Strings für Ausgaben
 */
@SuppressWarnings("serial")
public class CustomerCreateModel extends HashMap<String, String> implements Model {
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

	@Override
	public String getPrompt(String fieldName) {
		return get("prompt" + fieldName);
	}

	int getAge(){
		return Integer.parseInt(get("Age"));
	}

}
