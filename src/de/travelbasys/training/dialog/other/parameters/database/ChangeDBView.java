package de.travelbasys.training.dialog.other.parameters.database;

import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.UiComponent;
import de.travelbasys.training.framework.View;

/**
 * Diese Klasse ist verantwortlich f�r den Dialog mit dem Benutzer um die f�r
 * das �ndern der Datenbank erforderlichen abzufragen
 * 
 * @author tba
 * 
 */
public class ChangeDBView implements View {

	private UiComponent changeDBComponent;
	private static final String CHANGEDB = "ChangeDB";

	public AbstractUiComponent getchangeDBComponent() {
		return changeDBComponent;
	}

	public ChangeDBView(ChangeDBModel model) {

		changeDBComponent = new UiComponent();
		changeDBComponent.setName(CHANGEDB);
		changeDBComponent.setValue(model.getDBKey());
	}

	public void run() {
		changeDBComponent.run();
	}
}
