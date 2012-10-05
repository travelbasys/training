package de.travelbasys.training.db;

import de.travelbasys.training.dialog.customer.create.Control;

public class ChangeDBControl implements Control {

	public void check(String fieldName, String value) {
		if (value.isEmpty())
			throw new IllegalArgumentException();

	}
}
