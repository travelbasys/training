package experiment.javafx.travelbasys.dialog.customer.delete;

import de.travelbasys.training.framework.Model;

//Soll nur gültige/validierte Daten enthalten.

public class CustomerDeleteModelGUI implements Model {
	private int customerid;

	public CustomerDeleteModelGUI() {
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

}
