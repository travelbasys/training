package de.travelbasys.training2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ChangeDB {
	private static String baseName = "resources.HelloWorld";
	private static final String DATABASE_KEY = "database";
	static ResourceBundle bundle = ResourceBundle.getBundle(baseName);
	private static final String CONFIG_FILENAME = "HelloWorld.ini";
	static File ini = new File(CONFIG_FILENAME);

	public static void run() {

		Properties config = new Properties();

		Scanner in = new Scanner(System.in);
		System.out.println(bundle.getString("ChangeDB"));
		String db = in.nextLine();
		UserDB.terminate();
		UserDB.init(db);
		
		try {
			config.load(new FileInputStream(ini));
			config.setProperty(DATABASE_KEY, db);
			config.store(new FileOutputStream(ini), "Travelbasys User Manager - Properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
