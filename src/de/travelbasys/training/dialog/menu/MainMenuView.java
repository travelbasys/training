package de.travelbasys.training.dialog.menu;

import de.travelbasys.training.util.Console;

public class MainMenuView {

	private MainMenuModel model;
	private MainMenuControl control;

	public MainMenuView(MainMenuModel model, MainMenuControl control) {
		super();
		this.model = model;
		this.control = control;
	}

	public void run() {
		String choice_str;
		do {
			for (String s : model) {
				Console.println(s);
			}
			choice_str = Console.nextLine();
			control.checkchoice(choice_str);
		} while (control.checkend(choice_str));
		// Input lesen.
		// Controller.check()

	}

}
