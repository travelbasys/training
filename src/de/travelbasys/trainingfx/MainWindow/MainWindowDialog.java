package de.travelbasys.trainingfx.MainWindow;

import javafx.stage.Stage;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.util.Configuration;

public class MainWindowDialog implements Dialog {

	private MainWindowModel model;
	private MainWindowView view;
	private MainWindowControl control;

	public MainWindowDialog(Stage stage) {
		model = new MainWindowModel();
		view = new MainWindowView(model, stage);
		control = new MainWindowControl(model);
	}

	public void run() {
		int dbtype;
		try {
			dbtype = Integer.parseInt((String) Configuration.get("dbtype"));
		} catch (NumberFormatException e) {
			dbtype = 0;
		}
		String db = (String) Configuration.get("db");
		Dao.setDAO(dbtype);
		Dao.getDAO().init(db);
		view.init();
		control.init(view);
		view.run();
	}
}