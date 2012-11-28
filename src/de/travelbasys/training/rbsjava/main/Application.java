package de.travelbasys.training.rbsjava.main;

import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.dialog.menu.MainMenuDialog;
import de.travelbasys.training.dialog.menu.dbtype.ChooseDatabaseTypeDialog;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.CommandLine;
import de.travelbasys.training.util.Configuration;
import de.travelbasys.training.util.Datum;

/**
 * Diese Klasse repräsentiert die gesamte Anwendung. Sie enthält die main()
 * Methode.
 * 
 * @author tba....
 */
public class Application {

	public static void main(String[] args) {
		initApplication(args);
		initDatabase();
		start();
		stop();
		terminate();
	}

	protected static void terminate() {
		Dao.getDAO().terminate();
		System.exit(0);
	}

	private static void initApplication(String[] args) {
		CommandLine.parse(args);
		Configuration.init(CommandLine.getOptions());
	}

	private static void initDatabase() {
		ChooseDatabaseTypeDialog menu = new ChooseDatabaseTypeDialog();
		menu.run();
		Dao.setDAO(menu.getDAO());
		if (Dao.getDAO() == null) {
			System.exit(0);
		}
		Dao.getDAO().init((String) Configuration.get("db"));
	}

	private static void start() {

		AppContext.printMessage("Welcome");
		MainMenuDialog menu = new MainMenuDialog();
		do {
			menu.run();
			Dialog d = menu.getDialog();
			if (d != null){
			try {
				d.run();
			} catch (Exception e) {
				e.printStackTrace();
				stop();
				terminate();
			}}
		} while (!menu.isCancelled());
	}

	protected static void stop() {
		AppContext.println(Datum.getDate());
		AppContext.printMessage("End");
		System.out.close();
	}
}
