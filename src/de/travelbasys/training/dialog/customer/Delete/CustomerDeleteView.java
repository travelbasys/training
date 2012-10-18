package de.travelbasys.training.dialog.customer.Delete;

import java.util.ArrayList;
import java.util.List;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dialog.VTextField;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Console;

/**
 * Diese Klasse ist verantwortlich für den Dialog mit dem Benutzer um die für
 * das löschen eines Customers aus der Datenbank
 * 
 * @author tba
 * 
 */
public class CustomerDeleteView extends ArrayList<VTextField> {
	private CustomerDeleteModel model;
	private CustomerDeleteControl control;

	private static final long serialVersionUID = 1L;

	public CustomerDeleteView(CustomerDeleteModel model,
			CustomerDeleteControl control) {
		super();
		this.model = model;
		this.control = control;
	}

	public void run() {
		List<Customer> userList = null;

		AppContext.printMessage("AttentionIntPrompt");
		String customeridtemp;
		do {
			AppContext.printMessage("IDPrompt");
			customeridtemp = Console.nextLine();
			model.setCustomeridtemp(customeridtemp);
			try {
				control.check(customeridtemp);
				userList = model.getUserlist();
			} catch (Exception e) {
				AppContext.printErrString("ChooseErr");
			}
		} while (userList == null);
	}

	public void found() {
		AppContext.printMessage("UserFound");
		Customer customer = model.getUserlist().get(0);

		AppContext.println(customer);

		return;

	}

	public void decision() {
		do {
		AppContext.printMessage("DelUserQ");
		AppContext.printMessage("Yes");
		AppContext.printMessage("No");
		String decisiontemp = Console.nextLine();
		
		model.setDecisiontemp(decisiontemp);
		try {
			control.checkdelete();

		} catch (Exception e) {
			e.printStackTrace();
			AppContext.printErrString("ChooseErr");
		}

		model.getDecision();
		}while(model.getFlagCheck());
		
	}
}