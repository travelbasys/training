package de.travelbasys.training.dialog.menu;

import java.util.Scanner;

import de.travelbasys.training.util.Console;


public class MainMenuView {

	private MainMenuControl control;
	private MainMenuModel model;
	private static Scanner in;

	public MainMenuView(MainMenuModel model, MainMenuControl control) {
		super();
		this.model = model;
	}

	public void run() {
		
		for (String s : model) {
			Console.println(s);
		}
		in = new Scanner(System.in);
		int choice_str = in.nextInt();
		control.check(choice_str);
		
		// Input lesen.
		// Controller.check()

	}

}
