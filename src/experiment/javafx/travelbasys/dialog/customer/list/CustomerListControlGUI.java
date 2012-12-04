package experiment.javafx.travelbasys.dialog.customer.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.framework.Control;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

public class CustomerListControlGUI implements Control {

	private CustomerListModelGUI model;

	public CustomerListControlGUI(Model model) {
		this.model = (CustomerListModelGUI) model;
	}

	@Override
	public void init(Model model, View view) {

	}

	@Override
	public void handleInput(Object value) throws Exception {

	}

	public void buildEventHandler() {
		ObservableList<Customer> data = FXCollections.observableArrayList(Dao.getDAO().findAll());
		model.setData(data);
	}
}
