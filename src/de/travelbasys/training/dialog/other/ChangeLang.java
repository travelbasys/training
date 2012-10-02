package de.travelbasys.training.dialog.other;

import java.util.InputMismatchException;
import java.util.Locale;

import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Config;
import de.travelbasys.training.util.Console;

public class ChangeLang {

	public static void run() {
		do {
			AppContext.getString("Choose");
			AppContext.getString("Back");
			AppContext.getString("Lang1");
			AppContext.getString("Lang2");
			try {
				int choice_str = Console.nextInt();
				switch (choice_str) {
				case 0:
					return;
				case 1:
					Config.updateLanguage(new Locale("en"));
					return;
				case 2:
					Config.updateLanguage(new Locale("de"));
					return;
				default:
					AppContext.getErrString("ChooseErr");
					break;
				}
			} catch (NumberFormatException e) {
				AppContext.getErrString("NumberErr");
				continue;
			} catch (InputMismatchException e) {
				AppContext.getErrString("NumberErr");
				continue;
			}
		} while (true);
	}

}
