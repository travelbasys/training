package de.travelbasys.training.dialog.customer.create;

import de.travelbasys.training.dialog.Control;
import de.travelbasys.training.dialog.Model;
import de.travelbasys.training.util.AppContext;
/**
 * Diese Klasse Kontrolliert Benutzereingaben.
 * @author tba
 *
 */
public class CustomerCreateControl implements Control {

	public CustomerCreateControl(Model model) {
	}

	@Override
	public void check(String fieldName, String value) throws Exception {

		if (fieldName == "Age") {
			int temp = Integer.parseInt(value);
			if (temp <= 0 || temp > 150) {
				throw new IllegalArgumentException(AppContext.getMessage("AgeNotInRangeErr") + value);
			}
		}
		if (fieldName == "PostalCode") {
			if ((Integer.parseInt(value) > 0 && value.length() == 5)) {
			} else {
				throw new Exception(
						AppContext.getMessage("PostalNotInRangeErr") + value);
			}
		}
	}
}
