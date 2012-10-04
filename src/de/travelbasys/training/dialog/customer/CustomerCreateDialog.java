package de.travelbasys.training.dialog.customer;

import java.util.ArrayList;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.dialog.Dialog;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Console;
import de.travelbasys.training.util.Datum;

/**
 * ist verantwortlich für den Dialog mit dem Benutzer, um alle Daten für ein
 * Customer Objekt abzufragen und das Objekt dann zu erzeugen.
 * 
 * @author tba
 */

public class CustomerCreateDialog {
	
	private CustomerCreateModel model;
	private CustomerCreateView view;
	private CustomerCreateControl control;

	public void run() {
		model = new CustomerCreateModel();
		control = new CustomerCreateControl(model);
		view = new CustomerCreateView(model,control);
		
		// Here plays the music!
		view.run();
		
		// Do something with the input!
		Customer costumer = null;
		int customerid = CustomerDAO.getLastCustomerId() + 1;
		try{
			costumer = new Customer(customerid, 
					model.get("LastName"), model.get("FirstName"), model.getAge(), model.get("Adress"),
					model.get("PostalCode"), model.get("EMail"));
		}catch(Exception e){
			e.printStackTrace();
			CustomerDAO.setUsers(new ArrayList<Customer>());
		}
		CustomerDAO.getUsers().add(costumer);
		Console.println(CustomerDAO.getUsers());
	}

}
