package de.travelbasys.training.dialog;

import de.travelbasys.training.util.Console;

public class VTextField {

	private String fieldName;

	private Model model;
	private Control control;

	public VTextField(String fieldName, Model model,
			Control control) {
		super();
		this.fieldName = fieldName;
		this.model = model;
		this.control = control;
	}
	
	
	
	public void run() {
		String prompt;
		String value;

		while (true) {

			prompt = model.getPrompt(fieldName);
			Console.println(prompt);

			value = Console.nextLine().trim();

			try {
				control.check(fieldName, value);
				model.put(fieldName, value);
				return;
			} catch (Exception e) {
				Console.printerr(e);
			}
		}
	}

}
