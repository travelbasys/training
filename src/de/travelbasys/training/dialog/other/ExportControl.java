package de.travelbasys.training.dialog.other;

import de.travelbasys.training.util.AppContext;

/**
 * Diese Klasse Kontrolliert Benutzereingaben.
 * 
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
		String Export = "";
		try {
			choice = Integer.parseInt(model.getChoice());
			if (choice >= 0 && choice <= 2) {
				model.setCheckFalse();
				switch (choice) {
				case 0:
					model.setEndFlag();
					model.setCheckFalse();
					return;
				case 1:
					Export = "CSV";
					model.setExportType(Export);
					model.setHeader("UserID;LastName;FirstName;Age;Adress;Postalcode;eMail");
					model.setCheckFalse();
					return;
				case 2:
					Export = "ACCESS";
					model.setExportType(Export);
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

	public void checkname(String export_name) {
		if (!export_name.isEmpty()) {
			model.setExportName(export_name);
			model.setCheckFalse();
			
		} else {
			AppContext.printErrString("NumberErr");
		}		
	}
}
