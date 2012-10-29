package de.travelbasys.training.db;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * ist verantwortlich für das ändern der Datenbank abzufragen um einen Boolean
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
