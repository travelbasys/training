package experiment.javafx.travelbasys.dialog.customer.create;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Dialogs;
import javafx.stage.Stage;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.CustomerDaoException;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.framework.Control;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

public class CustomerCreateControlGUI implements Control {

	@SuppressWarnings("unused")
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
	
	@Override
	public void init(Model model, View view) {
		this.model = (CustomerCreateModelGUI) model;
		this.view = (CustomerCreateViewGUI) view;

		this.view.getSendButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				int dummyId = 0;
				try {
					Customer customer = new Customer(dummyId,
							CustomerCreateControlGUI.this.view
									.getLastNameField().getText(),
							CustomerCreateControlGUI.this.view
									.getFirstNameField().getText(),
							Integer.parseInt(CustomerCreateControlGUI.this.view
									.getAgeField().getText()),
							CustomerCreateControlGUI.this.view.getAdressField()
									.getText(),
							CustomerCreateControlGUI.this.view
									.getPostalcodeField().getText(),
							CustomerCreateControlGUI.this.view.getEmailField()
									.getText());

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
