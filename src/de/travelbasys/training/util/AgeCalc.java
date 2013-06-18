package de.travelbasys.training.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Diese Klasse ist für die berechnung des Alters eines Customer-Objekts anhand
 * des Geburtsdatums verantwortlich.
 * 
 * @author haut
 * 
 */
public class AgeCalc {

	private static Calendar now = Calendar.getInstance();

	public static int getAge(Date birthdate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(birthdate);
		int age = 0;

		if (now.before(cal))
			return -1;

		age = now.get(Calendar.YEAR) - cal.get(Calendar.YEAR);

		if ((now.get(Calendar.MONTH) < cal.get(Calendar.MONTH))
				|| (now.get(Calendar.MONTH) == cal.get(Calendar.MONTH) && now
						.get(Calendar.DAY_OF_MONTH) < cal
						.get(Calendar.DAY_OF_MONTH)))
			--age;

		return age;
	}

}