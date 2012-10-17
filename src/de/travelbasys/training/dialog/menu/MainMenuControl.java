package de.travelbasys.training.dialog.menu;

import de.travelbasys.training.db.ChangeDBDialog;
import de.travelbasys.training.dialog.Dialog;
import de.travelbasys.training.dialog.customer.CustomerList;
import de.travelbasys.training.dialog.customer.Delete.CustomerDeleteDialog;
import de.travelbasys.training.dialog.customer.Show.CustomerShowDialog;
import de.travelbasys.training.dialog.customer.Update.CustomerUpdateDialog;
import de.travelbasys.training.dialog.customer.create.CustomerCreateDialog;
import de.travelbasys.training.dialog.other.ChangeParamDialog;
import de.travelbasys.training.dialog.other.Export;
import de.travelbasys.training.dialog.other.Import;
import de.travelbasys.training.rbsjava.main.Application;
import de.travelbasys.training.util.AppContext;

public class MainMenuControl extends Application {

	public MainMenuControl(MainMenuModel model, MainMenuView view) {
	}

	public void checkchoice(String choice_str) {
		Dialog d;
		try {
			int choice_int = Integer.parseInt(choice_str);
			if (choice_int >= 0 && choice_int <= 9) {
				switch (choice_int) {
				case 0:
					stop();
					terminate();
				case 1:
					d = new CustomerCreateDialog();
					d.run();
					break;
				case 2:
					d = new CustomerShowDialog();
					d.run();
					break;
				case 3:
					d = new CustomerUpdateDialog();
					d.run();
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
					d = new ChangeParamDialog();
					d.run();
					break;
				default:
					AppContext.printErrString("ChooseErr");
					break;
				}
			} else {
				AppContext.printErrString("ChooseErr");
			}
		} catch (Exception e) {
			AppContext.printErrString("NumberErr");
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
