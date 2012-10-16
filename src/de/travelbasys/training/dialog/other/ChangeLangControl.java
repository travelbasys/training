package de.travelbasys.training.dialog.other;

import java.util.Locale;

import de.travelbasys.training.dialog.menu.MainMenuDialog;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Config;

/**
 * Diese Klasse Kontrolliert Benutzereingaben.
 * 
 * @author tba
 * 
 */
public class ChangeLangControl {

	public ChangeLangControl(ChangeLangModel model, ChangeLangView view) {
		// TODO Auto-generated constructor stub
	}

	public int checkchoice(String choice_str) {
		try {
			int choice_int = Integer.parseInt(choice_str);
			if (choice_int >= 0 && choice_int <= 2) {
				switch (choice_int) {
				case 0:
					return 0;
				case 1:
					Config.updateLanguage(new Locale("en"));
					MainMenuDialog d = new MainMenuDialog();
					d.run();
					return 1;
				case 2:
					Config.updateLanguage(new Locale("de"));
					MainMenuDialog e = new MainMenuDialog();
					e.run();
					return 1;
				default:
					AppContext.getErrString("ChooseErr");
					break;
				}
			} else {
				AppContext.getErrString("ChooseErr");
			}
		} catch (Exception e) {
			AppContext.getErrString("NumberErr");
		}
		return 0;
	}
}
