package de.travelbasys.training.dialog.customer.showandchange;

import de.travelbasys.training.framework.AbstractControl;
import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
//TODO muss überarbeitet werden

/**
 * hat die Aufgabe, einen View innerhalb des ShowAndChange Dialoges zu steuern.
 * 
 * Die aktuelle Implementierung führt Dialoge aus die die vom Benutzer
 * ausgewählten Werte abfragt, außerdem wird geprüft ob es sich um gültige
 * eingaben handelt.
 * 
 */

public class ShowAndChangeControl extends AbstractControl {

	private ShowAndChangeModel model;
	private ShowAndChangeView view;

	/**
	 * Diese Methode Initialisiert die eingegebenen Werte die anschließend
	 * überprüft werden.
	 */
	public void init(Model model, View view) {
		this.model = (ShowAndChangeModel) model;
		this.view = (ShowAndChangeView) view;
		AbstractUiComponent uic;

		uic = this.view.getCustomerLastnameComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				ShowAndChangeControl.this.model
						.setCustomerLastname((String) value);
			}
		});

		uic = this.view.getCustomerFirstnameComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				ShowAndChangeControl.this.model
						.setCustomerFirstname((String) value);
			}
		});

		uic = this.view.getCustomerAgeComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				checkAge(value);
				ShowAndChangeControl.this.model.setCustomerAge((Integer) value);
			}
		});

		uic = this.view.getCustomerAdressComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				ShowAndChangeControl.this.model
						.setCustomerAdress((String) value);
			}
		});

		uic = this.view.getCustomerPostalcodeComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				checkPostalcode(value);
				ShowAndChangeControl.this.model
						.setCustomerPostalcode((String) value);
			}
		});

		uic = this.view.getCustomerEMailComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				ShowAndChangeControl.this.model
						.setCustomerEMail((String) value);
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
		model.setIndex(model.getIndex() - 1);
	}
}