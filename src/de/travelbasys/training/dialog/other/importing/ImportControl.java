package de.travelbasys.training.dialog.other.importing;

import de.travelbasys.training.framework.AbstractControl;
import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

/**
 * Diese Klasse Kontrolliert Benutzereingaben.
 * 
 * @author tba
 * 
 */
public class ImportControl {

	private ImportModel model;
	private ImportView view;
	private String Import = "";

	public ImportControl(Model model, View view) {
		this.model = (ImportModel) model;
		this.view = (ImportView) view;
		AbstractUiComponent uic;

		uic = this.view.getcustomerDecisionComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				int intValue = (Integer) value;
				ImportControl.this.model.setImportType(null);
				switch (intValue) {
				case 0:
					return;
				case 1:
					Import = "Csvdatabase";
					ImportControl.this.model.setImportType(Import);
					ImportControl.this.model
							.setHeader("CustomerID;LastName;FirstName;birthdate;Age;Adress;Postalcode;eMail;updateID");
					break;
				case 2:
					Import = "Accessdatabase";
					ImportControl.this.model.setImportType(Import);
					ImportControl.this.model.setHeader("");
					break;
				default:
					throw new Exception("ChooseErrComp");
				}
			}
		});
		uic = this.view.getimportNameComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				ImportControl.this.model.setImportName((String) value);
			}
		});

	}

}
