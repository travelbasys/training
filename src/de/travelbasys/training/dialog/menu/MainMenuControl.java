package de.travelbasys.training.dialog.menu;

import de.travelbasys.training.db.ChangeDB;
import de.travelbasys.training.dialog.customer.CustomerCreateDialog;
import de.travelbasys.training.dialog.customer.CustomerDelete;
import de.travelbasys.training.dialog.customer.CustomerList;
import de.travelbasys.training.dialog.customer.CustomerShow;
import de.travelbasys.training.dialog.customer.CustomerUpdate;
import de.travelbasys.training.dialog.other.ChangeParam;
import de.travelbasys.training.dialog.other.Export;
import de.travelbasys.training.dialog.other.Import;
import de.travelbasys.training.util.AppContext;

public class MainMenuControl {

	public MainMenuControl(MainMenuModel model, MainMenuView view) {
	}

	public void checkchoice(String choice_str) {
		try {
			int choice_int = Integer.parseInt(choice_str);
			switch (choice_int) {
			case 0:
				return;
			case 1:
				CustomerCreateDialog customer = new CustomerCreateDialog();
				customer.run();
				break;
			case 21:
				CustomerShow.run2();
				break;
			case 22:
				CustomerShow.run();
				break;
			case 3:
				CustomerUpdate.run();
				break;
			case 4:
				CustomerDelete.run();
				break;
			case 5:
				CustomerList.run();
				break;
			case 6:
				Export.run();
				break;
			case 7:
				Import.run();
				break;
			case 8:
				ChangeDB.run();
				break;
			case 9:
				ChangeParam.run();
				break;
			default:
				AppContext.getErrString("ChooseErr");
				break;
			}

		} catch (Exception e) {
		}
	}

	public boolean checkend(String choice_str) {
		try {
			if (Integer.parseInt(choice_str) == 0) {
				return false;
			}
		} catch (Exception e) {
			AppContext.getErrString("NumberErr");
		}

		return true;
	}
}
