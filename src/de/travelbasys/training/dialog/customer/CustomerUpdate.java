package de.travelbasys.training.dialog.customer;

import java.util.InputMismatchException;
import java.util.List;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.util.Config;
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

		Console.println(Config.BUNDLE.getString("IDPrompt"));

		// Usernamen einlesen. Scanner in = new Scanner(System.in);
		// String
		customerid = Console.nextInt();
		if (customerid == 0) {
			return;
		}

		List<Customer> user = CustomerDAO.findUserByID(customerid);
		if (user.isEmpty()) { // Errormeldung
			System.err.println(Config.BUNDLE.getString("IDNotFoundErr"));
			return;
		}
		Console.println(Config.BUNDLE.getString("UserFound"));
		Console.println(user);
		do {
			Console.println(Config.BUNDLE.getString("Choose"));
			Console.println("0: " + Config.BUNDLE.getString("Cancel"));
			Console.println("1: " + Config.BUNDLE.getString("Update1"));
			Console.println("2: " + Config.BUNDLE.getString("Update2"));
			Console.println("3: " + Config.BUNDLE.getString("Update3"));
			Console.println("4: " + Config.BUNDLE.getString("Update4"));
			Console.println("5: " + Config.BUNDLE.getString("Update5"));
			Console.println("6: " + Config.BUNDLE.getString("Update6"));

			int choice_str = Console.nextInt();
			try {
				switch (choice_str) {
				case 0:
					return;
				case 1:
					Console.println(Config.BUNDLE.getString("FirstNamePrompt"));
					firstname = Console.nextLine();
					CustomerDAO.setSingleUserFirstname(customerid, firstname);
					break;
				case 2:
					Console.println(Config.BUNDLE.getString("LastNamePrompt"));
					lastname = Console.nextLine();
					CustomerDAO.setSingleUserLastname(customerid, lastname);
					break;
				case 3:
					Console.println(Config.BUNDLE.getString("AgePrompt"));
					age = Console.nextInt();
					CustomerDAO.setSingleUserAge(customerid, age);
					break;
				case 4:
					Console.println(Config.BUNDLE.getString("AdressPrompt"));
					adress = Console.nextLine();
					CustomerDAO.setSingleUserAdress(customerid, adress);
					break;
				case 5:
					Console.println(Config.BUNDLE.getString("PostalPrompt"));
					postalcode = Console.nextLine();
					CustomerDAO.setSingleUserPostalcode(customerid, postalcode);
					break;
				case 6:
					Console.println(Config.BUNDLE.getString("eMailPrompt"));
					email = Console.nextLine();
					CustomerDAO.setSingleUserEmail(customerid, email);
					break;
				default:
					break;
				}
			} catch (NumberFormatException e) {
				Console.printerr(Config.BUNDLE.getString("NumberErr"));
			} catch (InputMismatchException e) {
				Console.printerr(Config.BUNDLE.getString("NumberErr"));
			}

		} while (true);

	}
}
