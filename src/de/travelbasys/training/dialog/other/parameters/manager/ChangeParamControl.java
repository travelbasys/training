package de.travelbasys.training.dialog.other.parameters.manager;

import de.travelbasys.training.dialog.other.parameters.database.ChangeDBDialog;
import de.travelbasys.training.dialog.other.parameters.language.ChangeLangDialog;
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
public class ChangeParamControl {

	private ChangeParamModel model;
	private ChangeParamView view;

	public ChangeParamControl(Model model, View view) {
		this.model = (ChangeParamModel) model;
		this.view = (ChangeParamView) view;
		AbstractUiComponent uic;

		uic = this.view.getcustomerDecisionComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				int intValue = (Integer) value;
				switch (intValue) {
				case 0:
					ChangeParamControl.this.model.setEnd();
					return;
				case 1:
					ChangeParamControl.this.model
							.setDialog(new ChangeLangDialog());
					break;
				case 2:
					ChangeParamControl.this.model
							.setDialog(new ChangeDBDialog());
					break;
				default:
					throw new Exception("ChooseErrComp");
				}
			}
		});

	}

}
