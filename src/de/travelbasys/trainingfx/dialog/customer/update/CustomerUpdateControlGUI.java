package de.travelbasys.trainingfx.dialog.customer.update;

import java.util.Date;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Dialogs;
import javafx.scene.control.Dialogs.DialogOptions;
import javafx.scene.control.Dialogs.DialogResponse;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.CustomerDaoException;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.framework.Control;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;

/**
 * Diese Klasse füht anhand der eingegebenen Daten des Benutzers ensprechende
 * Funktionen aus.
 * 
 * @author haut
 * 
 */
public class CustomerUpdateControlGUI implements Control {

	private CustomerUpdateModelGUI model;
	private CustomerUpdateViewGUI view;

	public CustomerUpdateControlGUI() {
	}

	@Override
	public void init(Model model, View view) {

		this.view = (CustomerUpdateViewGUI) view;
		this.model = (CustomerUpdateModelGUI) model;

		this.view.getCustomerIDField().textProperty()
				.addListener(new ChangeListener<String>() {

					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						TextField field = CustomerUpdateControlGUI.this.view
								.getCustomerIDField();
						try {
							int id = Integer.parseInt(field.getText().trim());
							CustomerUpdateControlGUI.this.model
									.setCustomerid(id);
						} catch (NumberFormatException e) {
							CustomerUpdateControlGUI.this.model
									.setCustomerid(0);
						}
						CustomerUpdateControlGUI.this.view.updateSearchButton();
					}
				});

		this.view.getLastNameField().textProperty()
				.addListener(new ChangeListener<String>() {

					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						CustomerUpdateControlGUI.this.model
								.setLastname(CustomerUpdateControlGUI.this.view
										.getLastNameField().getText().trim());

						CustomerUpdateControlGUI.this.view.updateSendButton();
					}
				});

		this.view.getFirstNameField().textProperty()
				.addListener(new ChangeListener<String>() {

					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						CustomerUpdateControlGUI.this.model
								.setFirstname(CustomerUpdateControlGUI.this.view
										.getFirstNameField().getText().trim());

						CustomerUpdateControlGUI.this.view.updateSendButton();
					}
				});

		this.view.getAgeField().textProperty()
				.addListener(new ChangeListener<String>() {

					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						TextField field = CustomerUpdateControlGUI.this.view
								.getAgeField();
						Label hint = CustomerUpdateControlGUI.this.view
								.getAgeHintLabel();
						try {
							int age = Integer.parseInt(field.getText().trim());
							if (age > 0 && age <= 150) {
								CustomerUpdateControlGUI.this.model.setAge(age);
								hint.setGraphic(new ImageView(new Image(
										"./resources./haken.png")));
								if (hint.getTextFill() != (Color.web("#00AA00"))) {
									hint.setTextFill(Color.web("#00AA00"));
								}
							} else {
								throw new NumberFormatException();
							}
						} catch (NumberFormatException e) {
							hint.setGraphic(new ImageView(new Image(
									"./resources./kreuz.png")));
							if (hint.getTextFill() != (Color.web("#FF0000"))) {
								hint.setTextFill(Color.web("#FF0000"));
							}
							CustomerUpdateControlGUI.this.model.setAge(0);
						}

						CustomerUpdateControlGUI.this.view.updateSendButton();
					}
				});

		this.view.getAdressField().textProperty()
				.addListener(new ChangeListener<String>() {

					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						CustomerUpdateControlGUI.this.model
								.setAdress(CustomerUpdateControlGUI.this.view
										.getAdressField().getText().trim());

						CustomerUpdateControlGUI.this.view.updateSendButton();
					}
				});

		this.view.getPostalcodeField().textProperty()
				.addListener(new ChangeListener<String>() {

					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						TextField field = CustomerUpdateControlGUI.this.view
								.getPostalcodeField();
						Label hint = CustomerUpdateControlGUI.this.view
								.getPostalcodeHintLabel();
						try {
							if (Integer.parseInt(field.getText().trim()) > 0
									&& field.getText().trim().length() == 5) {
								CustomerUpdateControlGUI.this.model
										.setPostalcode(field.getText());
								hint.setGraphic(new ImageView(new Image(
										"./resources./haken.png")));
								if (hint.getTextFill() != (Color.web("#00AA00"))) {
									hint.setTextFill(Color.web("#00AA00"));
								}
							} else
								throw new NumberFormatException();
						} catch (NumberFormatException e) {
							hint.setGraphic(new ImageView(new Image(
									"./resources./kreuz.png")));
							if (hint.getTextFill() != (Color.web("FF0000"))) {
								hint.setTextFill(Color.web("#FF0000"));
							}
							CustomerUpdateControlGUI.this.model
									.setPostalcode("");
						}

						CustomerUpdateControlGUI.this.view.updateSendButton();
					}
				});

		this.view.getEmailField().textProperty()
				.addListener(new ChangeListener<String>() {

					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						CustomerUpdateControlGUI.this.model
								.setEmail(CustomerUpdateControlGUI.this.view
										.getEmailField().getText().trim());

						CustomerUpdateControlGUI.this.view.updateSendButton();
					}
				});

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
									// TODO: Implementierung des Geburtstag.
									new Date(),
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
									AppContext.getMessage("UpdateSuccess"),
									AppContext.getMessage("TransactionSuccess"),
									AppContext.getMessage("TravelbasysManager"));
							deactivateSend();
							deactivateEdit();
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
				});

		CustomerUpdateControlGUI.this.view.getNewSearchButton().setOnAction(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						clear();
						deactivateEdit();
						deactivateNewSearch();
						activateSearch();
						CustomerUpdateControlGUI.this.view.getCustomerIDField()
								.requestFocus();
					}

				});

	}

	@Override
	public void handleInput(Object value) throws Exception {
	}

	private void deactivateNewSearch() {
		CustomerUpdateControlGUI.this.view.getNewSearchButton()
				.setDisable(true);
	}

	private void deactivateEdit() {
		CustomerUpdateControlGUI.this.view.getLastNameField()
				.setEditable(false);
		CustomerUpdateControlGUI.this.view.getFirstNameField().setEditable(
				false);
		CustomerUpdateControlGUI.this.view.getAgeField().setEditable(false);
		CustomerUpdateControlGUI.this.view.getAdressField().setEditable(false);
		CustomerUpdateControlGUI.this.view.getPostalcodeField().setEditable(
				false);
		CustomerUpdateControlGUI.this.view.getEmailField().setEditable(false);
		CustomerUpdateControlGUI.this.view.getSendButton().setDisable(true);
	}

	private void activateSearch() {
		CustomerUpdateControlGUI.this.view.getCustomerIDField().setEditable(
				true);
		CustomerUpdateControlGUI.this.view.getCustomerIDField().clear();
	}

	private void activateNewSearch() {
		CustomerUpdateControlGUI.this.view.getNewSearchButton().setDisable(
				false);
	}

	private void deactivateSearch() {
		CustomerUpdateControlGUI.this.view.getCustomerIDField().setEditable(
				false);
		CustomerUpdateControlGUI.this.view.getSearchButton().setDisable(true);
	}

	private void clear() {
		CustomerUpdateControlGUI.this.view.getLastNameField().clear();
		CustomerUpdateControlGUI.this.view.getFirstNameField().clear();
		CustomerUpdateControlGUI.this.view.getAgeField().clear();
		CustomerUpdateControlGUI.this.view.getAdressField().clear();
		CustomerUpdateControlGUI.this.view.getPostalcodeField().clear();
		CustomerUpdateControlGUI.this.view.getEmailField().clear();
	}

	private void activateEdit() {

		CustomerUpdateControlGUI.this.view.getLastNameField().setEditable(true);
		CustomerUpdateControlGUI.this.view.getLastNameField().setText(
				CustomerUpdateControlGUI.this.model.getData().get(0)
						.getLastName());

		CustomerUpdateControlGUI.this.view.getFirstNameField()
				.setEditable(true);
		CustomerUpdateControlGUI.this.view.getFirstNameField().setText(
				CustomerUpdateControlGUI.this.model.getData().get(0)
						.getFirstName());

		CustomerUpdateControlGUI.this.view.getAdressField().setEditable(true);
		CustomerUpdateControlGUI.this.view.getAdressField().setText(
				CustomerUpdateControlGUI.this.model.getData().get(0)
						.getAdress());

		CustomerUpdateControlGUI.this.view.getPostalcodeField().setEditable(
				true);
		CustomerUpdateControlGUI.this.view.getPostalcodeField().setText(
				CustomerUpdateControlGUI.this.model.getData().get(0)
						.getPostalcode());

		CustomerUpdateControlGUI.this.view.getEmailField().setEditable(true);
		CustomerUpdateControlGUI.this.view.getEmailField()
				.setText(
						CustomerUpdateControlGUI.this.model.getData().get(0)
								.getEmail());
	}

	private void deactivateSend() {
		CustomerUpdateControlGUI.this.view.getSendButton().setDisable(true);
	}

}
