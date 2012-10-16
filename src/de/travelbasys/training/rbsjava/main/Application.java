package de.travelbasys.training.rbsjava.main;

import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.dialog.menu.MainMenuDialog;
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
		init(args);
		start();
		stop();
		terminate();
	}

	protected static void terminate() {
		CustomerDAO.terminate();
		System.exit(0);
	}

	private static void init(String[] args) {
		CommandLine.parse(args);
		Configuration.init(CommandLine.getOptions());
		CustomerDAO.init((String) Configuration.get("db"));
	}

	private static void start() {

		// ApplicationContext context = getContext();
		// context.println( context.getString("Welcome"));

		AppContext.printMessage("Welcome");
		MainMenuDialog menu = new MainMenuDialog();
		menu.run();
	}

	protected static void stop() {
		AppContext.println(Datum.getDate());
		AppContext.printMessage("End");
		System.out.close();
	}
}
