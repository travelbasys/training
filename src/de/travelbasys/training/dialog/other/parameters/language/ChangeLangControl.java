package de.travelbasys.training.dialog.other.parameters.language;

import java.util.Locale;

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
public class ChangeLangControl {

	private ChangeLangModel model;
	private ChangeLangView view;

	public ChangeLangControl(Model model, View view) {
		this.model = (ChangeLangModel) model;
		this.view = (ChangeLangView) view;
		AbstractUiComponent uic;

		uic = this.view.getcustomerDecisionComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				int intValue = (Integer) value;
				switch (intValue) {
				case 0:
					ChangeLangControl.this.model.setEnd();
					ChangeLangControl.this.model.setLocale(Locale.getDefault());
					return;
				case 1:
					ChangeLangControl.this.model.setLocale(new Locale("en"));

					break;
				case 2:
					ChangeLangControl.this.model.setLocale(new Locale("de"));

					break;
				default:
					throw new Exception("ChooseErrComp");
				}
			}
		});

	}

}
