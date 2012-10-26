package de.travelbasys.training.dialog.customer.yesno;

import de.travelbasys.training.framework.Dialog;

/**
 * zeigt dem Benutzer ein Auswahlmenü und lässt ihn darin einen Menüpunkt
 * auswählen.
 */
public class YesNoDialog implements Dialog {
	private YesNoModel model;
	private YesNoView view;
	@SuppressWarnings("unused")
	private YesNoControl control;
	
	
	/**
	 * Constructor
	 * 
	 * @param key
	 */
	public YesNoDialog(String key){
		model = new YesNoModel(key);
		view = new YesNoView(model);
		control = new YesNoControl(model,view);
	}

	/**
	 * führt den Dialog aus. Am Ende kann durch die {@see #getFlag} Methode
	 * festgestellt werden, ob der Benutzer Ja oder Nein ausgewählt hat.
	 */
	@Override
	public void run() {
		view.run();
	}

	/**
	 * Gibt die Entscheidung des vom Benutzer gewählten Menüpunktes zurück.
	 * Vorher muss die {@see #run} Methode ausgeführt werden, damit die
	 * Entscheidung geprüft werden kann.
	 * 
	 * @return die Entscheidung des Benutzers.
	 */
	public boolean isYes() {
		return model.isYes();
	}
}
