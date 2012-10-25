package de.travelbasys.training.dialog.customer.showandchange;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dialog.customer.show1.CustomerShow1Dialog;
import de.travelbasys.training.dialog.customer.showandchange1.ShowAndChange1Dialog;
import de.travelbasys.training.framework.Dialog;

/**
 * 
 * ist verantwortlich für das Anzeigen eines Benutzers aus der Datenbank, um
 * dessen Werte anschließend an einem temporären Customer Objekt zu ändern.
 */
public class ShowAndChangeDialog implements Dialog {

	private ShowAndChangeView view;
	private static ShowAndChangeModel model;
	private ShowAndChangeControl control;

	private Customer customer;

	private static int index;

	/**
	 * Führt mehrere Dialoge aus und erhält dabei Rückgabewerte. Prüft ob der
	 * vom Benutzer eingegebene Index = 0 ist und reagiert entsprechend.
	 * 
	 * @return Springt aus der Schleife wenn Index = 0.
	 */
	@Override
	public void run() {
		do {
			model.setCustomer();
			CustomerShow1Dialog d2 = new CustomerShow1Dialog();
			d2.setCustomer(model.getCustomer());
			d2.init();
			d2.run();
			ShowAndChange1Dialog d3 = new ShowAndChange1Dialog();
			d3.init();
			d3.run();
			index = d3.getIndex();
			if (index == 0) {
				model.setEndFlag(true);
				return;
			}
			model.setIndex(index);
			view.run();
		} while (model.getEndFlag() == false);
	}

	/**
	 * Erzeugt interne Model, View und Control Instanzen und initialisiert
	 * diese. Das Model erhält bei der Initialisierung Werte eines Customer
	 * Objekts.
	 */
	public void init() {
		model = new ShowAndChangeModel();
		control = new ShowAndChangeControl();
		view = new ShowAndChangeView(model, control);
		model.setCustomerid(customer.getUserID());
		model.setCustomerAdress(customer.getAdress());
		model.setCustomerAge(customer.getAge());
		model.setCustomerFirstname(customer.getFirstname());
		model.setCustomerLastname(customer.getLastName());
		model.setCustomerPostalcode(customer.getPostalcode());
		model.setCustomerEMail(customer.getEmail());

		view.init(model);
		control.init(model, view);
	}

	/**
	 * Setzt den Customer.
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Repräsentiert das Model der aktuellen Instanz.
	 * 
	 * @return Die Instanz des Models.
	 */
	public static ShowAndChangeModel getModel() {
		return model;
	}

	/**
	 * Setzt das Model dem Model des ShowAndChangeDialogs gleich.
	 */
	public void setModel(ShowAndChangeModel model) {
		ShowAndChangeDialog.model = model;
	}

}
