package de.travelbasys.training2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ResourceBundle;

public class Export {

	private static final String FILE = "HelloWorld.txt";
	private static final String CSV = "HelloWorld.csv";

	private static String baseName = "resources.HelloWorld";
	static ResourceBundle bundle = ResourceBundle.getBundle(baseName);

	public static void run(String[] args) {
		try {

			// Wird zum lesen aus der txt Datei benötigt.
			FileReader fr = new FileReader(FILE);
			BufferedReader br = new BufferedReader(fr);

			// wird zum schreiben in die txt Datei benötigt.
			FileWriter fw = new FileWriter(FILE, true);
			PrintWriter pw = new PrintWriter(fw);
			
			// wird zum schreiben in die csv Datei benötigt.
			FileWriter fwcsv = new FileWriter(CSV);
			PrintWriter pwcsv = new PrintWriter(fwcsv);

			String s;
			User tempUser;
			// gibt die vorhandenen Daten aus und formatiert sie für die csv
			// Datei
			while ((s = br.readLine()) != null) {
				System.out.println(s);
				tempUser = User.parse(s);
				pwcsv.println(tempUser.toCSV());
			}
			// Gibt bei erfolgreichem Import eine bestätigung aus
			System.out.println(bundle.getString("ExportOK"));
			fr.close();
			pw.close();
			pwcsv.close();
		} catch (Exception e) {

		}
	}

}
