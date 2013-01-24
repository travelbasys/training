package de.travelbasys.trainingfx.dialog.customer.update2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import javafx.stage.Stage;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.CustomerDaoException;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.util.Configuration;
import de.travelbasys.training.util.ConfigurationEvent;
import de.travelbasys.training.util.ConfigurationListener;

public class CustomerUpdate2ControlGUI implements Initializable,
		ConfigurationListener {

	private CustomerUpdate2ModelGUI model;
	private ResourceBundle resources;
	
	@FXML
	private BorderPane root;
	@FXML
	private static Label headerLabel;
	@FXML
	private static Label CustomerIDLabel;
	@FXML
	private static Label LastnameLabel;
	@FXML
	private static Label FirstnameLabel;
	@FXML
	private static Label AgeLabel;
	@FXML
	private static Label AdressLabel;
	@FXML
	private static Label PostalcodeLabel;
	@FXML
	private static Label EmailLabel;
	@FXML
	private static Label ValidAgeLabel;
	@FXML
	private static Label ValidPostalcodeLabel;
	@FXML
	private static TextField CustomerIDField;
	@FXML
	private static TextField LastnameField;
	@FXML
	private static TextField FirstnameField;
	@FXML
	private static TextField AgeField;
	@FXML
	private static TextField AdressField;
	@FXML
	private static TextField PostalcodeField;
	@FXML
	private static TextField EmailField;
	@FXML
	private static Button sendButton;
	@FXML
	private static Button searchButton;
	@FXML
	private static Button newSearchButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model = new CustomerUpdate2ModelGUI();

		this.resources = resources;
		// this.root = (BorderPane)location.getClass();

		Configuration.addConfigurationListener(this);

		LastnameField.setEditable(false);
		FirstnameField.setEditable(false);
		AgeField.setEditable(false);
		AdressField.setEditable(false);
		PostalcodeField.setEditable(false);
		EmailField.setEditable(false);

		sendButton.setDisable(true);
		searchButton.setDisable(true);
		newSearchButton.setDisable(true);

		CustomerIDField.textProperty().addListener(
				new ChangeListener<String>() {

					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						TextField field = CustomerIDField;
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

		LastnameField.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {
				CustomerUpdate2ControlGUI.this.model.setLastname(LastnameField
						.getText().trim());

				updateSendButton();
			}
		});

		FirstnameField.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {
				CustomerUpdate2ControlGUI.this.model
						.setFirstname(FirstnameField.getText().trim());

				updateSendButton();
			}
		});

		AgeField.textProperty().addListener(new ChangeListener<String>() {

			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {
				TextField field = AgeField;
				Label hint = ValidAgeLabel;
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

		AdressField.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {
				CustomerUpdate2ControlGUI.this.model.setAdress(AdressField
						.getText().trim());

				updateSendButton();
			}
		});

		PostalcodeField.textProperty().addListener(
				new ChangeListener<String>() {

					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						TextField field = PostalcodeField;
						Label hint = ValidPostalcodeLabel;
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

		EmailField.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {
				CustomerUpdate2ControlGUI.this.model.setEmail(EmailField
						.getText().trim());

				updateSendButton();
			}
		});
	}

	@SuppressWarnings("unused")
	@FXML
	private void handleSendButton(ActionEvent e) {
		try {
			Customer customer = new Customer(Integer.parseInt(CustomerIDField
					.getText()),

			LastnameField.getText(),

			FirstnameField.getText(), Integer.parseInt(AgeField.getText()),

			AdressField.getText(),

			PostalcodeField.getText(),

			EmailField.getText());
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

	@SuppressWarnings("unused")
	@FXML
	private void handleSearchButton(ActionEvent e) {
		try {
			ObservableList<Customer> data = FXCollections
					.observableArrayList(Dao.getDAO().findById(
							Integer.parseInt(CustomerIDField.getText())));
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
										.getData().get(0).getEmail()
								+ "\n\n"
								+ CustomerUpdate2ControlGUI.this.resources
										.getString("UpdateQuestion"),
						CustomerUpdate2ControlGUI.this.resources
								.getString("CustomerWithID")
								+ CustomerIDField.getText()
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
								+ CustomerIDField.getText()
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
							+ CustomerIDField.getText()
							+ "\n"
							+ CustomerUpdate2ControlGUI.this.resources
									.getString("CustomerIDError"),
					CustomerUpdate2ControlGUI.this.resources.getString("Error"),
					CustomerUpdate2ControlGUI.this.resources
							.getString("TravelbasysManager"));
		}

	}

	@SuppressWarnings("unused")
	@FXML
	private void handleNewSearchButton(ActionEvent e) {
		clear();
		deactivateEdit();
		deactivateNewSearch();
		activateSearch();
		CustomerIDField.requestFocus();
	}

	@FXML
	private void deactivateNewSearch() {
		newSearchButton.setDisable(true);
	}

	private void deactivateEdit() {
		LastnameField.setEditable(false);
		FirstnameField.setEditable(false);
		AgeField.setEditable(false);
		AdressField.setEditable(false);
		PostalcodeField.setEditable(false);
		EmailField.setEditable(false);
		sendButton.setDisable(true);
	}

	private void activateSearch() {
		CustomerIDField.setEditable(true);
		CustomerIDField.clear();
	}

	private void activateNewSearch() {
		newSearchButton.setDisable(false);
	}

	private void deactivateSearch() {
		CustomerIDField.setEditable(false);
		searchButton.setDisable(true);
	}

	private void clear() {
		LastnameField.clear();
		FirstnameField.clear();
		AgeField.clear();
		AdressField.clear();
		PostalcodeField.clear();
		EmailField.clear();
	}

	private void activateEdit() {

		LastnameField.setEditable(true);
		LastnameField.setText(CustomerUpdate2ControlGUI.this.model.getData()
				.get(0).getLastName());

		FirstnameField.setEditable(true);
		FirstnameField.setText(CustomerUpdate2ControlGUI.this.model.getData()
				.get(0).getFirstName());

		AgeField.setEditable(true);
		AgeField.setText(String.valueOf(CustomerUpdate2ControlGUI.this.model
				.getData().get(0).getAge()));

		AdressField.setEditable(true);
		AdressField.setText(CustomerUpdate2ControlGUI.this.model.getData()
				.get(0).getAdress());

		PostalcodeField.setEditable(true);
		PostalcodeField.setText(CustomerUpdate2ControlGUI.this.model.getData()
				.get(0).getPostalcode());

		EmailField.setEditable(true);
		EmailField.setText(CustomerUpdate2ControlGUI.this.model.getData()
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
		CustomerIDLabel.setText(resources.getString("CustomerID"));
		LastnameLabel.setText(resources.getString("Lastname"));
		FirstnameLabel.setText(resources.getString("Firstname"));
		AgeLabel.setText(resources.getString("Age"));
		AdressLabel.setText(resources.getString("Adress"));
		PostalcodeLabel.setText(resources.getString("Postalcode"));
		EmailLabel.setText(resources.getString("Email"));
		ValidAgeLabel.setText(resources.getString("ValidAge"));
		ValidPostalcodeLabel.setText(resources.getString("ValidPostalcode"));

		CustomerIDField.setPromptText(resources.getString("Customeridfield"));
		LastnameField.setPromptText(resources.getString("Lastnamefield"));
		FirstnameField.setPromptText(resources.getString("Firstnamefield"));
		AgeField.setPromptText(resources.getString("Agefield"));
		AdressField.setPromptText(resources.getString("Adressfield"));
		PostalcodeField.setPromptText(resources.getString("Postalcodefield"));
		EmailField.setPromptText(resources.getString("Emailfield"));

		searchButton.setText(resources.getString("Search"));
		sendButton.setText(resources.getString("SendButton"));
		newSearchButton.setText(resources.getString("NewSearch"));

	}
}