package experiment.javafx.travelbasys.dialog.customer.update;

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

public class CustomerUpdateControlGUI implements Control {

	private CustomerUpdateModelGUI model;

	public CustomerUpdateControlGUI(Model model) {
		this.model = (CustomerUpdateModelGUI) model;
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
					Customer customer = new Customer(Integer.parseInt(model
							.getTxt_customerid().getText()), model
							.getTxt_lastname().getText(), model
							.getTxt_firstname().getText(), Integer
							.parseInt(model.getTxt_age().getText()), model
							.getTxt_adress().getText(), model
							.getTxt_postalcode().getText(), model
							.getTxt_email().getText());
					Dao.getDAO().update(customer);
					Dialogs.showInformationDialog((Stage) model.getRoot()
							.getScene().getWindow(), "Transaction successful.",
							"Information", "Travelbasys Customer Manager");
					deactivateSend();
				} catch (NumberFormatException d) {
					Dialogs.showErrorDialog((Stage) model.getRoot().getScene()
							.getWindow(), "Wrong syntax.", "Error",
							"Travelbasys Customer Manager");
				} catch (IllegalArgumentException d) {
					Dialogs.showErrorDialog((Stage) model.getRoot().getScene()
							.getWindow(), "Wrong syntax.", "Error",
							"Travelbasys Customer Manager");
				}
			}

			private void deactivateSend() {
				model.getBtn().setDisable(true);
			}

		});

		model.getBtn2().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				try {
					if (model.getData().get(0) != null) {
						DialogOptions options = DialogOptions.YES_NO;
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
										+ "\nBearbeiten? ", "Customer found: "
										+ model.getTxt_customerid().getText(),
								"Travelbasys Customer Manager", options);
						switch (response) {
						case YES:
							activateEdit();
							deactivateSearch();
							activateNewSearch();
						case NO:
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

			private void activateNewSearch() {
				model.getBtn3().setDisable(false);
			}

			private void deactivateSearch() {
				model.getTxt_customerid().setEditable(false);
				model.getBtn2().setDisable(true);
			}

			private void activateEdit() {
				model.getTxt_lastname().setEditable(true);
				model.getTxt_lastname().setText(
						model.getData().get(0).getLastName());

				model.getTxt_firstname().setEditable(true);
				model.getTxt_firstname().setText(
						model.getData().get(0).getFirstName());

				model.getTxt_age().setEditable(true);
				model.getTxt_age().setText(
						String.valueOf(model.getData().get(0).getAge()));

				model.getTxt_adress().setEditable(true);
				model.getTxt_adress().setText(
						model.getData().get(0).getAdress());

				model.getTxt_postalcode().setEditable(true);
				model.getTxt_postalcode().setText(
						model.getData().get(0).getPostalcode());

				model.getTxt_email().setEditable(true);
				model.getTxt_email().setText(model.getData().get(0).getEmail());

				model.getBtn().setDisable(false);
			}

		});
	}
}
