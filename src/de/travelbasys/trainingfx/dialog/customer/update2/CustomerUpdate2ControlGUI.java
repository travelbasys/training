package de.travelbasys.trainingfx.dialog.customer.update2;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Dialogs;
import javafx.scene.control.Dialogs.DialogOptions;
import javafx.scene.control.Dialogs.DialogResponse;
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
import de.travelbasys.training.util.Configuration;
import de.travelbasys.training.util.ConfigurationEvent;
import de.travelbasys.training.util.ConfigurationListener;
import de.travelbasys.training.util.Datum;
import de.travelbasys.training.util.widgets.DateChooser;

public class CustomerUpdate2ControlGUI implements Initializable,
		ConfigurationListener {

	private CustomerUpdate2ModelGUI model;
	private ResourceBundle resources;

	@FXML
	private BorderPane root;
	@FXML
	private static Label customerIDLabel;
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
	private static TextField customerIDField;
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
	@FXML
	private static Button searchButton;
	@FXML
	private static Button newSearchButton;
	private static DateChooser dateChooser;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model = new CustomerUpdate2ModelGUI();

		this.resources = resources;

		Configuration.addConfigurationListener(this);

		lastnameField.setEditable(false);
		firstnameField.setEditable(false);
		birthdateField.setEditable(false);
		adressField.setEditable(false);
		postalcodeField.setEditable(false);
		emailField.setEditable(false);

		calendarButton.setDisable(true);
		sendButton.setDisable(true);
		searchButton.setDisable(true);
		newSearchButton.setDisable(true);

		customerIDField.textProperty().addListener(
				new ChangeListener<String>() {

					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						TextField field = customerIDField;
						try {
							int id = Integer.parseInt(field.getText().trim());
							CustomerUpdate2ControlGUI.this.model
									.setCustomerid(id);
						} catch (NumberFormatException e) {
							CustomerUpdate2ControlGUI.this.model
									.setCustomerid(0);
						}
						updateSearchButton();
					}
				});

		lastnameField.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {
				CustomerUpdate2ControlGUI.this.model.setLastname(lastnameField
						.getText().trim());

				updateSendButton();
			}
		});

		firstnameField.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {
				CustomerUpdate2ControlGUI.this.model
						.setFirstname(firstnameField.getText().trim());

				updateSendButton();
			}
		});

		birthdateField.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {

				CustomerUpdate2ControlGUI.this.model
						.setBirthdate(birthdateField.getText().trim());

				try {
					ageField.setText(String.valueOf(((new Date().getTime() - Datum
							.getFormattedDate(birthdateField.getText())
							.getTime())
							/ 1000 / 60 / 60 / 24 / 365)));
				} catch (Exception e) {
					ageField.setText("");
				}

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
						CustomerUpdate2ControlGUI.this.model.setAge(age);
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
					CustomerUpdate2ControlGUI.this.model.setAge(0);
				}

				updateSendButton();
			}
		});

		adressField.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {
				CustomerUpdate2ControlGUI.this.model.setAdress(adressField
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
								CustomerUpdate2ControlGUI.this.model
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
							CustomerUpdate2ControlGUI.this.model
									.setPostalcode("");
						}

						updateSendButton();
					}
				});

		emailField.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {
				CustomerUpdate2ControlGUI.this.model.setEmail(emailField
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
				ageField.setText(String.valueOf((new Date().getTime() - dateChooser
						.getDate().getTime()) / 1000 / 60 / 60 / 24 / 365));
			}
		});
		popup.show(root.getScene().getWindow());
	}

	@FXML
	private void handleSendButton(ActionEvent e) {
		try {
			Customer customer = new Customer(

			Integer.parseInt(customerIDField.getText()),

			lastnameField.getText(),

			firstnameField.getText(),
			// TODO: Implementierung des Geburtstag.
					Datum.getFormattedDate(birthdateField.getText()),

					Integer.parseInt(ageField.getText()),

					adressField.getText(),

					postalcodeField.getText(),

					emailField.getText());
			Dao.getDAO().getExisting(customer);
			Dao.getDAO().update(customer);
			Dialogs.showInformationDialog((Stage) root.getScene().getWindow(),
					CustomerUpdate2ControlGUI.this.resources
							.getString("UpdateSuccess"),
					CustomerUpdate2ControlGUI.this.resources
							.getString("TransactionSuccess"),
					CustomerUpdate2ControlGUI.this.resources
							.getString("TravelbasysManager"));
			deactivateSend();
			deactivateEdit();
		} catch (NumberFormatException d) {
			Dialogs.showErrorDialog(
					(Stage) root.getScene().getWindow(),
					CustomerUpdate2ControlGUI.this.resources
							.getString("WrongSyntax"),
					CustomerUpdate2ControlGUI.this.resources.getString("Error"),
					CustomerUpdate2ControlGUI.this.resources
							.getString("TravelbasysManager"));
		} catch (IllegalArgumentException d) {
			Dialogs.showErrorDialog(
					(Stage) root.getScene().getWindow(),
					CustomerUpdate2ControlGUI.this.resources
							.getString("WrongSyntax."),
					CustomerUpdate2ControlGUI.this.resources.getString("Error"),
					CustomerUpdate2ControlGUI.this.resources
							.getString("TravelbasysManager"));
		} catch (CustomerDaoException d) {
			Dialogs.showErrorDialog(
					(Stage) root.getScene().getWindow(),
					CustomerUpdate2ControlGUI.this.resources
							.getString("CustomerExist"),
					CustomerUpdate2ControlGUI.this.resources.getString("Error"),
					CustomerUpdate2ControlGUI.this.resources
							.getString("TravelbasysManager"));
		}
	}

	@FXML
	private void handleSearchButton(ActionEvent e) {
		try {
			ObservableList<Customer> data = FXCollections
					.observableArrayList(Dao.getDAO().findById(
							Integer.parseInt(customerIDField.getText())));
			CustomerUpdate2ControlGUI.this.model.setData(data);

			if (CustomerUpdate2ControlGUI.this.model.getData().get(0) != null) {
				DialogOptions options = DialogOptions.YES_NO;
				DialogResponse response = Dialogs.showConfirmDialog(

						(Stage) root.getScene().getWindow(),
						CustomerUpdate2ControlGUI.this.resources
								.getString("Lastname")
								+ CustomerUpdate2ControlGUI.this.model
										.getData().get(0).getLastName()
								+ "\n"
								+ CustomerUpdate2ControlGUI.this.resources
										.getString("Firstname")
								+ CustomerUpdate2ControlGUI.this.model
										.getData().get(0).getFirstName()
								+ "\n"
								+ CustomerUpdate2ControlGUI.this.resources
										.getString("Birthdate")
								+ CustomerUpdate2ControlGUI.this.model
										.getData().get(0).getBirthdate()
								+ "\n"
								+ CustomerUpdate2ControlGUI.this.resources
										.getString("Age")
								+ CustomerUpdate2ControlGUI.this.model
										.getData().get(0).getAge()
								+ "\n"
								+ CustomerUpdate2ControlGUI.this.resources
										.getString("Adress")
								+ CustomerUpdate2ControlGUI.this.model
										.getData().get(0).getAdress()
								+ "\n"
								+ CustomerUpdate2ControlGUI.this.resources
										.getString("Postalcode")
								+ CustomerUpdate2ControlGUI.this.model
										.getData().get(0).getPostalcode()
								+ "\n"
								+ CustomerUpdate2ControlGUI.this.resources
										.getString("Email")
								+ CustomerUpdate2ControlGUI.this.model
										.getData().get(0).getEmail() + "\n\n",
						CustomerUpdate2ControlGUI.this.resources
								.getString("CustomerWithID")
								+ customerIDField.getText()
								+ " "
								+ CustomerUpdate2ControlGUI.this.resources
										.getString("Found"),
						CustomerUpdate2ControlGUI.this.resources
								.getString("TravelbasysManager"), options);
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
						(Stage) root.getScene().getWindow(),
						CustomerUpdate2ControlGUI.this.resources
								.getString("CustomerWithID")
								+ customerIDField.getText()
								+ " "
								+ CustomerUpdate2ControlGUI.this.resources
										.getString("NotFound"),
						CustomerUpdate2ControlGUI.this.resources
								.getString("Error"),
						CustomerUpdate2ControlGUI.this.resources
								.getString("TravelbasysManager"));
			}
		} catch (NumberFormatException d) {
			Dialogs.showErrorDialog(
					(Stage) root.getScene().getWindow(),
					CustomerUpdate2ControlGUI.this.resources
							.getString("SyntaxError")
							+ customerIDField.getText()
							+ "\n"
							+ CustomerUpdate2ControlGUI.this.resources
									.getString("CustomerIDError"),
					CustomerUpdate2ControlGUI.this.resources.getString("Error"),
					CustomerUpdate2ControlGUI.this.resources
							.getString("TravelbasysManager"));
		}

	}

	@FXML
	private void handleNewSearchButton(ActionEvent e) {
		clear();
		deactivateEdit();
		deactivateNewSearch();
		activateSearch();
		customerIDField.requestFocus();
	}

	@FXML
	private void deactivateNewSearch() {
		newSearchButton.setDisable(true);
	}

	private void deactivateEdit() {
		lastnameField.setEditable(false);
		firstnameField.setEditable(false);
		birthdateField.setEditable(false);
		adressField.setEditable(false);
		postalcodeField.setEditable(false);
		emailField.setEditable(false);
		sendButton.setDisable(true);
		calendarButton.setDisable(true);
	}

	private void activateSearch() {
		customerIDField.setEditable(true);
		customerIDField.clear();
	}

	private void activateNewSearch() {
		newSearchButton.setDisable(false);
	}

	private void deactivateSearch() {
		customerIDField.setEditable(false);
		searchButton.setDisable(true);
	}

	private void clear() {
		lastnameField.clear();
		firstnameField.clear();
		ageField.clear();
		adressField.clear();
		postalcodeField.clear();
		emailField.clear();
	}

	private void activateEdit() {

		lastnameField.setEditable(true);
		lastnameField.setText(CustomerUpdate2ControlGUI.this.model.getData()
				.get(0).getLastName());

		firstnameField.setEditable(true);
		firstnameField.setText(CustomerUpdate2ControlGUI.this.model.getData()
				.get(0).getFirstName());

		calendarButton.setDisable(false);
		birthdateField.setEditable(true);

		birthdateField.setText(String.valueOf(Datum
				.getFormattedString((CustomerUpdate2ControlGUI.this.model
						.getData().get(0).getBirthdate()))));

		System.out.println(CustomerUpdate2ControlGUI.this.model.getData()
				.get(0));

		ageField.setText(String.valueOf(CustomerUpdate2ControlGUI.this.model
				.getData().get(0).getAge()));

		adressField.setEditable(true);
		adressField.setText(CustomerUpdate2ControlGUI.this.model.getData()
				.get(0).getAdress());

		postalcodeField.setEditable(true);
		postalcodeField.setText(CustomerUpdate2ControlGUI.this.model.getData()
				.get(0).getPostalcode());

		emailField.setEditable(true);
		emailField.setText(CustomerUpdate2ControlGUI.this.model.getData()
				.get(0).getEmail());
	}

	private void deactivateSend() {
		sendButton.setDisable(true);
	}

	public void updateSearchButton() {
		searchButton.setDisable(model.searchIsInvalid());

	}

	public void updateSendButton() {
		sendButton.setDisable(model.sendIsInvalid() || model.hasNotChanged());

	}

	@Override
	public void handleConfigurationEvent(ConfigurationEvent e) {

		resources = e.getResources();

		headerLabel.setText(resources.getString("CustomerEdit"));
		customerIDLabel.setText(resources.getString("CustomerID"));
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

		customerIDField.setPromptText(resources.getString("Customeridfield"));
		lastnameField.setPromptText(resources.getString("Lastnamefield"));
		firstnameField.setPromptText(resources.getString("Firstnamefield"));
		ageField.setPromptText(resources.getString("Agefield"));
		adressField.setPromptText(resources.getString("Adressfield"));
		postalcodeField.setPromptText(resources.getString("Postalcodefield"));
		emailField.setPromptText(resources.getString("Emailfield"));
		birthdateField.setPromptText(resources.getString("Birthdatefield"));

		calendarButton.setText(resources.getString("CalendarButton"));
		searchButton.setText(resources.getString("Search"));
		sendButton.setText(resources.getString("SendButton"));
		newSearchButton.setText(resources.getString("NewSearch"));

	}
}