package de.travelbasys.training.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Scanner;

import de.travelbasys.training.util.Config;
import de.travelbasys.training.util.Console;

public class ChangeDB {
	private static String baseName = "resources.HelloWorld";
	private static final String DATABASE_KEY = "database";
	static ResourceBundle bundle = ResourceBundle.getBundle(baseName);
	
	private static File ini = new File(Config.CONFIG_FILENAME);

	public static void run() {

		Properties config = new Properties();

		Scanner in = new Scanner(System.in);
		Console.println(bundle.getString("ChangeDB"));
		String db = in.nextLine();
		CustomerDAO.terminate();
		CustomerDAO.init(db);
		
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
