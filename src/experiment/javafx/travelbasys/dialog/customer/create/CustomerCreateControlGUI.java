package experiment.javafx.travelbasys.dialog.customer.create;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Dialogs;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.CustomerDaoException;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.framework.Control;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

public class CustomerCreateControlGUI implements Control {

	private CustomerCreateModelGUI model;
	private CustomerCreateViewGUI view;

	public CustomerCreateControlGUI() {
	}

	// TODO: HandleFocus, wenn ein Feld verlassen wird z.B. Validate-Prüfung
	// & Set im Model.
	// TODO: Falsche Eingaben verbieten z.B. durch Feldeigenschaften/anderer
	// FeldTyp
	// TODO: Boolean im Model, ob alle Daten validiert eingegeben wurden.
	// TODO: Grafisch darstellen ob ein Inhalt korrekt ist z.B. Haken/Kreuz
	// oder rote/gründe Umrandung.
	// TODO: Vielleicht User im Feld fangen (unsicher) solange Wert
	// inkorrekt.

	// view.getFirstnameField().setOnFocus(new FocusHandler<FocusEvent>() {
	// @Override
	// public void handleFocusLost(FocusEvent arg0) {
	// String value = arg0.getSource().getText();
	// if( validate( value ) ){
	// model.setFirstname( value );
	// }
	// else {
	// //
	// }
	// }
	// });

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void init(Model model, View view) {
		this.model = (CustomerCreateModelGUI) model;
		this.view = (CustomerCreateViewGUI) view;

		this.view.getLastNameField().focusedProperty()
				.addListener(new ChangeListener() {

					@Override
					public void changed(ObservableValue arg0, Object arg1,
							Object arg2) {
						TextField field = CustomerCreateControlGUI.this.view
								.getLastNameField();
						if ((boolean) arg1 == true) {
							CustomerCreateControlGUI.this.model
									.setLastname(field.getText());
							CustomerCreateControlGUI.this.view.update();
						}
					}
				});

		this.view.getFirstNameField().focusedProperty()
				.addListener(new ChangeListener() {

					@Override
					public void changed(ObservableValue arg0, Object arg1,
							Object arg2) {
						TextField field = CustomerCreateControlGUI.this.view
								.getFirstNameField();
						if ((boolean) arg1 == true) {
							CustomerCreateControlGUI.this.model
									.setFirstname(field.getText());
							CustomerCreateControlGUI.this.view.update();
						}
					}
				});

		this.view.getAgeField().focusedProperty()
				.addListener(new ChangeListener<Boolean>() {

					@Override
					public void changed(
							ObservableValue<? extends Boolean> observable,
							Boolean oldValue, Boolean newValue) {
						TextField field = CustomerCreateControlGUI.this.view
								.getAgeField();

						// Wenn Cursor das Feld verlässt...
						if (oldValue) {
							if (!field.getText().isEmpty()) {
								try {
									int age = Integer.parseInt(field.getText());
									if (age > 0 && age <= 150) {
										CustomerCreateControlGUI.this.model
												.setAge(age);
									} else
										throw new NumberFormatException();
								} catch (NumberFormatException e) {
									field.clear();
									Dialogs.showErrorDialog(
											(Stage) CustomerCreateControlGUI.this.view
													.getRoot().getScene()
													.getWindow(),
											"You've entered a non-valid Age.",
											"Error",
											"Travelbasys Customer Manager");
								}
							}
						}
					}
				});

		this.view.getAdressField().focusedProperty()
				.addListener(new ChangeListener() {

					@Override
					public void changed(ObservableValue arg0, Object arg1,
							Object arg2) {
						TextField field = CustomerCreateControlGUI.this.view
								.getAdressField();
						if ((boolean) arg1 == true) {
							if (!field.getText().isEmpty()) {
								CustomerCreateControlGUI.this.model
										.setAdress(field.getText());
							}
						}
					}
				});

		this.view.getPostalcodeField().focusedProperty()
				.addListener(new ChangeListener() {

					@Override
					public void changed(ObservableValue arg0, Object arg1,
							Object arg2) {
						TextField field = CustomerCreateControlGUI.this.view
								.getPostalcodeField();
						if ((boolean) arg1 == true) {
							if (!field.getText().isEmpty()) {
								try {
									if (Integer.parseInt(field.getText()) > 0
											&& field.getText().length() == 5) {
										CustomerCreateControlGUI.this.model
												.setPostalcode(field.getText());
									} else
										throw new NumberFormatException();
								} catch (NumberFormatException e) {
									field.clear();
									Dialogs.showErrorDialog(
											(Stage) CustomerCreateControlGUI.this.view
													.getRoot().getScene()
													.getWindow(),
											"You've entered a non-valid Postalcode.",
											"Error",
											"Travelbasys Customer Manager");
								}
							}
						}
					}
				});

		this.view.getEmailField().focusedProperty()
				.addListener(new ChangeListener() {

					@Override
					public void changed(ObservableValue arg0, Object arg1,
							Object arg2) {
						TextField field = CustomerCreateControlGUI.this.view
								.getEmailField();
						if ((boolean) arg1 == true) {
							CustomerCreateControlGUI.this.model.setEmail(field
									.getText());
							CustomerCreateControlGUI.this.view.update();
						}
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
							"Transaction successful.", "Information",
							"Travelbasys Customer Manager");
				} catch (CustomerDaoException d) {
					Dialogs.showErrorDialog(
							(Stage) CustomerCreateControlGUI.this.view
									.getRoot().getScene().getWindow(),
							"Transaction failed.", "Error",
							"Travelbasys Customer Manager");
				} catch (NumberFormatException d) {
					Dialogs.showErrorDialog(
							(Stage) CustomerCreateControlGUI.this.view
									.getRoot().getScene().getWindow(),
							"Wrong syntax.", "Error",
							"Travelbasys Customer Manager");

				} catch (IllegalArgumentException d) {
					Dialogs.showErrorDialog(
							(Stage) CustomerCreateControlGUI.this.view
									.getRoot().getScene().getWindow(),
							"Wrong input. Check your values.", "Error",
							"Travelbasys Customer Manager");
				}
			}

		});

	}

	@Override
	public void handleInput(Object value) throws Exception {
	}
}
