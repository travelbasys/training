package de.travelbasys.training.dialog.other;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import de.travelbasys.training.util.Config;

/**
 * ist verantwortlich für das ändern der Datenbank abzufragen um einen Boolean
 * zu setzen der dann in der ChangeLangParamDialog sagt, dass die Konfiguration
 * zu speichern ist.
 * 
 * @author tba
 */

public class ChangeLangSaveDialog extends ChangeLangDialog {

	static final String LANGUAGE_KEY = "lang";
	static File ini = new File(Config.CONFIG_FILENAME);

	public void run() {
		super.run();
		try {
			Properties config = new Properties();
			config.load(new FileInputStream(ini));
			config.setProperty(LANGUAGE_KEY, getLangKey());
			config.store(new FileOutputStream(ini),
					"Travelbasys User Manager - Properties");
		} catch (Exception e) {
		}
	}
}
