package de.travelbasys.training.dialog.other.parameters.database;

import java.io.File;

import de.travelbasys.training.db.CustomerDAO;
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

	protected static final String DATABASE_KEY = "database";
	protected static File ini = new File(Config.CONFIG_FILENAME);

	private ChangeDBModel model;
	private ChangeDBView view;
	@SuppressWarnings("unused")
	private ChangeDBControl control;

	@Override
	public void run() {
		model = new ChangeDBModel();
		view = new ChangeDBView(model);
		control = new ChangeDBControl(model, view);
		view.run();

		String db = model.getDBKey();
		CustomerDAO.terminate();
		CustomerDAO.init(db);
	}
	public String getDBKey(){
		return model.getDBKey();
	}
}