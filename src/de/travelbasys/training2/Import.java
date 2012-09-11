package de.travelbasys.training2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ResourceBundle;

public class Import {

	private static final String FILE = "HelloWorld.txt";
	private static final String CSV = "HelloWorld.csv";

	private static String baseName = "resources.HelloWorld";
	static ResourceBundle bundle = ResourceBundle.getBundle(baseName);

	public static void run(String[] args) {
		try {

			FileReader fr = new FileReader(CSV);
			BufferedReader br = new BufferedReader(fr);

			FileWriter fw = new FileWriter(FILE);
			PrintWriter pw = new PrintWriter(fw);

			String s;
			User tempUser;

			while ((s = br.readLine()) != null) {
				System.out.println(s);
				tempUser = User.parseCSV(s);
				pw.println(tempUser.toString());
			}
			System.out.println(bundle.getString("ImportOK"));
			fr.close();
			pw.close();
		} catch (Exception e) {

		}
	}
}
