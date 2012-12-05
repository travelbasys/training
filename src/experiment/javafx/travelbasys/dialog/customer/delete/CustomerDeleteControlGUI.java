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
	private CustomerDeleteViewGUI view;
	private ObservableList<Customer> data;

	public CustomerDeleteControlGUI() {
	}

	@Override
	public void init(Model model, View view) {

		this.model = (CustomerDeleteModelGUI) model;
		this.view = (CustomerDeleteViewGUI) view;
		CustomerDeleteControlGUI.this.view.getSearchButton().setOnAction(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {

						try {

							data = FXCollections.observableArrayList(Dao
									.getDAO()
									.findById(
											Integer.parseInt(CustomerDeleteControlGUI.this.view
													.getCustomerIDField()
													.getText())));

							// Erzeuge Dialog-Options-Objekt

							DialogOptions options = DialogOptions.YES_NO;
							if (data.get(0) != null) {

								// �bergebe R�ckgabewert des
								// ConfirmDialoges an
								// Dialog-Response-Objekt
								// Optionen werden ans zu zeigende
								// Dialog-Objekt weitergegeben (letztes
								// Feld)

								DialogResponse response = Dialogs
										.showConfirmDialog(
												(Stage) CustomerDeleteControlGUI.this.view
														.getRoot().getScene()
														.getWindow(),
												"Lastname: "
														+ data.get(0)
																.getLastName()
														+ "\nFirstname: "
														+ data.get(0)
																.getFirstName()
														+ "\nAge: "
														+ data.get(0).getAge()
														+ "\nAdress: "
														+ data.get(0)
																.getAdress()
														+ "\nPostalcode: "
														+ data.get(0)
																.getPostalcode()
														+ "\neMail: "
														+ data.get(0)
																.getEmail()
														+ "\nDelete?",
												"Customer found: "
														+ CustomerDeleteControlGUI.this.view
																.getCustomerIDField()
																.getText(),
												"Travelbasys Customer Manager",
												options);

								// Anhand des Responses vom Dialog wird
								// eine Aktion ausgef�hrt

								switch (response) {
								case YES:
									try {
										Dao.getDAO().delete(data.get(0));
										Dialogs.showInformationDialog(
												(Stage) CustomerDeleteControlGUI.this.view
														.getRoot().getScene()
														.getWindow(),
												"",
												"Process successfully completed",
												"Travelbasys Customer Manager");
									} catch (Exception f) {
										Dialogs.showErrorDialog(
												(Stage) CustomerDeleteControlGUI.this.view
														.getRoot().getScene()
														.getWindow(),
												"Unknown Error", "Error",
												"Travelbasys Customer Manager");
									}
									break;
								case NO:
									Dialogs.showInformationDialog(
											(Stage) CustomerDeleteControlGUI.this.view
													.getRoot().getScene()
													.getWindow(), "",
											"Process terminated.",
											"Travelbasys Customer Manager");
									break;
								default:
									break;
								}
							} else {
								Dialogs.showErrorDialog(
										(Stage) CustomerDeleteControlGUI.this.view
												.getRoot().getScene()
												.getWindow(),
										"Customer not found: "
												+ CustomerDeleteControlGUI.this.view
														.getCustomerIDField()
														.getText(), "Error",
										"Travelbasys Customer Manager");
							}
						} catch (NumberFormatException d) {
							Dialogs.showErrorDialog(
									(Stage) CustomerDeleteControlGUI.this.view
											.getRoot().getScene().getWindow(),
									"Wrong syntax: "
											+ CustomerDeleteControlGUI.this.view
													.getCustomerIDField()
													.getText(), "Error",
									"Travelbasys Customer Manager");
						}
					}
				});
	}

	@Override
	public void handleInput(Object value) throws Exception {
	}
}