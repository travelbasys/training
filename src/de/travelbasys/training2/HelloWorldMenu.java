package de.travelbasys.training2;

import java.io.PrintStream;
import java.util.ResourceBundle;
import java.util.Scanner;

public class HelloWorldMenu {

	private static String baseName = "resources.HelloWorld";
	static ResourceBundle bundle = ResourceBundle.getBundle(baseName);
	private static Scanner in;

	static void show(String[] args, HelloWorldUI UserCreate, UserList ul) {
		PrintStream out = System.out;
		PrintStream err = System.err;
		do {
			out.println(bundle.getString("Choose"));
			out.println("0: " + bundle.getString("ExitApp"));
			out.println("1: " + bundle.getString("App1"));
			out.println("2: " + bundle.getString("App2"));
			out.println("3: " + bundle.getString("App3"));
			out.println("4: " + bundle.getString("App4"));
			out.println("5: " + bundle.getString("App5"));

			in = new Scanner(System.in);
			int choice_str = in.nextInt();

			try {
				switch (choice_str) {
				case 0:
					System.out.println("<*>");
					System.exit(0);
				case 1:
					UserCreate.run();
					break;
				case 2:
					UserShow.run();
					break;
				case 3:
					UserUpdate.run();
					break;
				case 4:
					UserDelete.run();
					break;
				case 5:
					UserList.run(args);
					break;
				default:
					err.println(HelloWorldMain.bundle.getString("ChooseErr"));
				}
			} catch (NumberFormatException e) {
				err.println(HelloWorldMain.bundle.getString("NumberErr"));
			}
		} while (true);
	}

}
