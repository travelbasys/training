package de.travelbasys.training.dialog.other.configuration.database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import de.travelbasys.training.dialog.other.parameters.database.ChangeDBDialog;

/**
 * ist verantwortlich für das ändern der Datenbank. Führt ihre Superklasse aus &
 * erweitert diese um eine Speichern-Funktion.
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
