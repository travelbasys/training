package de.travelbasys.training.dialog.customer.yesno;

import de.travelbasys.training.framework.Dialog;

/**
 * zeigt dem Benutzer ein Auswahlmen� und l�sst ihn darin einen Men�punkt
 * ausw�hlen.
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
	 * f�hrt den Dialog aus. Am Ende kann durch die {@see #getFlag} Methode
	 * festgestellt werden, ob der Benutzer Ja oder Nein ausgew�hlt hat.
	 */
	@Override
	public void run() {
		view.run();
	}

	/**
	 * Gibt die Entscheidung des vom Benutzer gew�hlten Men�punktes zur�ck.
	 * Vorher muss die {@see #run} Methode ausgef�hrt werden, damit die
	 * Entscheidung gepr�ft werden kann.
	 * 
	 * @return die Entscheidung des Benutzers.
	 */
	public boolean isYes() {
		return model.isYes();
	}
}
