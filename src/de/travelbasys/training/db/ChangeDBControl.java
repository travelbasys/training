package de.travelbasys.training.db;

import de.travelbasys.training.dialog.Control;
/**
 * Diese Klasse Kontrolliert Benutzereingaben.
 * @author tba
 *
 */
public class ChangeDBControl implements Control {

	public void check(String fieldName, String value) {
		if (value.isEmpty())
			throw new IllegalArgumentException();

	}
}
