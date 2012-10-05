package de.travelbasys.training.dialog.menu;

import de.travelbasys.training.db.ChangeDBDialog;
import de.travelbasys.training.dialog.Dialog;
import de.travelbasys.training.dialog.customer.CustomerList;
import de.travelbasys.training.dialog.customer.Delete.CustomerDeleteDialog;
import de.travelbasys.training.dialog.customer.Show.CustomerShow;
import de.travelbasys.training.dialog.customer.Update.CustomerUpdate;
import de.travelbasys.training.dialog.customer.create.CustomerCreateDialog;
import de.travelbasys.training.dialog.other.ChangeParam;
import de.travelbasys.training.dialog.other.Export;
import de.travelbasys.training.dialog.other.Import;
import de.travelbasys.training.util.AppContext;

public class MainMenuControl {

	public MainMenuControl(MainMenuModel model, MainMenuView view) {
	}

	public void checkchoice(String choice_str) {
		Dialog d;
		try {
			int choice_int = Integer.parseInt(choice_str);
			if(choice_int >= 0 && choice_int <= 9 || choice_int == 21 || choice_int == 22){
			switch (choice_int) {
			case 0:
				return;
			case 1:
				d = new CustomerCreateDialog();
				d.run();
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
				d = new CustomerDeleteDialog();
				d.run();
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
				d = new ChangeDBDialog();
				d.run();
				break;
			case 9:
				ChangeParam.run();
				break;
			default:
				AppContext.getErrString("ChooseErr");
				break;
			}
			}
			else{
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
