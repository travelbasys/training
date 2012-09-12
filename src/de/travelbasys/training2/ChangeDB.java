package de.travelbasys.training2;

import java.util.ResourceBundle;
import java.util.Scanner;

public class ChangeDB {
	private static String baseName = "resources.HelloWorld";
	static ResourceBundle bundle = ResourceBundle.getBundle(baseName);

	public static void run(){
		Scanner in = new Scanner(System.in);
		System.out.println(bundle.getString("ChangeDB"));
		String db = in.nextLine();
		UserDB.terminate();
		UserDB.init(db);
		}
	}


