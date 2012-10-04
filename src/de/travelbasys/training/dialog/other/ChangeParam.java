package de.travelbasys.training.dialog.other;

import java.util.InputMismatchException;

import de.travelbasys.training.db.ChangeDB;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Console;

public class ChangeParam {

	public static void run() {
		do {
			AppContext.println("Choose");
			AppContext.println("Back");
			AppContext.println("Param1");
			AppContext.println("Param2");
			try {
				int choice_str = Console.nextInt();
				switch (choice_str) {
				case 0:
					return;
				case 1:
					ChangeLang.run();
					return;
				case 2:
					ChangeDB.run2();
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
