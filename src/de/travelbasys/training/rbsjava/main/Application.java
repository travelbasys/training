package de.travelbasys.training.rbsjava.main;

import java.util.Scanner;

import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.dialog.menu.MainMenu;
import de.travelbasys.training.util.CommandLine;
import de.travelbasys.training.util.Config;
import de.travelbasys.training.util.Configuration;
import de.travelbasys.training.util.Console;

/**
 * Diese Klasse repräsentiert die gesamte Anwendung. Sie enthält die main()
 * Methode.
 * 
 * @author tba....
 */
public class Application {

	static Scanner in;

	public static void main(String[] args) {
		init(args);
		start();
		stop();
		terminate();
	}

	private static void terminate() {
		CustomerDAO.terminate();
		System.exit(0);
	}

	private static void init(String[] args) {
		CommandLine.parse(args);
		Configuration.init(CommandLine.getOptions());
		CustomerDAO.init((String) Configuration.get("db"));
	}

	private static void start() {
		Console.println(Config.BUNDLE.getString("Welcome"));
		MainMenu.show();
	}

	private static void stop() {
		Console.println(Config.BUNDLE.getString("End"));
		System.out.close();
	}
}
