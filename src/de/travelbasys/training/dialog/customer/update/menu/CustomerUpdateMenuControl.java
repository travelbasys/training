package de.travelbasys.training.dialog.customer.update.menu;

import de.travelbasys.training.framework.AbstractControl;
import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

/**
 * steuert den Dialog mit dem Benutzer zur Auswahl eines Menüpunktes.
 */
public class CustomerUpdateMenuControl extends AbstractControl {

	/**
	 * setzt den Input Handler in der ChoiceComponent des View, so dass das
	 * Index Attribut des Model den eingebenen Wert bekommt.
	 */
	public CustomerUpdateMenuControl(final Model model, View view) {
		AbstractUiComponent uic;
		uic = ((CustomerUpdateMenuView) view).getChoiceComponent();
		uic.setControl(new AbstractControl() {
			// Speichere den gegebenen Wert als Index im Model.
			public void handleInput(Object value) {
				((CustomerUpdateMenuModel) model).setIndex((Integer) value);
			}
		});
	}
}
