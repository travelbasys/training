package de.travelbasys.training.dialog.customer.showandchange;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dialog.customer.show1.CustomerShow1Dialog;
import de.travelbasys.training.dialog.customer.showandchange1.ShowAndChange1Dialog;
import de.travelbasys.training.framework.Dialog;

/**
 * ist verantwortlich für das löschen eines Benutzers aus der Datenbank
 * 
 * @author tba
 * 
 */
public class ShowAndChangeDialog implements Dialog {

	private ShowAndChangeView view;
	private ShowAndChangeModel model;
	private ShowAndChangeControl control;
	private Customer customer;
	private int customerid;
	private static int index;

	@Override
	public void run() {
		do {
			CustomerShow1Dialog d2 = new CustomerShow1Dialog();
			d2.setCustomer(customer);
			d2.init();
			d2.run();

			ShowAndChange1Dialog d3 = new ShowAndChange1Dialog();
			d3.init();
			d3.run();
			index = d3.getIndex();
			if (index == -1) {
				model.setEndFlag(true);
				return;
			}
			model.setIndex(index);
			view.run();
		} while (model.getEndFlag() == false);
	}

	public void init() {
		model = new ShowAndChangeModel();
		control = new ShowAndChangeControl();
		view = new ShowAndChangeView();
		model.setCustomerid(customerid);
		model.setCustomer(customer);
		view.init(model);
		control.init(model, view);

	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCustomerLastname() {
		return model.getCustomerLastname();
	}

	public String getCustomerFirstname() {
		return model.getCustomerFirstname();
	}

	public int getCustomerAge() {
		return model.getCustomerAge();
	}

	public String getCustomerAdress() {
		return model.getCustomerAdress();
	}

	public String getCustomerPostalcode() {
		return model.getCustomerPostalcode();
	}

	public String getCustomerEMail() {
		return model.getCustomerEMail();
	}

	public boolean getLastnameFlag() {
		return model.getLastnameFlag();
	}

	public boolean getFirstnameFlag() {
		return model.getFirstnameFlag();
	}

	public boolean getAgeFlag() {
		return model.getAgeFlag();
	}

	public boolean getAdressFlag() {
		return model.getAdressFlag();
	}

	public boolean getPostalcodeFlag() {
		return model.getPostalcodeFlag();
	}

	public boolean getEMailFlag() {
		return model.getEMailFlag();
	}

	public void setCustomerID(int userID) {
this.customerid = userID;		
	}

}
