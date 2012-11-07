package de.travelbasys.training.dialog.customer.update.attributes;

import de.travelbasys.training.framework.AbstractControl;
import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

//TODO muss überarbeitet werden

/**
 * steuert den Dialog mit dem Benutzer und ändert ein temporäres Customer
 * Objekt.
 */

public class CustomerAttributesUpdateControl extends AbstractControl {

	private CustomerAttributesUpdateModel model;
	private CustomerAttributesUpdateView view;

	/**
	 * setzt den InputHandler in den UiComponents des Views, so dass temporär
	 * ein Customer Objekt des Models die eingegebenen Attribute bekommt.
	 */
	public CustomerAttributesUpdateControl(Model model, View view) {
		this.model = (CustomerAttributesUpdateModel) model;
		this.view = (CustomerAttributesUpdateView) view;

		AbstractUiComponent uic;

		uic = this.view.getLastnameComponent();
		uic.setControl(new AbstractControl() {
			// Speichert den gegebenen Wert als Lastname im Model.
			public void handleInput(Object value) throws Exception {
				checkString(value);
				CustomerAttributesUpdateControl.this.model
						.setLastName((String) value);
			}
		});

		uic = this.view.getFirstnameComponent();
		uic.setControl(new AbstractControl() {
			// Speichert den gegebenen Wert als Firstname im Model.
			public void handleInput(Object value) throws Exception {
				checkString(value);
				CustomerAttributesUpdateControl.this.model
						.setFirstName((String) value);
			}
		});

		uic = this.view.getAgeComponent();
		uic.setControl(new AbstractControl() {
			// Speichert den gegebenen Wert als Age im Model.
			public void handleInput(Object value) throws Exception {
				checkAge(value);
				CustomerAttributesUpdateControl.this.model
						.setAge((Integer) value);
			}
		});

		uic = this.view.getAdressComponent();
		uic.setControl(new AbstractControl() {
			// Speichert den gegebenen Wert als Adress im Model.
			public void handleInput(Object value) throws Exception {
				checkString(value);
				CustomerAttributesUpdateControl.this.model
						.setAdress((String) value);
			}
		});

		uic = this.view.getPostalcodeComponent();
		uic.setControl(new AbstractControl() {
			// Speichert den gegebenen Wert als Postalcode im Model.
			public void handleInput(Object value) throws Exception {
				checkPostalcode(value);
				CustomerAttributesUpdateControl.this.model
						.setPostalcode((String) value);
			}
		});

		uic = this.view.getEMailComponent();
		uic.setControl(new AbstractControl() {
			// Speichert den gegebenen Wert als EMail im Model.
			public void handleInput(Object value) throws Exception {
				checkString(value);
				CustomerAttributesUpdateControl.this.model
						.setEMail((String) value);
			}
		});
	}

	private void checkAge(Object value) throws Exception {
		int age = (Integer) value;
		if (age < 0 || age > 150) {
			throw new Exception("AgeNotInRangeErr");
		}
	}

	private void checkPostalcode(Object value) throws Exception {
		try {
			String postalcode = (String) value;
			int postalcodetemp = Integer.parseInt(postalcode);
			if (postalcodetemp > 0 && (postalcode.length() == 5)) {
			} else
				throw new Exception("PostalNotInRangeErr");
		} catch (NumberFormatException e) {
			throw new Exception("IllegalNumberFormat");
		}
	}

	private void checkString(Object value) throws Exception {

		String s = (String) value;
		if (s.isEmpty()) {
			throw new Exception("EmptyFieldErr");
		}

	}
}