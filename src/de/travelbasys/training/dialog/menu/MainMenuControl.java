package de.travelbasys.training.dialog.menu;

import java.util.Scanner;

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
import de.travelbasys.training.util.Console;

public class MainMenuControl {

	public MainMenuControl(MainMenuModel model) {
	}

	public void check(String fieldName, String value) throws Exception {
		// TODO: Use switch-case statement
		if (fieldName == "Age") {
			Integer.parseInt(value);
		}
		if (fieldName == "PostalCode") {
			if ((Integer.parseInt(value) > 0 && value.length() == 5)) {
			} else {
				throw new Exception("PostalCode error: " + value);
			}
		}
	}

	public void check(int choice_str) {
		try {
			switch (choice_str) {
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
			case 10:
				MainMenuDialog menu = new MainMenuDialog();
				menu.run();
				break;
			default:
				AppContext.getErrString("ChooseErr");
				break;
			}

		} catch (Exception e) {
			AppContext.getErrString("NumberErr");
		}
	}
}
