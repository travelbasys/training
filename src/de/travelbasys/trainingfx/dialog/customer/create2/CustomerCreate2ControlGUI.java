package de.travelbasys.trainingfx.dialog.customer.create2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Dialogs;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.CustomerDaoException;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Configuration;
import de.travelbasys.training.util.ConfigurationEvent;
import de.travelbasys.training.util.ConfigurationListener;
import de.travelbasys.training.util.widgets.DatePicker;
import de.travelbasys.training.util.widgets.FXCalendar;

public class CustomerCreate2ControlGUI implements Initializable,
		ConfigurationListener {

	private CustomerCreate2ModelGUI model;
	private ResourceBundle resources;

	@FXML
	private BorderPane root;
	@FXML
	private static Label headerLabel;
	@FXML
	private static Label lastnameLabel;
	@FXML
	private static Label firstnameLabel;
	@FXML
	private static Label birthdateLabel;
	@FXML
	private static Label ageLabel;
	@FXML
	private static Label adressLabel;
	@FXML
	private static Label postalcodeLabel;
	@FXML
	private static Label emailLabel;
	@FXML
	private static Label validAgeLabel;
	@FXML
	private static Label validPostalcodeLabel;
	@FXML
	private static TextField lastnameField;
	@FXML
	private static TextField firstnameField;
	// @FXML
	// private static TextField birthdateField;
	@FXML
	private static TextField ageField;
	@FXML
	private static TextField adressField;
	@FXML
	private static TextField postalcodeField;
	@FXML
	private static TextField emailField;
	@FXML
	private static Button sendButton;
	@FXML
	private static GridPane centerGridPane;
	private static FXCalendar calendar;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		model = new CustomerCreate2ModelGUI();
		this.resources = resources;
		Configuration.addConfigurationListener(this);
		sendButton.setDisable(true);

		calendar = new FXCalendar();
		centerGridPane.add(calendar, 1, 2);

		lastnameField.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {
				CustomerCreate2ControlGUI.this.model.setLastname(lastnameField
						.getText().trim());

				updateSendButton();
			}
		});

		firstnameField.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {
				CustomerCreate2ControlGUI.this.model
						.setFirstname(firstnameField.getText().trim());

				updateSendButton();
			}
		});

		ageField.textProperty().addListener(new ChangeListener<String>() {

			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {
				TextField field = ageField;
				Label hint = validAgeLabel;
				try {
					int age = Integer.parseInt(field.getText().trim());
					if (age > 0 && age <= 150) {
						CustomerCreate2ControlGUI.this.model.setAge(age);
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
					CustomerCreate2ControlGUI.this.model.setAge(0);
				}

				updateSendButton();
			}
		});

		adressField.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {
				CustomerCreate2ControlGUI.this.model.setAdress(adressField
						.getText().trim());

				updateSendButton();
			}
		});

		postalcodeField.textProperty().addListener(
				new ChangeListener<String>() {

					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						TextField field = postalcodeField;
						Label hint = validPostalcodeLabel;
						try {
							if (Integer.parseInt(field.getText().trim()) > 0
									&& field.getText().trim().length() == 5) {
								CustomerCreate2ControlGUI.this.model
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
							CustomerCreate2ControlGUI.this.model
									.setPostalcode("");
						}

						updateSendButton();
					}
				});

		emailField.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {
				CustomerCreate2ControlGUI.this.model.setEmail(emailField
						.getText().trim());

				updateSendButton();
			}
		});
	}

	@FXML
	private void handleSendButton(ActionEvent e) {
		try {
			int dummyid = 0;
			Customer customer = new Customer(

			dummyid,

			lastnameField.getText(),

			firstnameField.getText(),
			// TODO: Implementierung des Geburtstag.
			// Datum.getFormattedDate(birthdateField.getText()),
					calendar.getValue(),

					Integer.parseInt(ageField.getText()),

					adressField.getText(),

					postalcodeField.getText(),

					emailField.getText());

			Dao.getDAO().getExisting(customer);
			Dao.getDAO().create(customer);
			clear();
			Dialogs.showInformationDialog((Stage) root.getScene().getWindow(),
					AppContext.getMessage("CustomerCreated"),
					AppContext.getMessage("TransactionSuccess"),
					AppContext.getMessage("TravelbasysManager"));

		} catch (CustomerDaoException d) {
			Dialogs.showErrorDialog(
					(Stage) root.getScene().getWindow(),
					AppContext.getMessage("CustomerNotCreated"),
					AppContext.getMessage("Error")
							+ AppContext.getMessage("TransactionFail"),
					AppContext.getMessage("TravelbasysManager"));
		} catch (NumberFormatException d) {
			Dialogs.showErrorDialog((Stage) root.getScene().getWindow(),
					AppContext.getMessage("WrongSyntax."),
					AppContext.getMessage("Error"),
					AppContext.getMessage("TravelbasysManager"));

		} catch (IllegalArgumentException d) {
			Dialogs.showErrorDialog((Stage) root.getScene().getWindow(),

			AppContext.getMessage("WrongInput"),
					AppContext.getMessage("Error"),
					AppContext.getMessage("TravelbasysManager"));
		}

	}

	private void clear() {
		lastnameField.clear();
		firstnameField.clear();
		ageField.clear();
		adressField.clear();
		postalcodeField.clear();
		emailField.clear();
	}

	public void updateSendButton() {
		sendButton.setDisable(model.sendIsInvalid());

	}

	@Override
	public void handleConfigurationEvent(ConfigurationEvent e) {

		resources = e.getResources();

		headerLabel.setText(resources.getString("CustomerEdit"));

		lastnameLabel.setText(resources.getString("Lastname"));
		firstnameLabel.setText(resources.getString("Firstname"));
		ageLabel.setText(resources.getString("Age"));
		adressLabel.setText(resources.getString("Adress"));
		postalcodeLabel.setText(resources.getString("Postalcode"));
		emailLabel.setText(resources.getString("Email"));
		validAgeLabel.setText(resources.getString("ValidAge"));
		validPostalcodeLabel.setText(resources.getString("ValidPostalcode"));

		lastnameField.setPromptText(resources.getString("Lastnamefield"));
		firstnameField.setPromptText(resources.getString("Firstnamefield"));
		ageField.setPromptText(resources.getString("Agefield"));
		adressField.setPromptText(resources.getString("Adressfield"));
		postalcodeField.setPromptText(resources.getString("Postalcodefield"));
		emailField.setPromptText(resources.getString("Emailfield"));

		sendButton.setText(resources.getString("SendButton"));

	}
}