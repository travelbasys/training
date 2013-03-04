package de.travelbasys.trainingfx.dialog.customer.delete2;

import javafx.collections.ObservableList;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.Model;
/**
 * Das Model des Delete Dialogs welches Daten für die verarbeitung innerhalb des
 * Delete Dialogs enthält.
 * 
 */
public class CustomerDelete2ModelGUI implements Model {

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
