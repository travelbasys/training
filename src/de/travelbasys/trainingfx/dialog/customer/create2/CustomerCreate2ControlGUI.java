package de.travelbasys.trainingfx.dialog.customer.create2;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Dialogs;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.CustomerDaoException;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.util.AgeCalc;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Configuration;
import de.travelbasys.training.util.ConfigurationEvent;
import de.travelbasys.training.util.ConfigurationListener;
import de.travelbasys.training.util.Datum;
import de.travelbasys.training.util.widgets.DateChooser;

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
	private static Label validBirthdateLabel;
	@FXML
	private static Label validAgeLabel;
	@FXML
	private static Label validPostalcodeLabel;
	@FXML
	private static TextField lastnameField;
	@FXML
	private static TextField firstnameField;
	@FXML
	private static TextField birthdateField;
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
	private static Button calendarButton;
	private static DateChooser dateChooser;

	/**
	 * Diese Methode Initialisiert den Controller der Create Klasse, indem Sie
	 * listener für die Atribute eines Customer Objekts anlegt
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		model = new CustomerCreate2ModelGUI();
		this.resources = resources;
		Configuration.addConfigurationListener(this);
		sendButton.setDisable(true);

		lastnameField.textProperty().addListener(new ChangeListener<String>() {
			/**
			 * Dies ist der listener für das Feld des Nachnamens der prüft ob
			 * dieser sich ändert und setzt diesen im Model.
			 * 
			 */
			@Override
			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {
				CustomerCreate2ControlGUI.this.model.setLastname(lastnameField
						.getText().trim());

				updateSendButton();
			}
		});

		firstnameField.textProperty().addListener(new ChangeListener<String>() {
			/**
			 * Dies ist der listener für das Feld des Vornamens der prüft ob
			 * dieser sich ändert und setzt diesen im Model.
			 * 
			 */
			@Override
			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {
				CustomerCreate2ControlGUI.this.model
						.setFirstname(firstnameField.getText().trim());

				updateSendButton();
			}
		});

		birthdateField.textProperty().addListener(new ChangeListener<String>() {
			/**
			 * Dies ist der listener für das Feld des Geburtsdatums der die
			 * Eingabe eines Gültigen Datums Prüft und je nach eingegebenem
			 * Geburtsdatum das Alter dieses Geburtsdatums in das dafür
			 * vorhergesehene Feld einträgt
			 * 
			 */
			@Override
			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {

				Date arg1;
				String arg2;
				String arg3;

				CustomerCreate2ControlGUI.this.model
						.setBirthdate(birthdateField.getText());

				try {
					arg1 = Datum.getFormattedDate(newValue);
					arg2 = newValue;
					arg3 = Datum.getFormattedString(arg1);

					if (arg2.equals(arg3)) {
						ageField.setText(String.valueOf(AgeCalc.getAge(arg1)));
					} else {
						ageField.setText("");
					}

				} catch (Exception e) {
					ageField.setText("");
				}

				updateSendButton();
			}
		});

		ageField.textProperty().addListener(new ChangeListener<String>() {
			/**
			 * Dies ist der listener für das Feld des Alters der prüft ob es
			 * sich um einen gültigen wert handelt und setzt diesen im Model,
			 * falls dieser Wert ungültig ist wird ein Hinweis neben dem
			 * Text-feld eingeblendet.
			 * 
			 */
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
			/**
			 * Dies ist der listener für das Feld der Adresse der prüft ob
			 * dieser sich ändert und setzt diesen im Model.
			 * 
			 */
			@Override
			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {
				CustomerCreate2ControlGUI.this.model.setAdress(adressField
						.getText().trim());

				updateSendButton();
			}
		});
		/**
		 * Dies ist der listener für das Feld der Postleitzahl der prüft ob es
		 * sich um einen gültigen wert handelt und setzt diesen im Model, falls
		 * dieser Wert ungültig ist wird ein Hinweis neben dem Text-feld
		 * eingeblendet.
		 * 
		 */
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
			/**
			 * Dies ist der listener für das Feld der E-Mail-Adresse der prüft
			 * ob dieser sich ändert und setzt diesen im Model.
			 * 
			 */
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
	private void handleCalendarButton(ActionEvent e) {
		Popup popup = new Popup();
		popup.setAutoHide(true);
		popup.setAutoFix(true);
		popup.setHideOnEscape(true);
		dateChooser = new DateChooser();
		popup.getContent().add(dateChooser);
		popup.setX(300);
		popup.setY(250);
		popup.setOnHiding(new EventHandler<WindowEvent>() {

			public void handle(WindowEvent event) {
				SimpleDateFormat sdf;
				if (Locale.getDefault().getLanguage() == ("de")) {
					sdf = new SimpleDateFormat("dd.MM.yyyy");
				} else {
					sdf = new SimpleDateFormat("yyyy-MM-dd");
				}
				birthdateField.setText(sdf.format(dateChooser.getDate()));
			}
		});
		popup.show(root.getScene().getWindow());
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
					Datum.getFormattedDate(birthdateField.getText()),

					adressField.getText(),

					postalcodeField.getText(),

					emailField.getText());

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
		birthdateField.clear();
		ageField.clear();
		adressField.clear();
		postalcodeField.clear();
		emailField.clear();
	}

	/**
	 * Diese Methode ist für das Deaktivieren des Senden Buttons verantwortlich.
	 */
	public void updateSendButton() {
		sendButton.setDisable(model.sendIsInvalid());

	}

	/**
	 * Diese Methode ist für das setzen der Internationalen Ausgabe Texte
	 * zuständig wenn der Benutzer die Sprache ändert.
	 */
	@Override
	public void handleConfigurationEvent(ConfigurationEvent e) {

		resources = e.getResources();

		headerLabel.setText(resources.getString("CustomerEdit"));

		lastnameLabel.setText(resources.getString("Lastname"));
		firstnameLabel.setText(resources.getString("Firstname"));
		birthdateLabel.setText(resources.getString("Birthdate"));
		ageLabel.setText(resources.getString("Age"));
		adressLabel.setText(resources.getString("Adress"));
		postalcodeLabel.setText(resources.getString("Postalcode"));
		emailLabel.setText(resources.getString("Email"));
		validBirthdateLabel.setText(resources.getString("ValidBirthdate"));
		validAgeLabel.setText(resources.getString("ValidAge"));
		validPostalcodeLabel.setText(resources.getString("ValidPostalcode"));
		birthdateField.setText("");
		ageField.setText("");

		lastnameField.setPromptText(resources.getString("Lastnamefield"));
		firstnameField.setPromptText(resources.getString("Firstnamefield"));
		ageField.setPromptText(resources.getString("Agefield"));
		adressField.setPromptText(resources.getString("Adressfield"));
		postalcodeField.setPromptText(resources.getString("Postalcodefield"));
		emailField.setPromptText(resources.getString("Emailfield"));
		birthdateField.setPromptText(resources.getString("Birthdatefield"));

		sendButton.setText(resources.getString("SendButton"));
		calendarButton.setText(resources.getString("CalendarButton"));

	}
}