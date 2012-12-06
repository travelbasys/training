package experiment.javafx.travelbasys.dialog.customer.update;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Dialogs;
import javafx.scene.control.Dialogs.DialogOptions;
import javafx.scene.control.Dialogs.DialogResponse;
import javafx.stage.Stage;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.CustomerDaoException;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.framework.Control;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;

public class CustomerUpdateControlGUI implements Control {

	private CustomerUpdateModelGUI model;
	private CustomerUpdateViewGUI view;

	public CustomerUpdateControlGUI() {
	}

	@Override
	public void init(Model model, View view) {

		this.view = (CustomerUpdateViewGUI) view;
		this.model = (CustomerUpdateModelGUI) model;

		CustomerUpdateControlGUI.this.view.getSendButton().setOnAction(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {
						try {
							Customer customer = new Customer(
									Integer.parseInt(CustomerUpdateControlGUI.this.view
											.getCustomerIDField().getText()),
									CustomerUpdateControlGUI.this.view
											.getLastNameField().getText(),
									CustomerUpdateControlGUI.this.view
											.getFirstNameField().getText(),
									Integer.parseInt(CustomerUpdateControlGUI.this.view
											.getAgeField().getText()),
									CustomerUpdateControlGUI.this.view
											.getAdressField().getText(),
									CustomerUpdateControlGUI.this.view
											.getPostalcodeField().getText(),
									CustomerUpdateControlGUI.this.view
											.getEmailField().getText());
							Dao.getDAO().getExisting(customer);
							Dao.getDAO().update(customer);
							Dialogs.showInformationDialog(
									(Stage) CustomerUpdateControlGUI.this.view
											.getRoot().getScene().getWindow(),
									// TODO gvreg
									AppContext.getMessage("UpdateSuccess"),
									AppContext.getMessage("TransactionSuccess"),
									AppContext.getMessage("TravelbasysManager"));
							deactivateSend();
						} catch (NumberFormatException d) {
							Dialogs.showErrorDialog(
									(Stage) CustomerUpdateControlGUI.this.view
											.getRoot().getScene().getWindow(),
									AppContext.getMessage("WrongSyntax"),
									AppContext.getMessage("Error"),
									AppContext.getMessage("TravelbasysManager"));
						} catch (IllegalArgumentException d) {
							Dialogs.showErrorDialog(
									(Stage) CustomerUpdateControlGUI.this.view
											.getRoot().getScene().getWindow(),
									AppContext.getMessage("WrongSyntax."),
									AppContext.getMessage("Error"),
									AppContext.getMessage("TravelbasysManager"));
						} catch (CustomerDaoException d) {
							Dialogs.showErrorDialog(
									(Stage) CustomerUpdateControlGUI.this.view
											.getRoot().getScene().getWindow(),
									AppContext.getMessage("CustomerExist"),
									AppContext.getMessage("Error"),
									AppContext.getMessage("TravelbasysManager"));
						}
					}

					private void deactivateSend() {
						CustomerUpdateControlGUI.this.view.getSendButton()
								.setDisable(true);
					}

				});

		CustomerUpdateControlGUI.this.view.getSearchButton().setOnAction(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {
						try {

							ObservableList<Customer> data = FXCollections.observableArrayList(Dao
									.getDAO()
									.findById(
											Integer.parseInt(CustomerUpdateControlGUI.this.view
													.getCustomerIDField()
													.getText())));
							CustomerUpdateControlGUI.this.model.setData(data);

							if (CustomerUpdateControlGUI.this.model.getData()
									.get(0) != null) {
								DialogOptions options = DialogOptions.YES_NO;
								DialogResponse response = Dialogs
										.showConfirmDialog(
												(Stage) CustomerUpdateControlGUI.this.view
														.getRoot().getScene()
														.getWindow(),
												AppContext
														.getMessage("Lastname")
														+ CustomerUpdateControlGUI.this.model
																.getData()
																.get(0)
																.getLastName()
														+ "\n"
														+ AppContext
																.getMessage("Firstname")
														+ CustomerUpdateControlGUI.this.model
																.getData()
																.get(0)
																.getFirstName()
														+ "\n"
														+ AppContext
																.getMessage("Age")
														+ CustomerUpdateControlGUI.this.model
																.getData()
																.get(0)
																.getAge()
														+ "\n"
														+ AppContext
																.getMessage("Adress")
														+ CustomerUpdateControlGUI.this.model
																.getData()
																.get(0)
																.getAdress()
														+ "\n"
														+ AppContext
																.getMessage("Postalcode")
														+ CustomerUpdateControlGUI.this.model
																.getData()
																.get(0)
																.getPostalcode()
														+ "\n"
														+ AppContext
																.getMessage("Email")
														+ CustomerUpdateControlGUI.this.model
																.getData()
																.get(0)
																.getEmail()
														+ "\n\n"
														+ AppContext
																.getMessage("UpdateQuestion"),
												AppContext
														.getMessage("CustomerWithID")
														+ CustomerUpdateControlGUI.this.view
																.getCustomerIDField()
																.getText()
														+ " "
														+ AppContext
																.getMessage("Found"),
												AppContext
														.getMessage("TravelbasysManager"),
												options);
								switch (response) {
								case YES:
									activateEdit();
									deactivateSearch();
									activateNewSearch();
								case NO:
									break;
								default:
									break;
								}
							} else {
								Dialogs.showErrorDialog(
										(Stage) CustomerUpdateControlGUI.this.view
												.getRoot().getScene()
												.getWindow(),
										AppContext.getMessage("CustomerWithID")
												+ CustomerUpdateControlGUI.this.view
														.getCustomerIDField()
														.getText()
												+ " "
												+ AppContext
														.getMessage("NotFound"),
										AppContext.getMessage("Error"),
										AppContext
												.getMessage("TravelbasysManager"));
							}
						} catch (NumberFormatException d) {
							Dialogs.showErrorDialog(
									(Stage) CustomerUpdateControlGUI.this.view
											.getRoot().getScene().getWindow(),
									AppContext.getMessage("SyntaxError")
											+ CustomerUpdateControlGUI.this.view
													.getCustomerIDField()
													.getText()
											+ "\n"
											+ AppContext
													.getMessage("CustomerIDError"),
									AppContext.getMessage("Error"), AppContext
											.getMessage("TravelbasysManager"));
						}

					}

					private void activateNewSearch() {
						CustomerUpdateControlGUI.this.view.getNewSearchButton()
								.setDisable(false);
					}

					private void deactivateSearch() {
						CustomerUpdateControlGUI.this.view.getCustomerIDField()
								.setEditable(false);
						CustomerUpdateControlGUI.this.view.getSearchButton()
								.setDisable(true);
					}

					private void activateEdit() {

						CustomerUpdateControlGUI.this.view.getLastNameField()
								.setEditable(true);
						CustomerUpdateControlGUI.this.view
								.getLastNameField()
								.setText(
										CustomerUpdateControlGUI.this.model
												.getData().get(0).getLastName());

						CustomerUpdateControlGUI.this.view.getFirstNameField()
								.setEditable(true);
						CustomerUpdateControlGUI.this.view.getFirstNameField()
								.setText(
										CustomerUpdateControlGUI.this.model
												.getData().get(0)
												.getFirstName());

						CustomerUpdateControlGUI.this.view.getAgeField()
								.setEditable(true);
						CustomerUpdateControlGUI.this.view
								.getAgeField()
								.setText(
										String.valueOf(CustomerUpdateControlGUI.this.model
												.getData().get(0).getAge()));

						CustomerUpdateControlGUI.this.view.getAdressField()
								.setEditable(true);
						CustomerUpdateControlGUI.this.view.getAdressField()
								.setText(
										CustomerUpdateControlGUI.this.model
												.getData().get(0).getAdress());

						CustomerUpdateControlGUI.this.view.getPostalcodeField()
								.setEditable(true);
						CustomerUpdateControlGUI.this.view.getPostalcodeField()
								.setText(
										CustomerUpdateControlGUI.this.model
												.getData().get(0)
												.getPostalcode());

						CustomerUpdateControlGUI.this.view.getEmailField()
								.setEditable(true);
						CustomerUpdateControlGUI.this.view.getEmailField()
								.setText(
										CustomerUpdateControlGUI.this.model
												.getData().get(0).getEmail());

						CustomerUpdateControlGUI.this.view.getSendButton()
								.setDisable(false);
					}

				});

		CustomerUpdateControlGUI.this.view.getNewSearchButton().setOnAction(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						clear();
						deactivateEdit();
						deactivateNewSearch();
						activateSearch();

					}

					private void deactivateNewSearch() {
						CustomerUpdateControlGUI.this.view.getNewSearchButton()
								.setDisable(true);
					}

					private void deactivateEdit() {
						CustomerUpdateControlGUI.this.view.getLastNameField()
								.setEditable(false);
						CustomerUpdateControlGUI.this.view.getFirstNameField()
								.setEditable(false);
						CustomerUpdateControlGUI.this.view.getAgeField()
								.setEditable(false);
						CustomerUpdateControlGUI.this.view.getAdressField()
								.setEditable(false);
						CustomerUpdateControlGUI.this.view.getPostalcodeField()
								.setEditable(false);
						CustomerUpdateControlGUI.this.view.getEmailField()
								.setEditable(false);
						CustomerUpdateControlGUI.this.view.getSendButton()
								.setDisable(true);
					}

					private void activateSearch() {
						CustomerUpdateControlGUI.this.view.getCustomerIDField()
								.setEditable(true);
						CustomerUpdateControlGUI.this.view.getCustomerIDField()
								.clear();
						CustomerUpdateControlGUI.this.view.getSearchButton()
								.setDisable(false);
					}

					private void clear() {
						CustomerUpdateControlGUI.this.view.getLastNameField()
								.clear();
						CustomerUpdateControlGUI.this.view.getFirstNameField()
								.clear();
						CustomerUpdateControlGUI.this.view.getAgeField()
								.clear();
						CustomerUpdateControlGUI.this.view.getAdressField()
								.clear();
						CustomerUpdateControlGUI.this.view.getPostalcodeField()
								.clear();
						CustomerUpdateControlGUI.this.view.getEmailField()
								.clear();
					}

				});

	}

	@Override
	public void handleInput(Object value) throws Exception {
	}
}
