package de.travelbasys.training.dialog.other;

import java.util.Locale;

import de.travelbasys.training.util.AppContext;

/**
 * Diese Klasse Kontrolliert Benutzereingaben.
 * 
 * @author tba
 * 
 */
public class ChangeLangControl {

	private ChangeLangModel model;
	int choice;

	public ChangeLangControl(ChangeLangModel model) {
		this.model = model;
	}

	public void checkchoice() {
		try {
			choice = Integer.parseInt(model.getChoice());
			if (choice >= 0 && choice <= 2) {
				switch (choice) {
				case 0:
					model.setEndFlag();
					model.setLocale(Locale.getDefault());
					model.setCheckFalse();
					return;
				case 1:
					model.setLocale(new Locale("en"));
					model.setCheckFalse();
					return;
				case 2:
					model.setLocale(new Locale("de"));
					model.setCheckFalse();
					return;
				default:
					AppContext.printErrString("ChooseErr");
					break;
				}
			} else {
				AppContext.printErrString("ChooseErr");
				model.setLocale(Locale.getDefault());
			}
		} catch (Exception e) {
			AppContext.printErrString("NumberErr");
			model.setLocale(Locale.getDefault());
		}
	}
}
