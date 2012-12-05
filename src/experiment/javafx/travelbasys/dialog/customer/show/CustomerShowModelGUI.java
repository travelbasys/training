package experiment.javafx.travelbasys.dialog.customer.show;

import javafx.collections.ObservableList;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.Model;

public class CustomerShowModelGUI implements Model {
	private ObservableList<Customer> data;
	public ObservableList<Customer> getData() {
		return data;
	}
	public void setData(ObservableList<Customer> data) {
		this.data = data;
	}
	public CustomerShowModelGUI() {
		
	}

}