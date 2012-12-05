package experiment.javafx.travelbasys.dialog.customer.update;

import javafx.collections.ObservableList;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.Model;

public class CustomerUpdateModelGUI implements Model {

	private ObservableList<Customer> data;

	public void setData(ObservableList<Customer> data) {
		this.data = data;
	}

	public ObservableList<Customer> getData() {
		return data;
	}
	
	
}
