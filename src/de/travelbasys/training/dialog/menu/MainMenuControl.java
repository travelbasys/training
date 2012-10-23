package de.travelbasys.training.dialog.menu;

import de.travelbasys.training.db.ChangeSaveDBDialog;
import de.travelbasys.training.dialog.customer.CustomerList;
import de.travelbasys.training.dialog.customer.create.CustomerCreateDialog;
import de.travelbasys.training.dialog.customer.delete.CustomerDeleteDialog;
import de.travelbasys.training.dialog.customer.show.CustomerShowDialog;
import de.travelbasys.training.dialog.customer.update.CustomerUpdateDialog;
import de.travelbasys.training.dialog.other.ChangeParamDialog;
import de.travelbasys.training.dialog.other.ExportDialog;
import de.travelbasys.training.dialog.other.ImportDialog;
import de.travelbasys.training.framework.Dialog;
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
					d = new CustomerList();
					d.run();
					break;
				case 6:
					d = new ExportDialog();
					d.run();
					break;
				case 7:
					d = new ImportDialog();
					d.run();
					break;
				case 8:
					d = new ChangeSaveDBDialog();
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
		} catch (NumberFormatException e) {
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
