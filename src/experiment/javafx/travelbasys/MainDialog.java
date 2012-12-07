package experiment.javafx.travelbasys;

import javafx.stage.Stage;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.util.Configuration;

public class MainDialog implements Dialog {

	private MainModel model;
	private MainView view;
	private MainControl control;

	public MainDialog(Stage stage) {
		model = new MainModel();
		view = new MainView(model, stage);
		control = new MainControl(model);
	}

	public void run() {
		String dbtype = (String) Configuration.get("dbtype");
		String db = (String) Configuration.get("db");
		Dao.setDAO(dbtype);
		Dao.getDAO().init(db);
		view.init();
		view.dbtypeswitch(dbtype);
		control.init(view);
		view.run();
	}
}
