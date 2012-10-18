package de.travelbasys.training.dialog.other;

import de.travelbasys.training.db.ChangeDBParamDialog;
import de.travelbasys.training.util.AppContext;

/**
 * Diese Klasse Kontrolliert Benutzereingaben.
 * @author tba
 *
 */
public class ExportControl {

	private ExportModel model;
	private int choice;

	public ExportControl(ExportModel model) {
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
					model.setCheckFalse();
					return;
				case 2:
					model.setCheckFalse();
					return;
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
}

