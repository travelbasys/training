package de.travelbasys.training.dialog.other;

import de.travelbasys.training.util.AppContext;

/**
 * Diese Klasse Kontrolliert Benutzereingaben.
 * @author tba
 *
 */
public class ImportControl {

	private ImportModel model;
	private int choice;

	public ImportControl(ImportModel model) {
		this.model = model;
	}

	public void checkchoice() {
		String Import = "";
		try {
			choice = Integer.parseInt(model.getChoice());
			if (choice >= 0 && choice <= 2) {
				switch (choice) {
				case 0:
					model.setEndFlag();
					model.setCheckFalse();
					return;
				case 1:
					Import = "CSV";
					model.setImportType(Import);
					model.setHeader("UserID;LastName;FirstName;Age;Adress;Postalcode;eMail");
					model.setCheckFalse();
					return;
				case 2:
					Import = "ACCESS";
					model.setImportType(Import);
					model.setHeader("");
					model.setCheckFalse();
					return;
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

	public void checkname(String Import_name) {
		if (!Import_name.isEmpty()) {
			model.setImportName(Import_name);
			model.setCheckFalse();
			
		} else {
			AppContext.printErrString("NumberErr");
		}		
	}
}
