package de.travelbasys.training2;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

/**
 * Diese Klasse ist f�r die Datumsformatierung in andere Sprachen zust�ndig.
 * 
 * @author tba
 * 
 */

public class HelloWorldBusiness {

	String baseName = "resources.HelloWorld";
	ResourceBundle bundle = ResourceBundle.getBundle(baseName);

	public static String getDate() {
		
		// Lege das Datumsformat fest, welches die in HelloWorldMain
		// vorgegebene Sprache (Locale) verwendet.
		Calendar cal = Calendar.getInstance();
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL,
				DateFormat.MEDIUM);
		// Benutze das obige Datumsformat f�r die aktuelle Zeit.

		return df.format(cal.getTime());
	}

	public void init() {

	}

	/**
	 * Verwendet das eingestellte Sprachpaket und gibt einen String aus, der in
	 * den Properties festgelegt wurde.
	 * 
	 * @return der String der Funktion
	 */

	public String getMessage() {
		return bundle.getString("ThankYou");
	}

}
