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
	private ObservableList<Customer> data;
	private CustomerListViewGUI view;

	public CustomerListControlGUI() {
	}

	@SuppressWarnings("unchecked")
	@Override
	public void init(Model model, View view) {
		this.model = (CustomerListModelGUI) model;
		this.view = (CustomerListViewGUI) view;
		data = FXCollections.observableArrayList(Dao.getDAO().findAll());
		CustomerListControlGUI.this.model.setData(data);
		CustomerListControlGUI.this.view.getTable().setItems(data);
	}

	@Override
	public void handleInput(Object value) throws Exception {

	}
}
