package de.travelbasys.training.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	public static String getFormattedString(Date date) {
		SimpleDateFormat sdf;
		if (Locale.getDefault().getLanguage() == "de") {
			sdf = new SimpleDateFormat("dd.MM.yyyy");
		} else {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		}
		return sdf.format(date);
	}

	public static Date getFormattedDate(String value) {
		Matcher matcher1;
		Matcher matcher2;
		Date date = null;
		SimpleDateFormat gerDateFormat = new SimpleDateFormat("dd.MM.yyyy");
		SimpleDateFormat isoDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Pattern gerPattern = Pattern
				.compile("([0-2]?[0-9]|30|31)\\.([0]?[0-9]|10|11|12)\\.[0-9][0-9][0-9][0-9]");
		Pattern isoPattern = Pattern
				.compile("([0-9][0-9][0-9][0-9]\\-([0]?[0-9]|10|11|12)\\-[0-2]?[0-9]|30|31)");
		try {
			matcher1 = isoPattern.matcher(value);
			matcher2 = gerPattern.matcher(value);
			if (matcher1.matches()) {
				date = isoDateFormat.parse(value);
			} else if (matcher2.matches()) {
				date = gerDateFormat.parse(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return date;
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
