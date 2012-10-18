package de.travelbasys.training.dialog.other;

import de.travelbasys.training.util.Console;

/**
 * ist verantwortlich für den Dialog mit dem Benutzer, um alle Daten für das Exportieren der
 * Datenbank abzufragen.
 * @autor tba
 */
public class ExportView {

	/**
	 * 
	 */
	private ExportModel model;
	private ExportControl control;
	String choice_str;
	int choice = 0;

	public ExportView(ExportModel model, ExportControl control) {
		super();
		this.model = model;
		this.control = control;
	}

		public void run() {
			do{
				for (String s : model) {
					Console.println(s);
				}
				choice_str = Console.nextLine();
				model.setChoice(choice_str);
				control.checkchoice();
			}while(model.getCheck());
		}
	}

