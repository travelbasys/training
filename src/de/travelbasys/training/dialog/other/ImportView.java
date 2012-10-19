package de.travelbasys.training.dialog.other;

import java.util.ArrayList;

import de.travelbasys.training.dialog.VTextField;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Console;

/**
 * ist verantwortlich für den Dialog mit dem Benutzer, um alle Daten für das Importieren der
 * Datenbank abzufragen.
 * @autor tba
 */
public class ImportView extends ArrayList<VTextField> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private ImportModel model;
	private ImportControl control;
	String choice_str;
	int choice = 0;
	private String Import_name;

	public ImportView(ImportModel model, ImportControl control) {
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
			model.setChoice(choice_str);
			control.checkchoice();
		} while (model.getCheck());
	}

	public void decision() {
		do {
			model.setCheckTrue();
			AppContext.printMessage("ImportName");
			Import_name = Console.nextLine().trim();
			control.checkname(Import_name);
		} while (model.getCheck());
	}
}
