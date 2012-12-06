package experiment.javafx.travelbasys.dialog.customer.create;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Dialogs;
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

public class CustomerCreateControlGUI implements Control {

	private CustomerCreateModelGUI model;
	private CustomerCreateViewGUI view;

	public CustomerCreateControlGUI() {
	}

	@Override
	public void init(Model model, View view) {
		this.model = (CustomerCreateModelGUI) model;
		this.view = (CustomerCreateViewGUI) view;

		this.view.getLastNameField().textProperty()
				.addListener(new ChangeListener<String>() {

					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						CustomerCreateControlGUI.this.model
								.setLastname(CustomerCreateControlGUI.this.view
										.getLastNameField().getText().trim());
						CustomerCreateControlGUI.this.view.update();
					}
				});

		this.view.getFirstNameField().textProperty()
				.addListener(new ChangeListener<String>() {

					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						CustomerCreateControlGUI.this.model
								.setFirstname(CustomerCreateControlGUI.this.view
										.getFirstNameField().getText().trim());
						CustomerCreateControlGUI.this.view.update();
					}
				});

		this.view.getAgeField().textProperty()
				.addListener(new ChangeListener<String>() {

					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						TextField field = CustomerCreateControlGUI.this.view
								.getAgeField();
						Label hint = CustomerCreateControlGUI.this.view
								.getAgeHintLabel();
						try {
							int age = Integer.parseInt(field.getText().trim());
							if (age > 0 && age <= 150) {
								CustomerCreateControlGUI.this.model.setAge(age);
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
							CustomerCreateControlGUI.this.model.setAge(0);
						}

						CustomerCreateControlGUI.this.view.update();
					}
				});

		this.view.getAdressField().textProperty()
				.addListener(new ChangeListener<String>() {

					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						CustomerCreateControlGUI.this.model
								.setAdress(CustomerCreateControlGUI.this.view
										.getAdressField().getText().trim());
						CustomerCreateControlGUI.this.view.update();
					}
				});

		this.view.getPostalcodeField().textProperty()
				.addListener(new ChangeListener<String>() {

					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						TextField field = CustomerCreateControlGUI.this.view
								.getPostalcodeField();
						Label hint = CustomerCreateControlGUI.this.view
								.getPostalcodeHintLabel();
						try {
							if (Integer.parseInt(field.getText().trim()) > 0
									&& field.getText().trim().length() == 5) {
								CustomerCreateControlGUI.this.model
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
						}
						CustomerCreateControlGUI.this.view.update();
					}
				});

		this.view.getEmailField().textProperty()
				.addListener(new ChangeListener<String>() {

					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						CustomerCreateControlGUI.this.model
								.setEmail(CustomerCreateControlGUI.this.view
										.getEmailField().getText().trim());
						CustomerCreateControlGUI.this.view.update();
					}
				});

		this.view.getSendButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				int dummyId = 0;
				try {
					Customer customer = new Customer(
							dummyId,
							CustomerCreateControlGUI.this.model.getLastname(),
							CustomerCreateControlGUI.this.model.getFirstname(),
							CustomerCreateControlGUI.this.model.getAge(),
							CustomerCreateControlGUI.this.model.getAdress(),
							CustomerCreateControlGUI.this.model.getPostalcode(),
							CustomerCreateControlGUI.this.model.getEmail());

					Dao.getDAO().create(customer);

					Dialogs.showInformationDialog(
							(Stage) CustomerCreateControlGUI.this.view
									.getRoot().getScene().getWindow(),
							AppContext.getMessage("CustomerCreated"),
							AppContext.getMessage("TransactionSuccess"),
							AppContext.getMessage("TravelbasysManager"));
				} catch (CustomerDaoException d) {
					Dialogs.showErrorDialog(
							(Stage) CustomerCreateControlGUI.this.view
									.getRoot().getScene().getWindow(),
							AppContext.getMessage("CustomerNotCreated"),
							AppContext.getMessage("Error")
									+ AppContext.getMessage("TransactionFail"),
							AppContext.getMessage("TravelbasysManager"));
				} catch (NumberFormatException d) {
					Dialogs.showErrorDialog(
							(Stage) CustomerCreateControlGUI.this.view
									.getRoot().getScene().getWindow(),
							AppContext.getMessage("WrongSyntax."),
							AppContext.getMessage("Error"),
							AppContext.getMessage("TravelbasysManager"));

				} catch (IllegalArgumentException d) {
					Dialogs.showErrorDialog(
							(Stage) CustomerCreateControlGUI.this.view
									.getRoot().getScene().getWindow(),
							AppContext.getMessage("WrongInput"),
							AppContext.getMessage("Error"),
							AppContext.getMessage("TravelbasysManager"));
				}
			}

		});

	}

	@Override
	public void handleInput(Object value) throws Exception {
	}
}
