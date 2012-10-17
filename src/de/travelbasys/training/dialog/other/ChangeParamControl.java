package de.travelbasys.training.dialog.other;

import de.travelbasys.training.db.ChangeDBParamDialog;
import de.travelbasys.training.util.AppContext;

/**
 * Diese Klasse Kontrolliert Benutzereingaben.
 * 
 * @author tba
 * 
 */
public class ChangeParamControl {

	private ChangeParamModel model;
	private int choice;

	public ChangeParamControl(ChangeParamModel model) {
		this.model = model;
	}

	public void checkchoice() {
		try {
			choice = Integer.parseInt(model.getChoice());
			if (choice >= 0 && choice <= 2) {
				switch (choice) {
				case 0:
					model.setCheckFalse();
					return;
				case 1:
					model.setDialog(new ChangeLangDialog());
					model.setCheckFalse();
					return;
				case 2:
					model.setDialog(new ChangeDBParamDialog());
					model.setCheckFalse();
					return;
				default:
					AppContext.printErrString("ChooseErr");
					model.setCheckTrue();
					break;
				}
			} else {
				AppContext.printErrString("ChooseErr");
				model.setCheckTrue();
			}
		} catch (Exception e) {
			AppContext.printErrString("NumberErr");
			model.setCheckTrue();
		}
	}
}
