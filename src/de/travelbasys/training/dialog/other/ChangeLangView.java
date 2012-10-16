package de.travelbasys.training.dialog.other;

import de.travelbasys.training.util.Console;

public class ChangeLangView {

	/**
	 * 
	 */
	private ChangeLangModel model;
	private ChangeLangControl control;
	String choice_str;
	int choice = 0;

	public ChangeLangView(ChangeLangModel model, ChangeLangControl control) {
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
		} while (control.checkchoice(choice_str) == 1);
	}
}