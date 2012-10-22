package de.travelbasys.training.dialog.customer.yesno;

import de.travelbasys.training.util.AppContext;

/**
 * Diese Klasse Kontrolliert Benutzereingaben.
 * 
 * @author tba
 * 
 */

public class YesNoControl {
	private YesNoModel model;

	public YesNoControl(YesNoModel model) {
		this.model = model;
	}

	public void checkdelete() {
		try {
			String s = model.getDecisiontemp();
			int decision = Integer.parseInt(s);
			model.setDecision(decision);

		} catch (NumberFormatException e) {
			AppContext.printErrString("NumberErr");
			return;
		}
		int decision = 0;
		decision = model.getDecision();
		if (decision >= 1 && decision <= 2) {
			model.setEndFlag();
			switch (decision) {
			case 1:
				model.setDeleteFlag(true);
				return;
			case 2:
				model.setDeleteFlag(false);
				AppContext.printMessage("Abort");
				return;
			}
		} else {
			AppContext.printErrString("ChooseErr");
			return;
		}

	}

}
