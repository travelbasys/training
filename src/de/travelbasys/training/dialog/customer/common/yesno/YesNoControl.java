package de.travelbasys.training.dialog.customer.common.yesno;

import de.travelbasys.training.framework.AbstractControl;
import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

/**
 * steuert den Dialog mit dem Benutzer zur Auswahl eines Menüpunktes.
 */

public class YesNoControl {
	private YesNoModel model;
	private YesNoView view;

	/**
	 * setzt den Input Handler in der DecisionComponent des View, so dass das
	 * Decision Attribut des Model den eingebenen Wert bekommt.
	 */
	public YesNoControl(Model model, View view) {
		this.model = (YesNoModel) model;
		this.view = (YesNoView) view;

		AbstractUiComponent uic;

		uic = this.view.getcustomerdecisionComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				int intValue = (Integer) value;
				switch (intValue) {
				case 1:
					YesNoControl.this.model.setYes(true);
					break;
				case 2:
					YesNoControl.this.model.setYes(false);
					break;
				default:
					throw new Exception("ChooseErr");
				}
			}
		});
	}

}
