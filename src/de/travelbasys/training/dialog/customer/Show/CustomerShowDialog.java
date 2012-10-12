package de.travelbasys.training.dialog.customer.Show;

import de.travelbasys.training.dialog.Control;
import de.travelbasys.training.dialog.Dialog;

/**
 * ist verantwortlich für den Dialog mit dem Benutzer, um alle Daten für ein
 * Customer Objekt abzufragen und das Objekt dann zu erzeugen.
 * 
 * @author tba
 */

public class CustomerShowDialog implements Dialog {

	private CustomerShowModel model;
	private CustomerShowView view;
	private Control control;

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.travelbasys.training.dialog.customer.create.Dialog#run()
	 */
	@Override
	public void run() {
		model = new CustomerShowModel();
		control = new CustomerShowControl(model);
		view = new CustomerShowView(model, control);

		// Here plays the music!
		view.run();

		// Do something with the input!

		/*
		 * Customer costumer = null; int customerid =
		 * CustomerDAO.getLastCustomerId() + 1; try { costumer = new
		 * Customer(customerid, model.get("LastName"), model.get("FirstName"),
		 * model.getAge(), model.get("Adress"), model.get("PostalCode"),
		 * model.get("EMail")); } catch (Exception e) { e.printStackTrace();
		 * CustomerDAO.setUsers(new ArrayList<Customer>()); }
		 * CustomerDAO.getUsers().add(costumer);
		 * Console.println(CustomerDAO.getUsers());
		 */
	}

}
