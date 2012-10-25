package de.travelbasys.training.dialog.customer.showandchange;

import de.travelbasys.training.framework.AbstractControl;
import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

//TODO muss überarbeitet werden

/**
 * steuert den Dialog mit dem Benutzer und ändert ein temporäres Customer Objekt.
 */

public class ShowAndChangeControl extends AbstractControl {

	private ShowAndChangeModel model;
	private ShowAndChangeView view;

	/**
	 * setzt den InputHandler in den UiComponents des Views, so dass temporär
	 * ein Customer Objekt des Models die eingegebenen Attribute bekommt.
	 */
	public void init(Model model, View view) {
		this.model = (ShowAndChangeModel) model;
		this.view = (ShowAndChangeView) view;
		
		AbstractUiComponent uic;

		uic = this.view.getCustomerLastnameComponent();
		uic.setControl(new AbstractControl() {
			// Speichert den gegebenen Wert als Lastname im Model.
			public void handleInput(Object value) throws Exception {
				ShowAndChangeControl.this.model
						.setLastName((String) value);
			}
		});

		uic = this.view.getCustomerFirstnameComponent();
		uic.setControl(new AbstractControl() {
			// Speichert den gegebenen Wert als Firstname im Model.
			public void handleInput(Object value) throws Exception {
				ShowAndChangeControl.this.model
						.setFirstName((String) value);
			}
		});

		uic = this.view.getCustomerAgeComponent();
		uic.setControl(new AbstractControl() {
			// Speichert den gegebenen Wert als Age im Model.
			public void handleInput(Object value) throws Exception {
				checkAge(value);
				ShowAndChangeControl.this.model.setAge((Integer) value);
			}
		});

		uic = this.view.getCustomerAdressComponent();
		uic.setControl(new AbstractControl() {
			// Speichert den gegebenen Wert als Adress im Model.
			public void handleInput(Object value) throws Exception {
				ShowAndChangeControl.this.model
						.setAdress((String) value);
			}
		});

		uic = this.view.getCustomerPostalcodeComponent();
		uic.setControl(new AbstractControl() {
			// Speichert den gegebenen Wert als Postalcode im Model.
			public void handleInput(Object value) throws Exception {
				checkPostalcode(value);
				ShowAndChangeControl.this.model
						.setPostalcode((String) value);
			}
		});

		uic = this.view.getCustomerEMailComponent();
		uic.setControl(new AbstractControl() {
			// Speichert den gegebenen Wert als EMail im Model.
			public void handleInput(Object value) throws Exception {
				ShowAndChangeControl.this.model
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

	/**
	 * subtraiert den aktuellen Index mit 1
	 */
	public void fix() {
		model.setComponentIndex(model.getIndex() - 1);
	}
}