package experiment.javafx.travelbasys.dialog.customer.show;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Dialogs;
import javafx.stage.Stage;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.framework.Control;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

public class CustomerShowControlGUI implements Control {

	@SuppressWarnings("unused")
	private CustomerShowModelGUI model;
	private CustomerShowViewGUI view;
	private ObservableList<Customer> data;

	CustomerShowControlGUI() {
	}

	@Override
	public void init(Model model, View view) {
		this.model = (CustomerShowModelGUI) model;
		this.view = (CustomerShowViewGUI) view;
		
		this.view.getSearchButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {

					data = FXCollections
							.observableArrayList(Dao.getDAO().findById(
									Integer.parseInt(CustomerShowControlGUI.this.view.getCustomeridTextField()
											.getText())));
					CustomerShowControlGUI.this.model.setData(data);

					if (CustomerShowControlGUI.this.model.getData().get(0) != null) {
						Dialogs.showInformationDialog((Stage) CustomerShowControlGUI.this.view.getRoot()
								.getScene().getWindow(), "Lastname: "
								+ CustomerShowControlGUI.this.view.getData().get(0).getLastName()
								+ "\nFirstname: "
								+ CustomerShowControlGUI.this.view.getData().get(0).getFirstName()
								+ "\nAge: " + CustomerShowControlGUI.this.view.getData().get(0).getAge()
								+ "\nAdress: "
								+ CustomerShowControlGUI.this.view.getData().get(0).getAdress()
								+ "\nPostalcode: "
								+ CustomerShowControlGUI.this.view.getData().get(0).getPostalcode()
								+ "\neMail: "
								+ CustomerShowControlGUI.this.view.getData().get(0).getEmail(),
								"Customer found: "
										+ CustomerShowControlGUI.this.view.getCustomeridTextField().getText(),
								"Travelbasys Customer Manager");
					} else {
						Dialogs.showErrorDialog((Stage) CustomerShowControlGUI.this.view.getRoot()
								.getScene().getWindow(), "Customer not found: "
								+ CustomerShowControlGUI.this.view.getCustomeridTextField().getText(), "Error",
								"Travelbasys Customer Manager");
					}
				} catch (NumberFormatException d) {
					Dialogs.showErrorDialog((Stage) CustomerShowControlGUI.this.view.getRoot().getScene()
							.getWindow(), "Wrong syntax: "
							+ CustomerShowControlGUI.this.view.getCustomeridTextField().getText(), "Error",
							"Travelbasys Customer Manager");
				}
			}
		});
	}

	@Override
	public void handleInput(Object value) throws Exception {
	}

	
}
