package de.travelbasys.training.dialog.other;

import de.travelbasys.training.db.ChangeDBParamDialog;
import de.travelbasys.training.dialog.Dialog;
import de.travelbasys.training.util.AppContext;

/**
 * Diese Klasse Kontrolliert Benutzereingaben.
 * 
 * @author tba
 * 
 */
public class ChangeParamControl {

	public ChangeParamControl(ChangeParamModel model, ChangeParamView view) {
		// TODO Auto-generated constructor stub
	}

	public void checkchoice(String choice_str) {
		Dialog d;
		try {
			int choice_int = Integer.parseInt(choice_str);
			if (choice_int >= 0 && choice_int <= 2) {
				switch (choice_int) {
				case 0:
					return;
				case 1:
					d = new ChangeLangDialog();
					d.run();
					break;
				case 2:
					d = new ChangeDBParamDialog();
					d.run();
					break;
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
	}

	public boolean checkend(String choice_str) {
		try {
			if (Integer.parseInt(choice_str) == 0) {
				return false;
			}
		} catch (Exception e) {
		}

		return true;
	}
}
