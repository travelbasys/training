package de.travelbasys.training.dialog.customer;

import java.util.InputMismatchException;
import java.util.List;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Console;

/**
 * 
 * Diese Klasse ändert das Alter eines anhand des Namens gesuchten User
 * Objektes.
 * 
 * @author tba
 * 
 */
public class CustomerUpdate {
	private static String lastname = "";
	private static int customerid = 0;
	private static String firstname = "";
	private static String adress = "";
	private static String postalcode = "";
	private static String email = "";
	private static int age = 0;

	/**
	 * 
	 */
	public static void run() {

		AppContext.getString("IDPrompt");

		// Usernamen einlesen. Scanner in = new Scanner(System.in);
		// String
		customerid = Console.nextInt();
		if (customerid == 0) {
			return;
		}

		List<Customer> user = CustomerDAO.findUserByID(customerid);
		if (user.isEmpty()) { // Errormeldung
			AppContext.getErrString("IDNotFoundErr");
			return;
		}
		AppContext.getString("UserFound");
		AppContext.println(user);
		do {
			AppContext.getString("Choose");
			AppContext.getString("Cancel");
			AppContext.getString("Update1");
			AppContext.getString("Update2");
			AppContext.getString("Update3");
			AppContext.getString("Update4");
			AppContext.getString("Update5");
			AppContext.getString("Update6");
			int choice_str = Console.nextInt();
			try {
				switch (choice_str) {
				case 0:
					return;
				case 1:
					AppContext.getString("FirstNamePrompt");
					firstname = Console.nextLine();
					CustomerDAO.setSingleUserFirstname(customerid, firstname);
					break;
				case 2:
					AppContext.getString("LastNamePrompt");
					lastname = Console.nextLine();
					CustomerDAO.setSingleUserLastname(customerid, lastname);
					break;
				case 3:
					AppContext.getString("AgePrompt");
					age = Console.nextInt();
					CustomerDAO.setSingleUserAge(customerid, age);
					break;
				case 4:
					AppContext.getString("AdressPrompt");
					adress = Console.nextLine();
					CustomerDAO.setSingleUserAdress(customerid, adress);
					break;
				case 5:
					AppContext.getString("PostalPrompt");
					postalcode = Console.nextLine();
					CustomerDAO.setSingleUserPostalcode(customerid, postalcode);
					break;
				case 6:
					AppContext.getString("eMailPrompt");
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
}
