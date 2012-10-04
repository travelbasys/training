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

		AppContext.println("IDPrompt");

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
		AppContext.println("UserFound");
		AppContext.println(user);
		do {
			AppContext.println("Choose");
			AppContext.println("Cancel");
			AppContext.println("Update1");
			AppContext.println("Update2");
			AppContext.println("Update3");
			AppContext.println("Update4");
			AppContext.println("Update5");
			AppContext.println("Update6");
			int choice_str = Console.nextInt();
			try {
				switch (choice_str) {
				case 0:
					return;
				case 1:
					AppContext.println("FirstNamePrompt");
					firstname = Console.nextLine();
					CustomerDAO.setSingleUserFirstname(customerid, firstname);
					break;
				case 2:
					AppContext.println("LastNamePrompt");
					lastname = Console.nextLine();
					CustomerDAO.setSingleUserLastname(customerid, lastname);
					break;
				case 3:
					AppContext.println("AgePrompt");
					age = Console.nextInt();
					CustomerDAO.setSingleUserAge(customerid, age);
					break;
				case 4:
					AppContext.println("AdressPrompt");
					adress = Console.nextLine();
					CustomerDAO.setSingleUserAdress(customerid, adress);
					break;
				case 5:
					AppContext.println("PostalPrompt");
					postalcode = Console.nextLine();
					CustomerDAO.setSingleUserPostalcode(customerid, postalcode);
					break;
				case 6:
					AppContext.println("eMailPrompt");
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
