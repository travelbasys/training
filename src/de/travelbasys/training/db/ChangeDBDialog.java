package de.travelbasys.training.db;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * ist verantwortlich für den Dialog mit dem Benutzer, um alle Daten für ein
 * Customer Objekt abzufragen und das Objekt dann zu erzeugen.
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
