package de.travelbasys.training.dialog.customer.Update;

import java.util.ArrayList;

import de.travelbasys.training.util.AppContext;

/**
 * erzeugt eine Instanz der Klasse CustomerUpdateDialog
 * und verwaltet Strings für Ausgaben
 */

public class CustomerUpdateModel extends ArrayList<String> {

	public CustomerUpdateModel() {
		super();
		add(AppContext.getMessage("IDPrompt"));
		add(AppContext.getMessage("UserFound"));
		add(AppContext.getMessage("Choose"));
		add(AppContext.getMessage("Cancel"));
		add(AppContext.getMessage("Update1"));
		add(AppContext.getMessage("Update2"));
		add(AppContext.getMessage("Update3"));
		add(AppContext.getMessage("Update4"));
		add(AppContext.getMessage("Update5"));
		add(AppContext.getMessage("Update6"));
		add(AppContext.getMessage("FirstNamePrompt"));
		add(AppContext.getMessage("LastNamePrompt"));
		add(AppContext.getMessage("AgePrompt"));
		add(AppContext.getMessage("AdressPrompt"));
		add(AppContext.getMessage("PostalPrompt"));
		add(AppContext.getMessage("eMailPrompt"));

	}

}