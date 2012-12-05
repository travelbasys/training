package experiment.javafx.travelbasys.dialog.customer.delete;

import javafx.collections.ObservableList;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.Model;

//Soll nur g�ltige/validierte Daten enthalten.

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
	}

	public ObservableList<Customer> getData() {
		return data;
	}

}
