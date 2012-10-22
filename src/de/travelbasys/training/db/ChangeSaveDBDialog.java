package de.travelbasys.training.db;

/**
 * ist verantwortlich für das ändern der Datenbank abzufragen um einen Boolean zu setzen der dann in
 * der ChangeDBParamDialog sagt, dass die Konfiguration zu speichern ist.
 * 
 * @author tba
 */

public class ChangeSaveDBDialog extends ChangeDBDialog {

	public void run() {
		model = new ChangeDBModel();
		model.setSave(true);
		super.run();
	}
}
