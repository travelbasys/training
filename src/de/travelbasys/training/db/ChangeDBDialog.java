package de.travelbasys.training.db;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * ist verantwortlich für das ändern der Datenbank abzufragen um diese dann
 * in der Konfiguration zu speichern.
 * 
 * @author tba
 */

public class ChangeDBDialog extends ChangeDBParamDialog {

	@Override
	public void run() {

		super.run();

		Properties config = new Properties();
		String db = model.get("ChangeDB");

		try {
			config.load(new FileInputStream(ini));
			config.setProperty(DATABASE_KEY, db);
			config.store(new FileOutputStream(ini),
					"Travelbasys User Manager - Properties");
		} catch (Exception e) {
		}
	}
}
