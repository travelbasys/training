package de.travelbasys.training.dialog.customer.common.yesno;

import java.util.ArrayList;

import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.UiComponent;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.Console;

/**
 * zeigt ein Auswahlmen� bestehend aus im Model abgelegten Men�punkten und fragt
 * den Anwender nach der gew�nschten Alternative.
 */
public class YesNoView extends ArrayList<UiComponent> implements View {
	private static final long serialVersionUID = 1L;
	private YesNoModel model;
	private UiComponent customerDecisionComponent;

	/**
	 * Speichert das gegebene Model Objekt.
	 * 
	 * Erzeugt einen Wert f�r die DecisionComponent Eigenschaft mit
	 * Integer.class als Typ.
	 */
	public YesNoView(Model model) {
		this.model = (YesNoModel) model;
		customerDecisionComponent = new UiComponent();
		customerDecisionComponent.setType(Integer.class);
	}

	public AbstractUiComponent getcustomerdecisionComponent() {
		return customerDecisionComponent;
	}

	/**
	 * Schreibt das Men� aus allen im Model gespeicherten Strings und f�hrt dann
	 * die gespeicherte UiComponent aus, welche den Benutzer nach der
	 * gew�nschten Auswahl fragt.
	 */
	public void run() {
		for (String s : model) {
			Console.println(s);
		}
		customerDecisionComponent.run2();
	}

}
