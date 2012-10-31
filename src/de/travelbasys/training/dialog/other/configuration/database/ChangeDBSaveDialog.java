package de.travelbasys.training.dialog.other.configuration.database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import de.travelbasys.training.dialog.other.parameters.database.ChangeDBDialog;

/**
 * ist verantwortlich f�r das �ndern der Datenbank abzufragen um einen Boolean
 * zu setzen der dann in der ChangeDBParamDialog sagt, dass die Konfiguration zu
 * speichern ist.
 * 
 * @author tba
 */

public class ChangeDBSaveDialog extends ChangeDBDialog {

	public void run() {
		super.run();
		try {
			Properties config = new Properties();
			config.load(new FileInputStream(ini));
			config.setProperty(DATABASE_KEY, getDBKey());
			config.store(new FileOutputStream(ini),
					"Travelbasys User Manager - Properties");
		} catch (Exception e) {
		}
	}
}