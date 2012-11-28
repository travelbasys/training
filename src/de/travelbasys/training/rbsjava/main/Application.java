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

		// Willkommensmessage zeigen.
		AppContext.printMessage("Welcome");

		// Dialogobjekt für das Hauptmenü erzeugen.
		MainMenuDialog menu = new MainMenuDialog();

		// Wiederholt den Benutzer im Hauptmenü wählen lassen.
		// Wenn der Benutzer das Programm beenden will,
		// dann wird im Menu Dialog das Finished Flag gesetzt.
		do {
			menu.run();

			// Welchen Dialog hat der Benutzer gewählt?
			Dialog d = menu.getDialog();

			// Unter bestimmten Umständen bekommen wir null.
			// Dann nächsten Schleifendurchlauf.
			if (d == null)
				continue;

			// Wir führen den gewählten Dialog nun aus.
			// Sollte eine (unvorhergesehen) Exception auftreten,
			// so ist das ein Programmfehler.
			// Aber wir fangen sie hier ab.
			try {
				d.run();
			} catch (Exception e) {
				// Eigentlich sieht nur der Entwickler diesen Stack Trace.
				e.printStackTrace();
				stop();
				terminate();
			}
			// Nachsehen ob Programm beendet werden soll.
		} while (!menu.isFinished());
	}

	protected static void stop() {
		AppContext.println(Datum.getDate());
		AppContext.printMessage("End");
		System.out.close();
	}
}
