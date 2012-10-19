package de.travelbasys.training.dialog.customer.show;

import de.travelbasys.training.util.Console;

public class CustomerShowView {

	/**
	 * 
	 */
	private CustomerShowModel model;
	private CustomerShowControl control;
	String choice_str;
	int choice = 0;

	public CustomerShowView(CustomerShowModel model, CustomerShowControl control) {
		super();
		this.model = model;
		this.control = control;
	}

	public void run() {
		do {
			for (String s : model) {
				Console.println(s);
			}
			choice_str = Console.nextLine();
			control.checkchoice(choice_str);
		} while (control.checkend(choice_str));
	}
}

