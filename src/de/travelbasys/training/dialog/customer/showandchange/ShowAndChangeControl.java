package de.travelbasys.training.dialog.customer.showandchange;

import java.util.List;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.framework.AbstractControl;
import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

public class ShowAndChangeControl extends AbstractControl {

	List<Customer> customertemplist;
	Customer tempcustomer;
	private ShowAndChangeModel model;
	private ShowAndChangeView view;

	public void init(Model model, View view) {
		this.model = (ShowAndChangeModel) model;
		this.view = (ShowAndChangeView) view;
		customertemplist = CustomerDAO
				.findUserByID(ShowAndChangeControl.this.model.getCustomerid());
		tempcustomer = customertemplist.get(0);
		AbstractUiComponent uic;

		uic = this.view.getCustomerLastnameComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				ShowAndChangeControl.this.model
						.setCustomerLastname((String) value);
				tempcustomer.setLastName((String) value);
				ShowAndChangeControl.this.model.setLastnameFlag(true);
				System.out.println(tempcustomer);
				System.out.println(customertemplist);
			}
		});

		uic = this.view.getCustomerFirstnameComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				ShowAndChangeControl.this.model
						.setCustomerFirstname((String) value);
				tempcustomer.setFirstName((String) value);
				ShowAndChangeControl.this.model.setFirstnameFlag(true);
			}
		});

		uic = this.view.getCustomerAgeComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				checkAge(value);
				ShowAndChangeControl.this.model.setCustomerAge((Integer) value);
				tempcustomer.setAge((Integer) value);
				ShowAndChangeControl.this.model.setAgeFlag(true);
			}
		});
		
		uic = this.view.getCustomerAdressComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				ShowAndChangeControl.this.model
						.setCustomerAdress((String) value);
				tempcustomer.setAdress((String) value);
				ShowAndChangeControl.this.model.setAdressFlag(true);
			}
		});
		
		uic = this.view.getCustomerPostalcodeComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				checkPostalcode(value);
				ShowAndChangeControl.this.model
						.setCustomerPostalcode((String) value);
				tempcustomer.setPostalcode((String) value);
				ShowAndChangeControl.this.model.setPostalcodeFlag(true);
			}
		});
		
		uic = this.view.getCustomerEMailComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				ShowAndChangeControl.this.model
						.setCustomerEMail((String) value);
				tempcustomer.setEMail((String) value);
				ShowAndChangeControl.this.model.setEMailFlag(true);
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
}