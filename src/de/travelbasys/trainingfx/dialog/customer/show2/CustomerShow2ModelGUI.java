package de.travelbasys.trainingfx.dialog.customer.show2;

import javafx.collections.ObservableList;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.Model;

/**
 * Das Model des Show Dialogs welches Daten f�r die verarbeitung innerhalb des
 * Show Dialogs enth�lt.
 * 
 */
public class CustomerShow2ModelGUI implements Model {

	private ObservableList<Customer> data;
	private int customerid;

	public void setData(ObservableList<Customer> data) {
		this.data = data;
	}

	public ObservableList<Customer> getData() {
		return data;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public boolean searchIsInvalid() {
		return customerid == 0;
	}

	public boolean searchIsValid() {
		return !searchIsInvalid();
	}

}
