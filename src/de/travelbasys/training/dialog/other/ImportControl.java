package de.travelbasys.training.dialog.other;

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
				switch (intValue) {
				case 0:
					ImportControl.this.model.setEnd();
					return;
				case 1:
					Import = "CSV";
					ImportControl.this.model.setImportType(Import);
					ImportControl.this.model
							.setHeader("UserID;LastName;FirstName;Age;Adress;Postalcode;eMail");
					break;
				case 2:
					Import = "ACCESS";
					ImportControl.this.model.setImportType(Import);
					ImportControl.this.model.setHeader("");
					break;
				default:
					throw new Exception("ChooseErr");
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
