package de.travelbasys.trainingfx.dialog.customer.delete;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Dialogs;
import javafx.scene.control.Dialogs.DialogOptions;
import javafx.scene.control.Dialogs.DialogResponse;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.framework.Control;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;

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

		this.view.getCustomerIDField().textProperty()
				.addListener(new ChangeListener<String>() {

					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						TextField field = CustomerDeleteControlGUI.this.view
								.getCustomerIDField();
						try {
							int id = Integer.parseInt(field.getText().trim());
							CustomerDeleteControlGUI.this.model
									.setCustomerid(id);
						} catch (NumberFormatException e) {
							CustomerDeleteControlGUI.this.model
									.setCustomerid(0);
						}
						CustomerDeleteControlGUI.this.view.update();
					}
				});

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

							CustomerDeleteControlGUI.this.model.setData(data);

							// Erzeuge Dialog-Options-Objekt

							DialogOptions options = DialogOptions.YES_NO;
							if (CustomerDeleteControlGUI.this.model.getData()
									.get(0) != null) {

								// Übergebe Rückgabewert des
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
												AppContext
														.getMessage("Lastname")
														+ data.get(0)
																.getLastName()
														+ "\n"
														+ AppContext
																.getMessage("Firstname")
														+ data.get(0)
																.getFirstName()
														+ "\n"
														+ AppContext
																.getMessage("Adress")
														+ data.get(0)
																.getAdress()
														+ "\n"
														+ AppContext
																.getMessage("Postalcode")
														+ data.get(0)
																.getPostalcode()
														+ "\n"
														+ AppContext
																.getMessage("Email")
														+ data.get(0)
																.getEmail()
														+ "\n\n"
														+ AppContext
																.getMessage("DeleteQuestion"),
												AppContext
														.getMessage("CustomerWithID")
														+ CustomerDeleteControlGUI.this.view
																.getCustomerIDField()
																.getText()
														+ "\n"
														+ AppContext
																.getMessage("Found"),
												AppContext
														.getMessage("TravelbasysManager"),
												options);

								// Anhand des Responses vom Dialog wird
								// eine Aktion ausgeführt
								// TODO internationalisierung
								switch (response) {
								case YES:
									try {
										Dao.getDAO().delete(data.get(0));
										Dialogs.showInformationDialog(
												(Stage) CustomerDeleteControlGUI.this.view
														.getRoot().getScene()
														.getWindow(),
												AppContext
														.getMessage("DeleteSuccess"),
												AppContext
														.getMessage("ProcessSuccess"),
												AppContext
														.getMessage("TravelbasysManager"));
									} catch (Exception f) {
										Dialogs.showErrorDialog(
												(Stage) CustomerDeleteControlGUI.this.view
														.getRoot().getScene()
														.getWindow(),
												AppContext
														.getMessage("UnknownError"),
												AppContext.getMessage("Error"),
												AppContext
														.getMessage("TravelbasysManager"));
									}
									break;
								case NO:
									Dialogs.showInformationDialog(
											(Stage) CustomerDeleteControlGUI.this.view
													.getRoot().getScene()
													.getWindow(),
											AppContext
													.getMessage("CustomerNotDeleted"),
											AppContext
													.getMessage("DeleteAbort"),
											AppContext
													.getMessage("TravelbasysManager"));
									break;
								default:
									break;
								}
							} else {
								Dialogs.showErrorDialog(
										(Stage) CustomerDeleteControlGUI.this.view
												.getRoot().getScene()
												.getWindow(),
										AppContext.getMessage("CustomerWithID")
												+ CustomerDeleteControlGUI.this.view
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
									(Stage) CustomerDeleteControlGUI.this.view
											.getRoot().getScene().getWindow(),
									AppContext.getMessage("SyntaxError")
											+ CustomerDeleteControlGUI.this.view
													.getCustomerIDField()
													.getText()
											+ "\n"
											+ AppContext
													.getMessage("CustomerIDError"),
									AppContext.getMessage("Error"), AppContext
											.getMessage("TravelbasysManager"));
						}
					}
				});
	}

	@Override
	public void handleInput(Object value) throws Exception {
	}
}