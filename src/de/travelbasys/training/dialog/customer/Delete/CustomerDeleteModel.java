package de.travelbasys.training.dialog.customer.Delete;

import java.util.ArrayList;

import de.travelbasys.training.util.AppContext;

/**
 * erzeugt eine Instanz der Klasse CustomerDeleteDialog und verwaltet Strings
 * für Ausgaben
 */
@SuppressWarnings("serial")
public class CustomerDeleteModel extends ArrayList<String> {

	public CustomerDeleteModel() {
		super();
		add(AppContext.getMessage("AttentionIntPrompt"));
		add(AppContext.getMessage("DelOK"));
		add(AppContext.getMessage("IDPrompt"));
		add(AppContext.getMessage("UserFound"));
		add(AppContext.getMessage("DelUserQ"));
		add(AppContext.getMessage("Yes"));
		add(AppContext.getMessage("No"));
		add(AppContext.getMessage("ChooseErr"));
		add(AppContext.getMessage("IDNotFoundErr"));
		add(AppContext.getMessage("DelUserAbort"));
		add(AppContext.getMessage("NumberErr"));
	}

}