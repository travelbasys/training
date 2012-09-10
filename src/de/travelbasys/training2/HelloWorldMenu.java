package de.travelbasys.training2;

import java.io.PrintStream;
import java.util.ResourceBundle;
import java.util.Scanner;

public class HelloWorldMenu {

	private static String baseName = "resources.HelloWorld";
	static ResourceBundle bundle = ResourceBundle.getBundle(baseName);
	private static Scanner in;
	
	static void show(String[] args, HelloWorldUI ui, UserList ul) {
		PrintStream out = System.out;
		PrintStream err = System.err;
	
		out.println(bundle.getString("Choose"));
		out.println("1: " + bundle.getString("App1"));
		out.println("2: " + bundle.getString("App2"));
		out.println("3: " + bundle.getString("App3"));
		out.println("4: " + bundle.getString("App4"));
		out.println("5: " + bundle.getString("App5"));
	
		in = new Scanner(System.in);
		String choice_str = in.nextLine();
	
		try {
			choice_str = choice_str.trim();
			int choice_int = Integer.parseInt(choice_str);
			
			if (choice_int == 1) {
				ui.run();
			} else if (choice_int == 5) {
				UserList.list(args);
			} else {
				err.println(HelloWorldMain.bundle.getString("ChooseErr"));
			}
		} catch (NumberFormatException e) {
			err.println(HelloWorldMain.bundle.getString("NumberErr"));
		}
	}

}
