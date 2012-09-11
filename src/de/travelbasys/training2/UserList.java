package de.travelbasys.training2;

import java.io.BufferedReader;
import java.io.FileReader;

import de.travelbasys.training2.User;

public class UserList {

	private static final String FILE = "HelloWorld.txt";

	public static void run(String[] args) {
		// Datei wird eingelesen und gibt alle User Objekte der Datenbank aus.
		try {
			FileReader fr = new FileReader(FILE);
			BufferedReader br = new BufferedReader(fr);
			String s;
			while ((s = br.readLine()) != null) {
				User user = User.parse(s);
				System.out.println(user);
			}
			fr.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void init() {
		// TODO Mache irgendwas.

	}
}
