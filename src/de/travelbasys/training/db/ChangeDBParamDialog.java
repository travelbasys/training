package de.travelbasys.training.db;

import java.io.File;

import de.travelbasys.training.dialog.Dialog;
import de.travelbasys.training.util.Config;
/**
 * Diese Klasse ist verantwortlich f�r das �ndern der aktuell verwendeten Datenbank.
 * 
 * @author tba
 *
 */
public class ChangeDBParamDialog implements Dialog {

	static final String DATABASE_KEY = "database";
	static File ini = new File(Config.CONFIG_FILENAME);

	ChangeDBModel model;
	ChangeDBView view;
	ChangeDBControl control;

	public ChangeDBParamDialog() {
		super();
	}

	public void run() {
		model = new ChangeDBModel();
		control = new ChangeDBControl();
		view = new ChangeDBView(model, control);

		// Here plays the music!
		view.run();

		String db = model.get("ChangeDB");
		CustomerDAO.terminate();
		CustomerDAO.init(db);

	}

}