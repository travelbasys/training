package de.travelbasys.trainingfx.dialog.customer.show;

import javafx.collections.ObservableList;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.Model;

public class CustomerShowModelGUI implements Model {

	private ObservableList<Customer> data;
	private int customerid;

	public ObservableList<Customer> getData() {
		return data;
	}

	public void setData(ObservableList<Customer> data) {
		this.data = data;
	}

	public CustomerShowModelGUI() {

	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public boolean isInvalid() {
		return customerid == 0;
	}

	public boolean isValid() {
		return !isInvalid();
	}

}