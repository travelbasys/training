package de.travelbasys.training.db;

/**
 * Diese Klasse Kontrolliert Benutzereingaben.
 * @author tba
 *
 */
public class ChangeDBControl {

	public void check(String fieldName, String value) {
		if (value.isEmpty())
			throw new IllegalArgumentException();

	}
}
