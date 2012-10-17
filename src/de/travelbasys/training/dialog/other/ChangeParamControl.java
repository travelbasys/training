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

	private ChangeParamModel model;
	private ChangeParamView view;
	private int choice;

	public ChangeParamControl(ChangeParamModel model, ChangeParamView view) {
		this.model = model;
		this.view = view;
	}

	public void checkchoice() {
		Dialog d;
		try {
			choice = Integer.parseInt(model.getChoice());
			if (choice >= 0 && choice <= 2) {
				switch (choice) {
				case 0:
					model.setCheck(false);
					return;
				case 1:
					d = new ChangeLangDialog();
					d.run();
					model.setCheck(false);
					return;
				case 2:
					d = new ChangeDBParamDialog();
					d.run();
					model.setCheck(false);
					return;
				default:
					AppContext.getErrString("ChooseErr");
					model.setCheck(true);
					break;
				}
			} else {
				AppContext.getErrString("ChooseErr");
				model.setCheck(true);
			}
		} catch (Exception e) {
			AppContext.getErrString("NumberErr");
			model.setCheck(true);
		}
	}
}
