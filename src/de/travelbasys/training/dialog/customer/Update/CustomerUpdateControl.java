package de.travelbasys.training.dialog.customer.Update;

import java.util.InputMismatchException;
import java.util.List;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.dialog.customer.Delete.CustomerDeleteModel;
import de.travelbasys.training.dialog.customer.Delete.CustomerDeleteView;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Console;


/**
 * Diese Klasse Kontrolliert Benutzereingaben.
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
			do {
				AppContext.printMessage("Choose");
				AppContext.printMessage("Cancel");
				AppContext.printMessage("Update1");
				AppContext.printMessage("Update2");
				AppContext.printMessage("Update3");
				AppContext.printMessage("Update4");
				AppContext.printMessage("Update5");
				AppContext.printMessage("Update6");
				String choice_str = Console.nextLine();
				int choice_int = Integer.parseInt(choice_str);
				try {
					switch (choice_int) {
					case 0:
						return;
					case 1:
						view.getfirstname();
						break;
					case 2:
						AppContext.printMessage("LastNamePrompt");
						lastname = Console.nextLine();
						CustomerDAO.setSingleUserLastname(customerid, lastname);
						break;
					case 3:
						AppContext.printMessage("AgePrompt");
						age = Console.nextInt();
						CustomerDAO.setSingleUserAge(customerid, age);
						break;
					case 4:
						AppContext.printMessage("AdressPrompt");
						adress = Console.nextLine();
						CustomerDAO.setSingleUserAdress(customerid, adress);
						break;
					case 5:
						AppContext.printMessage("PostalPrompt");
						postalcode = Console.nextLine();
						CustomerDAO.setSingleUserPostalcode(customerid, postalcode);
						break;
					case 6:
						AppContext.printMessage("eMailPrompt");
						email = Console.nextLine();
						CustomerDAO.setSingleUserEmail(customerid, email);
						break;
					default:
						break;
					}
				} catch (NumberFormatException e) {
					AppContext.getErrString("NumberErr");
				} catch (InputMismatchException e) {
					AppContext.getErrString("NumberErr");
				}

			} while (true);

		}
		

	public boolean checkend(String customeridtemp) {
		// TODO Auto-generated method stub
		return false;
	}
	public void setfirstname(){
	CustomerDAO.setSingleUserFirstname(customerid, firstname);
	return;
	}
}