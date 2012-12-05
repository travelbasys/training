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
import de.travelbasys.training.util.AppContext;

public class CustomerShowControlGUI implements Control {

	private CustomerShowModelGUI model;
	private CustomerShowViewGUI view;
	private ObservableList<Customer> data;

	CustomerShowControlGUI() {
	}

	@Override
	public void init(Model model, View view) {
		this.model = (CustomerShowModelGUI) model;
		this.view = (CustomerShowViewGUI) view;

		this.view.getSearchButton().setOnAction(
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						try {

							data = FXCollections.observableArrayList(Dao
									.getDAO()
									.findById(
											Integer.parseInt(CustomerShowControlGUI.this.view
													.getCustomerIDField()
													.getText())));
							CustomerShowControlGUI.this.model.setData(data);

							if (CustomerShowControlGUI.this.model.getData()
									.get(0) != null) {
								Dialogs.showInformationDialog(
										(Stage) CustomerShowControlGUI.this.view
												.getRoot().getScene()
												.getWindow(),
										AppContext.getMessage("Lastname")
												+ CustomerShowControlGUI.this.model
														.getData().get(0)
														.getLastName()
												+ "\n"+AppContext.getMessage("Firstname")
												+ CustomerShowControlGUI.this.model
														.getData().get(0)
														.getFirstName()
												+ "\n"+AppContext.getMessage("Age")
												+ CustomerShowControlGUI.this.model
														.getData().get(0)
														.getAge()
												+ " \n"+AppContext.getMessage("Adress")
												+ CustomerShowControlGUI.this.model
														.getData().get(0)
														.getAdress()
												+ "\n"+AppContext.getMessage("Postalcode")
												+ CustomerShowControlGUI.this.model
														.getData().get(0)
														.getPostalcode()
												+ "\n"+AppContext.getMessage("Email")
												+ CustomerShowControlGUI.this.model
														.getData().get(0)
														.getEmail(),
										AppContext.getMessage("CustomerWithID") +
												 CustomerShowControlGUI.this.view
														.getCustomerIDField()
														.getText() +" "+ AppContext.getMessage("Found"),
														AppContext.getMessage("TravelbasysManager"));
								CustomerShowControlGUI.this.view
								.clear();
							} else {
								Dialogs.showErrorDialog(
										(Stage) CustomerShowControlGUI.this.view
												.getRoot().getScene()
												.getWindow(),
										"Customer with CustomerID "
												+ CustomerShowControlGUI.this.view
														.getCustomerIDField()
														.getText()+" does not exsist!\nPlease enter an exsisting CustomerID.", "Error",
										"Travelbasys Customer Manager");
								CustomerShowControlGUI.this.view
								.clear();
							}
						} catch (NumberFormatException d) {
							Dialogs.showErrorDialog(
									(Stage) CustomerShowControlGUI.this.view
											.getRoot().getScene().getWindow(),
									"Wrong syntax for input: "
											+ CustomerShowControlGUI.this.view
													.getCustomerIDField()
													.getText()+"\nThe CustomerID should be a number.", "Error",
									"Travelbasys Customer Manager");
							CustomerShowControlGUI.this.view
							.clear();
						}
					}
				});
	}

	@Override
	public void handleInput(Object value) throws Exception {
	}

}
