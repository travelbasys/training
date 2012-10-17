package de.travelbasys.training.dialog.customer.Delete;

import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.dialog.Dialog;
import de.travelbasys.training.util.AppContext;

/**
 * ist verantwortlich für das löschen eines Benutzers aus der Datenbank
 * 
 * @author tba
 * 
 */
public class CustomerDeleteDialog implements Dialog {
	private CustomerDeleteModel model;
	private CustomerDeleteView view;
	private CustomerDeleteControl control;

	@Override
	public void run() {
		model = new CustomerDeleteModel();
		control = new CustomerDeleteControl(model);
		view = new CustomerDeleteView(model, control);

		view.run();
		view.found();
		view.decision();

		boolean flag = model.getDeleteFlag();
		if (flag) {
			int customerid = model.getCustomerid();
			CustomerDAO.delUser(customerid);
			AppContext.printMessage("DelOK");
		}
	}
}
