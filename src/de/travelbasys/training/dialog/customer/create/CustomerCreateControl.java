package de.travelbasys.training.dialog.customer.create;

import de.travelbasys.training.framework.AbstractControl;
import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

/**
 * hat die Aufgabe, einen View innerhalb des ShowAndChange Dialoges zu steuern.
 * 
 * Die aktuelle Implementierung führt Dialoge aus die die Attribute eines
 * Customer Objekts abfragt, außerdem wird geprüft ob es sich um gültige
 * eingaben handelt.
 * 
 */
public class CustomerCreateControl extends AbstractControl {

	private CustomerCreateModel model;
	private CustomerCreateView view;

	/**
	 * Initialisiert den Controller mit Model und View des Packages.
	 * 
	 * Weißt einer Komponente eine Methode zur Behandlung des Inhaltes zu.
	 */

	public CustomerCreateControl(Model model, View view) {
		this.model = (CustomerCreateModel) model;
		this.view = (CustomerCreateView) view;

		AbstractUiComponent uic;

		uic = this.view.getCustomerLastnameComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				checkString(value);
				CustomerCreateControl.this.model.setLastname((String) value);
			}
		});

		uic = this.view.getCustomerFirstnameComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				checkString(value);
				CustomerCreateControl.this.model.setFirstname((String) value);
			}
		});

		uic = this.view.getCustomerAgeComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				checkAge(value);
				CustomerCreateControl.this.model.setAge((Integer) value);
			}

		});
		uic = this.view.getCustomerAdressComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				checkString(value);
				CustomerCreateControl.this.model.setAdress((String) value);
			}
		});
		uic = this.view.getCustomerPostalcodeComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				checkPostalcode(value);
				CustomerCreateControl.this.model.setPostalcode((String) value);
			}

		});
		uic = this.view.getCustomerEMailComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				checkString(value);
				CustomerCreateControl.this.model.setEMail((String) value);
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
