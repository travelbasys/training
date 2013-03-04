package de.travelbasys.trainingfx.dialog.customer.list;

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

	/**
	 * Diese Methode lädt alle Customer Objekte aus der Datenbank und setzt
	 * diese ins Model und in einer Tabelle des Views.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void init(Model model, View view) {
		this.model = (CustomerListModelGUI) model;
		this.view = (CustomerListViewGUI) view;
		data = FXCollections.observableArrayList(Dao.getDAO().findAll());
		CustomerListControlGUI.this.model.setData(data);
		CustomerListControlGUI.this.view.getTable().setItems(
				CustomerListControlGUI.this.model.getData());
	}

	@Override
	public void handleInput(Object value) throws Exception {

	}
}
