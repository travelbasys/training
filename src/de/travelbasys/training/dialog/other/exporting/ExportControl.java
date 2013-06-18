package de.travelbasys.training.dialog.other.exporting;

import de.travelbasys.training.framework.AbstractControl;
import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

/**
 * Diese Klasse Kontrolliert Benutzereingaben und setzt demensprechend bestimmte
 * Werte in das Model.
 * 
 * @author tba
 * 
 */
public class ExportControl {

	private ExportModel model;
	private ExportView view;
	private String Export = "";

	public ExportControl(Model model, View view) {
		this.model = (ExportModel) model;
		this.view = (ExportView) view;
		AbstractUiComponent uic;

		uic = this.view.getcustomerDecisionComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				int intValue = (Integer) value;
				ExportControl.this.model.setExportType(null);
				switch (intValue) {
				case 0:
					return;
				case 1:
					Export = ".csv";
					ExportControl.this.model.setExportType(Export);
					ExportControl.this.model
							.setHeader("CustomerID;LastName;FirstName;Age;Adress;Postalcode;eMail");
					break;
				case 2:
					Export = ".mdb";
					ExportControl.this.model.setExportType(Export);
					ExportControl.this.model.setHeader("");
					break;
				default:
					throw new Exception("ChooseErrComp");
				}
			}
		});
		uic = this.view.getExportNameComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				ExportControl.this.model.setExportName((String) value);
			}
		});

	}

}
