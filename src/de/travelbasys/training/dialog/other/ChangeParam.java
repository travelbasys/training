package de.travelbasys.training.dialog.other;

import java.util.InputMismatchException;

import de.travelbasys.training.db.ChangeDB;
import de.travelbasys.training.util.Config;
import de.travelbasys.training.util.Console;

public class ChangeParam {

	public static void run() {
		do {
			Console.println(Config.BUNDLE.getString("Choose"));
			Console.println("0: " + Config.BUNDLE.getString("Back"));
			Console.println("1: " + Config.BUNDLE.getString("Param1"));
			Console.println("2: " + Config.BUNDLE.getString("Param2"));
			int choice_str = Console.nextInt();
			try {
				switch (choice_str) {
				case 0:
					return;
				case 1:
					ChangeLang.run();
					break;
				case 2:
					ChangeDB.run2();
					break;
				default:
					Console.printerr(Config.BUNDLE.getString("ChooseErr"));
					break;
				}
			} catch (NumberFormatException e) {
				Console.printerr(Config.BUNDLE.getString("NumberErr"));
			} catch (InputMismatchException e) {
				Console.printerr(Config.BUNDLE.getString("NumberErr"));
			}

		} while (true);
	}

}
