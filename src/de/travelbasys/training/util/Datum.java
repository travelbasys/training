package de.travelbasys.training.util;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * Diese Klasse ist für die Datumsformatierung in andere Sprachen zuständig.
 * 
 * @author tba
 * 
 */

public class Datum {

	public static String getDate() {

		// Lege das Datumsformat fest, welches die in HelloWorldMain
		// vorgegebene Sprache (Locale) verwendet.
		Calendar cal = Calendar.getInstance();
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL,
				DateFormat.MEDIUM);
		// Benutze das obige Datumsformat für die aktuelle Zeit.

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
		return Config.BUNDLE.getString("ThankYou");
	}

}
