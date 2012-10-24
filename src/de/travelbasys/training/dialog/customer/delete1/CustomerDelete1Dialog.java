package de.travelbasys.training.dialog.customer.delete1;

import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.framework.Dialog;

/**
 * hat die Aufgabe ein vorhandenes Customer Objekt aus der Datenbank zu l�schen.
 * Gibt R�ckmeldung �ber den Erfolg des L�schvorgangs.
 */
public class CustomerDelete1Dialog implements Dialog {
	private CustomerDelete1Model model;
	private int customerid;
	@SuppressWarnings("unused")
	private CustomerDelete1Control control;
	private CustomerDelete1View view;

	/**
	 * L�scht den Customer. F�hrt den Dialog aus.
	 */
	@Override
	public void run() {
		CustomerDAO.delUser(model.getCustomerid());
		view.run();
	}

	public void setCustomerID(int customerid) {
		this.customerid = customerid;
	}

	public void init() {
		model = new CustomerDelete1Model();
		control = new CustomerDelete1Control();
		view = new CustomerDelete1View();

		view.init(model);
		model.setCustomerid(customerid);

	}
}
