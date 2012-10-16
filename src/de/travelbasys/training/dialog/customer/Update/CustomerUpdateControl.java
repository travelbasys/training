package de.travelbasys.training.dialog.customer.Update;

import java.util.List;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Console;

/**
 * Diese Klasse Kontrolliert Benutzereingaben.
 * 
 * @author tba
 * 
 */

public class CustomerUpdateControl {
	private CustomerUpdateModel model;
	private CustomerUpdateView view;

	private static String lastname = "";
	private static int customerid = 0;
	private static String firstname = "";
	private static String adress = "";
	private static String postalcode = "";
	private static String email = "";
	private static int age = 0;

	public CustomerUpdateControl(CustomerUpdateModel model,
			CustomerUpdateView view) {
		this.model = model;
		this.view = view;
	}

	public void check(String customeridtemp) {
		customerid = Integer.parseInt(customeridtemp);
		List<Customer> user = CustomerDAO.findUserByID(customerid);
		if (user.isEmpty()) { // Errormeldung
			AppContext.getErrString("IDNotFoundErr");
			return;
		}
		AppContext.printMessage("UserFound");
		AppContext.println(user);
	}

	public int checkmenu() {
	
	
		do {
			

			
			try {
				String choice_strtemp = Console.nextLine();
				int choice_int = Integer.parseInt(choice_strtemp);
				switch (choice_int) {
				case 0:
					CustomerUpdateDialog.end();
					return 0;
				case 1:
					AppContext.printMessage("FirstNamePrompt");
					firstname = Console.nextLine();
					CustomerUpdateDialog.setFirstname(customerid, firstname);
					break;
				case 2:
					AppContext.printMessage("LastNamePrompt");
					lastname = Console.nextLine();
					CustomerUpdateDialog.setLastname(customerid, lastname);
					break;
				case 3:
					AppContext.printMessage("AgePrompt");
					age = Console.nextInt();
					CustomerUpdateDialog.setAge(customerid, age);
					break;
				case 4:
					AppContext.printMessage("AdressPrompt");
					adress = Console.nextLine();
					CustomerUpdateDialog.setAdress(customerid, adress);
					break;
				case 5:
					AppContext.printMessage("PostalPrompt");
					postalcode = Console.nextLine();
					CustomerUpdateDialog.setPostalcode(customerid, postalcode);
					break;
				case 6:
					AppContext.printMessage("eMailPrompt");
					email = Console.nextLine();
					CustomerUpdateDialog.setEmail(customerid, email);
					break;
				default:
					break;
				}
				
				return 1;
			} catch (Exception e) {
				AppContext.getErrString("NumberErr");
			}

		} while (true);

	}

	public boolean checkend() {
		return false;
	}

	

}