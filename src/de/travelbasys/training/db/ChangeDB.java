package de.travelbasys.training.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Config;

public class ChangeDB {
	private static final String DATABASE_KEY = "database";
	private static File ini = new File(Config.CONFIG_FILENAME);

	public static void run() {

		Properties config = new Properties();

		Scanner in = new Scanner(System.in);
		AppContext.getString("ChangeDB");
		String db = in.nextLine();
		CustomerDAO.terminate();
		CustomerDAO.init(db);

		try {
			config.load(new FileInputStream(ini));
			config.setProperty(DATABASE_KEY, db);
			config.store(new FileOutputStream(ini),
					"Travelbasys User Manager - Properties");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void run2() {

		Scanner in = new Scanner(System.in);
		AppContext.getString("ChangeDB");
		String db = in.nextLine();
		db = db.trim();
		if (!db.isEmpty()) {
			CustomerDAO.terminate();
			CustomerDAO.init(db);
		} else
			throw new IllegalArgumentException();
	}

}
