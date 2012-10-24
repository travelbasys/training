package de.travelbasys.training.dialog.customer.showandchange1;

import de.travelbasys.training.framework.AbstractControl;
import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

/**
 * hat die Aufgabe, einen View innerhalb des ShowAndChange Dialoges zu steuern.
 * 
 * Die aktuelle Implementierung führt Dialoge aus die den Wert der gewünschten
 *  Funktion abfragt, außerdem wird geprüft ob es sich um gültige
 * eingaben handelt.
 * 
 */
public class ShowAndChange1Control extends AbstractControl {

	private ShowAndChange1Model model;
	private ShowAndChange1View view;

	public void init(Model model, View view) {
		this.model = (ShowAndChange1Model) model;
		this.view = (ShowAndChange1View) view;

		AbstractUiComponent uic;

		uic = this.view.getchoiceComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				checkchoice(value);
			}
		});

	}

	private void checkchoice(Object value) throws Exception {
			int choice = ((Integer) value);
			model.setIndex(choice);
	}
}
