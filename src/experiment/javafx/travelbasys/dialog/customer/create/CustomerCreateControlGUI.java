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

	private CustomerCreateModelGUI model;

	public CustomerCreateControlGUI(Model model) {
		this.model = (CustomerCreateModelGUI) model;
	}

	@Override
	public void init(Model model, View view) {
	}

	@Override
	public void handleInput(Object value) throws Exception {
	}

	public void init() {
		// TODO: Aufruf eines Feldes über den View (nicht Model)
		// TODO: HandleFocus, wenn ein Feld verlassen wird z.B. Validate-Prüfung
		// & Set im Model.
		// TODO: Namen der Felder eindeutiger machen z.B. getFirstNameField  oder SendButton etc.
		// statt getTxt_firstname
		// TODO: Root an View Constructor
		// TODO: Falsche Eingaben verbieten z.B. durch Feldeigenschaften/anderer
		// FeldTyp
		// TODO: Boolean im Model, ob alle Daten validiert eingegeben wurden.
		// TODO: Grafisch darstellen ob ein Inhalt korrekt ist z.B. Haken/Kreuz oder rote/gründe Umrandung.
		//TODO: Vielleicht User im Feld fangen (unsicher) solange Wert inkorrekt.

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

		model.getBtn().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				int dummyId = 0;
				try {
					Customer customer = new Customer(dummyId, model
							.getTxt_lastname().getText(), model
							.getTxt_firstname().getText(), Integer
							.parseInt(model.getTxt_age().getText()), model
							.getTxt_adress().getText(), model
							.getTxt_postalcode().getText(), model
							.getTxt_email().getText());

					Dao.getDAO().create(customer);

					Dialogs.showInformationDialog((Stage) model.getRoot()
							.getScene().getWindow(), "Transaction successful.",
							"Information", "Travelbasys Customer Manager");
				} catch (CustomerDaoException d) {
					Dialogs.showErrorDialog((Stage) model.getRoot().getScene()
							.getWindow(), "Transaction failed.", "Error",
							"Travelbasys Customer Manager");
				} catch (NumberFormatException d) {
					Dialogs.showErrorDialog((Stage) model.getRoot().getScene()
							.getWindow(), "Wrong syntax.", "Error",
							"Travelbasys Customer Manager");

				} catch (IllegalArgumentException d) {
					Dialogs.showErrorDialog((Stage) model.getRoot().getScene()
							.getWindow(), "Wrong input. Check your values.",
							"Error", "Travelbasys Customer Manager");
				}
			}

		});
	}
}
