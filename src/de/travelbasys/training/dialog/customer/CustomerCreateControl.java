package de.travelbasys.training.dialog.customer;


public class CustomerCreateControl {

	public CustomerCreateControl(CustomerCreateModel model) {
	}

	public void check(String fieldName, String value) throws Exception {
		// TODO: Use switch-case statement
		if (fieldName == "Age" ) {
			Integer.parseInt(value);
		}
		if (fieldName == "PostalCode" ) {
			if ((Integer.parseInt(value) > 0 && value.length() == 5)) {
			} else {
				throw new Exception( "PostalCode error: " + value);
			}
		}
	}
}
