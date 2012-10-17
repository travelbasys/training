package de.travelbasys.training.dialog.other;

import de.travelbasys.training.db.ChangeDBParamDialog;
import de.travelbasys.training.dialog.Dialog;
import de.travelbasys.training.dialog.menu.MainMenuDialog;
import de.travelbasys.training.util.AppContext;

/**
 * Diese Klasse Kontrolliert Benutzereingaben.
 * 
 * @author tba
 * 
 */
public class ChangeParamControl {

	private ChangeParamModel model;
	private ChangeParamView view;
	private int choice;

	public ChangeParamControl(ChangeParamModel model, ChangeParamView view) {
		this.model = model;
		this.view = view;
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
					AppContext.getErrString("ChooseErr");
					model.setCheckTrue();
					break;
				}
			} else {
				AppContext.getErrString("ChooseErr");
				model.setCheckTrue();
			}
		} catch (Exception e) {
			AppContext.getErrString("NumberErr");
			model.setCheckTrue();
		}
	}
}
