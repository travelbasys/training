package de.travelbasys.training.dialog.other;

import de.travelbasys.training.util.Console;

/**
 * ist verantwortlich für den Dialog mit dem Benutzer, um alle Daten für das
 * ändern der aktuellen Sprche abzufragen.
 * @param <ChangeParamControl>
 * @autor tba
 */
public class ChangeParamView {

	/**
	 * 
	 */
	private ChangeParamModel model;
	private ChangeParamControl control;
	String choice_str;
	int choice = 0;

	public ChangeParamView(ChangeParamModel model, ChangeParamControl control) {
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
			}while(model.isCheck());
		}
	}

