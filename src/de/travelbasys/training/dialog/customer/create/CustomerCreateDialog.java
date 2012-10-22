package de.travelbasys.training.dialog.customer.create;

import java.util.ArrayList;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.dialog.Control;
import de.travelbasys.training.dialog.Dialog;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

/**
 * ist verantwortlich für das erzeugen eines Customer Objekts.
 * 
 * @author tba
 */

public class CustomerCreateDialog implements Dialog {

	private Model model;
	private View view;
	private Control control;
	
	@Override
	public void run() {
		model = new CustomerCreateModel();
		control = new CustomerCreateControl();
		view = new CustomerCreateView();
		
		view.init(model);
		control.init(model,view);
		
		view.run();

		
		
		
		
		
		
		// Do something with the input!
		Customer costumer = null;
		int customerid = CustomerDAO.getLastCustomerId() + 1;
		try {
			costumer = new Customer(customerid, model.get("LastName"),
					model.get("FirstName"), model.getAge(),
					model.get("Adress"), model.get("PostalCode"),
					model.get("EMail"));
		} catch (Exception e) {
			e.printStackTrace();
			CustomerDAO.setUsers(new ArrayList<Customer>());
		}
		CustomerDAO.getUsers().add(costumer);
	}

}
