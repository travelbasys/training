package de.travelbasys.trainingfx.dialog.customer.delete;

import javafx.collections.ObservableList;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.Model;

//Soll nur gültige/validierte Daten enthalten.

public class CustomerDeleteModelGUI implements Model {
	private int customerid;
	private ObservableList<Customer> data;

	public CustomerDeleteModelGUI() {
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public void setData(ObservableList<Customer> data) {
		this.data = data;
	}

	public ObservableList<Customer> getData() {
		return data;
	}

	public boolean isInvalid() {
		return customerid == 0;
	}

	public boolean isValid() {
		return !isInvalid();
	}

}
