package de.travelbasys.training.db;

import de.travelbasys.training.dialog.customer.show.CustomerShowModel;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.UiComponent;

/**
 * Diese Klasse ist verantwortlich f�r den Dialog mit dem Benutzer um die f�r
 * das �ndern der Datenbank erforderlichen abzufragen
 * 
 * @author tba
 * 
 */
public class ChangeDBView {

	private ChangeDBModel model;
	private static final String CHANGEDB = "ChangeDB";

	
	public void init(Model model) {
		this.model = (ChangeDBModel) model;
/*
		changedbComponent = new UiComponent();
		changedbComponent.setName(CHANGEDB);
		changedbComponent.setValue(this.model.getDB());
		add(changedbComponent);
		*/
	}
	
	public ChangeDBView() {
		super();

	}

	public void run() {
	}

}
