package de.travelbasys.training2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

public class UserDB {

	private static final String FILE = "HelloWorld.txt";
	private static final String TEMP = "HelloWorld.temp";

	private static String baseName = "resources.HelloWorld";
	static ResourceBundle bundle = ResourceBundle.getBundle(baseName);

	private static final File file = new File(FILE);
	private static final File temp = new File(TEMP);

	/**
	 * Finde einen User in der Datenbank mit dem gegebenen Namen.
	 * 
	 * @param username
	 *            der gegebene Name.
	 * @return ein User Objekt oder null, wenn nicht gefunden.
	 */
	public static User findUserByName(String username) {
		User user = null;
		FileReader fr;
		BufferedReader br;
		try {
			fr = new FileReader(FILE);
			br = new BufferedReader(fr);
			String s;
			while ((s = br.readLine()) != null) {
				User temp = User.parse(s);

				// Wenn gefunden...
				if (temp.getName().equals(username)) {
					user = temp;
					break;
				}
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * Ersetze den User in der Datenbank, dessen Namen mit dem Namen des
	 * gegebenen User Objekts übereinstimmt, durch den gegebenen User.
	 * 
	 * @param user
	 *            ein User Objekt.
	 */
	public static void update(User user) {

		try {

			FileReader fr = new FileReader(FILE);
			BufferedReader br = new BufferedReader(fr);

			FileWriter fw = new FileWriter(FILE, true);
			PrintWriter pw = new PrintWriter(fw);

			FileWriter fwtmp = new FileWriter(TEMP, true);
			PrintWriter pwtmp = new PrintWriter(fwtmp);

			String s;
			User tempUser;

			while ((s = br.readLine()) != null) {
				tempUser = User.parse(s);

				// Wenn gefunden...
				if (tempUser.getName().equals(user.getName())) {
					pwtmp.println(user);
				} else {
					pwtmp.println(tempUser);
				}
			}

			fr.close();
			pw.close();
			pwtmp.close();

			// Alte Datenbank löschen.
			file.delete();

			// Temporäre Datei wird neue Datenbank.
			if (!temp.renameTo(file)) {
				System.err.println(bundle.getString("RenameErr")
						+ file.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Überspringe den User in der Datenbank, dessen Namen mit dem Namen des
	 * gegebenen User Objekts übereinstimmt.
	 * Lösche dann die Datenbank und lege sie neu an 
	 * in die der übersprungene User nicht gespeichert wird.
	 * 
	 * @param user
	 *            ein User Objekt.
	 */
	public static User deleteUserByName(String username) {
		User user = null;
		try {
			FileReader fr = new FileReader(FILE);
			BufferedReader br = new BufferedReader(fr);

			FileWriter fw = new FileWriter(FILE, true);
			PrintWriter pw = new PrintWriter(fw);

			FileWriter fwtmp = new FileWriter(TEMP, true);
			PrintWriter pwtmp = new PrintWriter(fwtmp);

			String s;
			while ((s = br.readLine()) != null) {
				User temp = User.parse(s);

				// Wenn gefunden...
				if (temp.getName().equals(username)) {
					br.readLine();
					continue;
				} else {
					user = User.parse(s);
				}
				pwtmp.println(user);
			}
			System.out.println(bundle.getString("DelOK"));
			fr.close();
			pw.close();
			pwtmp.close();

			file.delete();

			// Temporäre Datei wird neue Datenbank.
			if (!temp.renameTo(file)) {
				System.err.println(bundle.getString("RenameErr")
						+ file.getName());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return user;
	} }
