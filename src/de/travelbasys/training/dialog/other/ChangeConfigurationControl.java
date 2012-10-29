package de.travelbasys.training.dialog.other;

import de.travelbasys.training.db.ChangeDBSaveDialog;
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
public class ChangeConfigurationControl {

	private ChangeConfigurationModel model;
	private ChangeConfigurationView view;

	public ChangeConfigurationControl(Model model, View view) {
		this.model = (ChangeConfigurationModel) model;
		this.view = (ChangeConfigurationView) view;
		AbstractUiComponent uic;

		uic = this.view.getcustomerDecisionComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				int intValue = (Integer) value;
				switch (intValue) {
				case 0:
					ChangeConfigurationControl.this.model.setEnd();
					return;
				case 1:
					ChangeConfigurationControl.this.model
							.setDialog(new ChangeLangSaveDialog());
					break;
				case 2:
					ChangeConfigurationControl.this.model
							.setDialog(new ChangeDBSaveDialog());
					break;
				default:
					throw new Exception("ChooseErrComp");
				}
			}
		});

	}

}
