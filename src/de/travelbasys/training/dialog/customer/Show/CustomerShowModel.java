package de.travelbasys.training.dialog.customer.Show;

import java.util.ArrayList;

import de.travelbasys.training.util.AppContext;


public class CustomerShowModel extends ArrayList<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Erzeugt eine Instanz der Klasse...
	 */
	public CustomerShowModel() {
		super();
		add(AppContext.getMessage("Choose"));
		add(AppContext.getMessage("ExitApp"));
		add(AppContext.getMessage("Show1"));
		add(AppContext.getMessage("Show2"));
	}

}

/*@SuppressWarnings("serial")
public class CustomerShowModel extends HashMap<String, String> implements Model {
	
	public CustomerShowModel() {
		super();

		put("promptLastName", AppContext.getMessage("LastNamePrompt"));
		put("promptCustomerID", AppContext.getMessage("IDPrompt"));
	}

	@Override
	public String getPrompt(String fieldName) {
		return get("prompt" + fieldName);
	}

}*/