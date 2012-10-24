package de.travelbasys.training.dialog.customer.showandchange;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dialog.customer.show1.CustomerShow1Dialog;
import de.travelbasys.training.dialog.customer.showandchange1.ShowAndChange1Dialog;
import de.travelbasys.training.framework.Dialog;

/**
 * ist verantwortlich für das anzeigen und eines Benutzers aus der Datenbank, um
 * dessen Werte anschließend zu ändern.
 * 
 * 
 * 
 */
public class ShowAndChangeDialog implements Dialog {

	private ShowAndChangeView view;
	private static ShowAndChangeModel model;
	private ShowAndChangeControl control;

	private Customer customer;

	private static int index;
	/**
	 * führt den Dialog aus.
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

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public static ShowAndChangeModel getModel() {
		return model;
	}

	public void setModel(ShowAndChangeModel model) {
		ShowAndChangeDialog.model = model;
	}

}
