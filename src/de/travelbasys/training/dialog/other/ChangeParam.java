package de.travelbasys.training.dialog.other;

import java.util.InputMismatchException;

import de.travelbasys.training.db.ChangeDBParamDialog;
import de.travelbasys.training.dialog.Dialog;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Console;

public class ChangeParam {

	public static void run() {
		Dialog d;
		do {
			AppContext.printMessage("Choose");
			AppContext.printMessage("Back");
			AppContext.printMessage("Param1");
			AppContext.printMessage("Param2");
			try {
				int choice_str = Console.nextInt();
				switch (choice_str) {
				case 0:
					return;
				case 1:
					ChangeLang.run();
					return;
				case 2:
					d = new ChangeDBParamDialog();
					d.run();
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
