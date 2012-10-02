package de.travelbasys.training.dialog.other;

import java.util.InputMismatchException;
import java.util.Locale;

import de.travelbasys.training.util.Config;
import de.travelbasys.training.util.Console;

public class ChangeLang {

	public static void run() {
			Console.println(Config.BUNDLE.getString("Choose"));
			Console.println("0: " + Config.BUNDLE.getString("Back"));
			Console.println("1: " + Config.BUNDLE.getString("Lang1"));
			Console.println("2: " + Config.BUNDLE.getString("Lang2"));
			int choice_str = Console.nextInt();
			try {
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
						Console.printerr(Config.BUNDLE.getString("ChooseErr"));
						break;
				}
			} catch (NumberFormatException e) {
				Console.printerr(Config.BUNDLE.getString("NumberErr"));
			} catch (InputMismatchException e) {
				Console.printerr(Config.BUNDLE.getString("NumberErr"));
			}
	}

}
