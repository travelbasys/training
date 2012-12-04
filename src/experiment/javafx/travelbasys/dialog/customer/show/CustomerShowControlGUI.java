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

	private CustomerShowModelGUI model;

	public CustomerShowControlGUI(Model model) {
		this.model = (CustomerShowModelGUI) model;
	}

	@Override
	public void init(Model model, View view) {
	}

	@Override
	public void handleInput(Object value) throws Exception {
	}

	public void buildEventHandler() {
		model.getBtn().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {

					ObservableList<Customer> data = FXCollections
							.observableArrayList(Dao.getDAO().findById(
									Integer.parseInt(model.getTxt_customerid()
											.getText())));
					model.setData(data);

					if (model.getData().get(0) != null) {
						Dialogs.showInformationDialog((Stage) model.getRoot()
								.getScene().getWindow(), "Lastname: "
								+ model.getData().get(0).getLastName()
								+ "\nFirstname: "
								+ model.getData().get(0).getFirstName()
								+ "\nAge: " + model.getData().get(0).getAge()
								+ "\nAdress: "
								+ model.getData().get(0).getAdress()
								+ "\nPostalcode: "
								+ model.getData().get(0).getPostalcode()
								+ "\neMail: "
								+ model.getData().get(0).getEmail(),
								"Customer found: "
										+ model.getTxt_customerid().getText(),
								"Travelbasys Customer Manager");
					} else {
						Dialogs.showErrorDialog((Stage) model.getRoot()
								.getScene().getWindow(), "Customer not found: "
								+ model.getTxt_customerid().getText(), "Error",
								"Travelbasys Customer Manager");
					}
				} catch (NumberFormatException d) {
					Dialogs.showErrorDialog((Stage) model.getRoot().getScene()
							.getWindow(), "Wrong syntax: "
							+ model.getTxt_customerid().getText(), "Error",
							"Travelbasys Customer Manager");
				}
			}
		});
	}
}
