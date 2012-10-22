package de.travelbasys.training.dialog.customer.create;

import de.travelbasys.training.framework.AbstractControl;
import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

/**
 */
public class CustomerCreateControl extends AbstractControl {

	private CustomerCreateModel model;
	private CustomerCreateView view;

	public void init(Model model, View view) {
		this.model = (CustomerCreateModel) model;
		this.view = (CustomerCreateView) view;

		AbstractUiComponent uic;

		uic = this.view.getCustomerLastnameComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				CustomerCreateControl.this.model
						.setCustomerLastname((String) value);
			}
		});

		uic = this.view.getCustomerFirstnameComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				CustomerCreateControl.this.model
						.setCustomerFirstname((String) value);
			}
		});

		uic = this.view.getCustomerAgeComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				checkage(value);
				CustomerCreateControl.this.model
						.setCustomerAge((Integer) value);
			}

		});
		uic = this.view.getCustomerAdressComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				CustomerCreateControl.this.model
						.setCustomerAdress((String) value);
			}
		});
		uic = this.view.getCustomerPostalcodeComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				checkpostalcode(value);
				CustomerCreateControl.this.model
						.setCustomerPostalcode((String) value);
			}

		});
		uic = this.view.getCustomerEMailComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				CustomerCreateControl.this.model
						.setCustomerEMail((String) value);
			}
		});
	}

	private void checkage(Object value) throws Exception {

		int age = (Integer) value;
		if (age < 0 || age > 150) {
			throw new Exception("AgeNotInRangeErr");
		}
		model.setCustomerAge(age);
	}

	private void checkpostalcode(Object value) throws Exception {
		try {
			String postalcode = (String) value;
			int postalcodetemp = Integer.parseInt(postalcode);
			if (postalcodetemp > 0 && (postalcode.length() == 5)) {
				model.setCustomerPostalcode(postalcode);
			} else
				throw new Exception("PostalNotInRangeErr");
		} catch (NumberFormatException e) {
			throw new Exception("IllegalNumberFormat");
		}

	}
}

/*
 * public void check(String fieldName, String value) throws Exception {
 * 
 * if (fieldName == "PostalCode") { if ((Integer.parseInt(value) > 0 &&
 * value.length() == 5)) { } else {
 * 
 * } } }
 */
