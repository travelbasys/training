package de.travelbasys.training.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import de.travelbasys.training.dialog.menu.MainMenuDialog;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.util.Config;

/**
 * Diese Klasse ist verantwortlich für das ändern der aktuell verwendeten
 * Datenbank.
 * 
 * @author tba
 * 
 */
public class ChangeDBDialog implements Dialog {

	static final String DATABASE_KEY = "database";
	static File ini = new File(Config.CONFIG_FILENAME);

	ChangeDBModel model;
	ChangeDBView view;
	ChangeDBControl control;

	public ChangeDBDialog(ChangeDBModel model) {
		this.model = model;
	}

	public ChangeDBDialog() {
		model = new ChangeDBModel();
	}

	@Override
	public void run() {
		control = new ChangeDBControl(model);
		view = new ChangeDBView(model, control);
		view.init(model);
		control.init(model, view);
		view.run();

		String db = model.getDBkey();
		CustomerDAO.terminate();
		CustomerDAO.init(db);
		if (model.isSave() == true) {
			try {
				Properties config = new Properties();
				config.load(new FileInputStream(ini));
				config.setProperty(DATABASE_KEY, db);
				config.store(new FileOutputStream(ini),
						"Travelbasys User Manager - Properties");
			} catch (Exception e) {
			}
		}
		MainMenuDialog menu = new MainMenuDialog();
		menu.run();
	}
}