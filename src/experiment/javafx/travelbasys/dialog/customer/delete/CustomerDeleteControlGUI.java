package experiment.javafx.travelbasys.dialog.customer.delete;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Dialogs;
import javafx.scene.control.Dialogs.DialogOptions;
import javafx.scene.control.Dialogs.DialogResponse;
import javafx.stage.Stage;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.framework.Control;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

public class CustomerDeleteControlGUI implements Control {

	private CustomerDeleteModelGUI model;

	public CustomerDeleteControlGUI(Model model) {
		this.model = (CustomerDeleteModelGUI) model;
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

					// Erzeuge Dialog-Options-Objekt

					DialogOptions options = DialogOptions.YES_NO;
					if (model.getData().get(0) != null) {

						// Übergebe Rückgabewert des
						// ConfirmDialoges an
						// Dialog-Response-Objekt
						// Optionen werden ans zu zeigende
						// Dialog-Objekt weitergegeben (letztes
						// Feld)

						DialogResponse response = Dialogs.showConfirmDialog(
								(Stage) model.getRoot().getScene().getWindow(),
								"Lastname: "
										+ model.getData().get(0).getLastName()
										+ "\nFirstname: "
										+ model.getData().get(0).getFirstName()
										+ "\nAge: "
										+ model.getData().get(0).getAge()
										+ "\nAdress: "
										+ model.getData().get(0).getAdress()
										+ "\nPostalcode: "
										+ model.getData().get(0)
												.getPostalcode() + "\neMail: "
										+ model.getData().get(0).getEmail()
										+ "\nDelete?", "Customer found: "
										+ model.getTxt_customerid().getText(),
								"Travelbasys Customer Manager", options);

						// Anhand des Responses vom Dialog wird
						// eine Aktion ausgeführt

						switch (response) {
						case YES:
							try {
								Dao.getDAO().delete(model.getData().get(0));
								Dialogs.showInformationDialog((Stage) model
										.getRoot().getScene().getWindow(), "",
										"Process successfully completed",
										"Travelbasys Customer Manager");
							} catch (Exception f) {
								Dialogs.showErrorDialog((Stage) model.getRoot()
										.getScene().getWindow(),
										"Unknown Error", "Error",
										"Travelbasys Customer Manager");
							}
							break;
						case NO:
							Dialogs.showInformationDialog((Stage) model
									.getRoot().getScene().getWindow(), "",
									"Process terminated.",
									"Travelbasys Customer Manager");
							break;
						default:
							break;
						}
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