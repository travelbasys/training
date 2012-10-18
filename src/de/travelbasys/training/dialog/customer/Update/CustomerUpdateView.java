package de.travelbasys.training.dialog.customer.Update;

import java.util.List;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Console;

/**
 * ist verantwortlich für den Dialog mit dem Benutzer, um alle Daten für das
 * ändern eins Customer Objekts abzufragen
 * 
 * @autor tba
 */

public class CustomerUpdateView {
	private CustomerUpdateModel model;
	private CustomerUpdateControl control;

	public CustomerUpdateView(CustomerUpdateModel model,
			CustomerUpdateControl control) {
		super();
		this.model = model;
		this.control = control;
	}

	public void run() {
		String customeridtemp = "";
		AppContext.printMessage("AttentionIntPrompt");
		List<Customer> user = null;
		do {
			AppContext.printMessage("IDPrompt");
			customeridtemp = Console.nextLine();
			model.setCustomeridtemp(customeridtemp);

			control.check();
			user = model.getUser();

		} while (user == null);
		model.getUser();
		AppContext.println(user);

	}

	public void updatemenu() {
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
			model.setChoice_str(choice_str);
		} while (control.checkmenu() == 1);

	}

	public void firstname() {
		AppContext.printMessage("FirstNamePrompt");
		String firstname = Console.nextLine();
		model.setFirstname(firstname);
		return;
	}

	public void lastname() {
		AppContext.printMessage("LastNamePrompt");
		String lastname = Console.nextLine();
		model.setLastname(lastname);
		return;
	}

	public void age() {
		AppContext.printMessage("AgePrompt");
		int age = Console.nextInt();
		model.setAge(age);
		return;
	}

	public void adress() {
		AppContext.printMessage("AdressPrompt");
		String adress = Console.nextLine();
		model.setAdress(adress);
		return;
	}

	public void postalcode() {
		AppContext.printMessage("PostalPrompt");
		String postalcode = Console.nextLine();
		model.setPostalcode(postalcode);
		return;
	}

	public void email() {
		AppContext.printMessage("eMailPrompt");
		String email = Console.nextLine();
		model.setEmail(email);
		return;
	}

}
