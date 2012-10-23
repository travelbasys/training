package de.travelbasys.training.db;

import java.io.File;

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
	}
}