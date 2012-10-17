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
	private ChangeLangView view;
	int choice;

	public ChangeLangControl(ChangeLangModel model, ChangeLangView view) {
		this.model = model;
		this.view = view;
	}

	public void checkchoice() {
		try {
			choice = Integer.parseInt(model.getChoice());
			if (choice >= 0 && choice <= 2) {
				switch (choice) {
				case 0:
					model.setLocale(Locale.getDefault());
					model.setCheck(false);
					return;
				case 1:
					model.setLocale(new Locale("en"));
					model.setCheck(false);
					return;
				case 2:
					model.setLocale(new Locale("de"));
					model.setCheck(false);
					return;
				default:
					AppContext.getErrString("ChooseErr");
					model.setCheck(true);
					break;
				}
			} else {
				AppContext.getErrString("ChooseErr");
				model.setLocale(Locale.getDefault());
				model.setCheck(true);
			}
		} catch (Exception e) {
			AppContext.getErrString("NumberErr");
			model.setLocale(Locale.getDefault());
			model.setCheck(true);
		}
	}
}
