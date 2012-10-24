package de.travelbasys.training.dialog.customer.showandchange1;

import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.UiComponent;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.Console;

/**
 * zeigt ein Men� bestehend aus im Model abgelegten Men�punkten und fragt den
 * Anwender nach der gew�nschten Alternative.
 */
public class ShowAndChange1View implements View {
	private ShowAndChange1Model model;

	private UiComponent choiceComponent;

	public AbstractUiComponent getChoiceComponent() {
		return choiceComponent;
	}

	/**
	 * Speichert das gegebene Model Objekt.
	 * 
	 * Erzeugt einen Wert f�r die ChoiceComponent Eigenschaft mit Integer.class
	 * als Typ.
	 */
	public void init(Model model) {
		this.model = (ShowAndChange1Model) model;

		choiceComponent = new UiComponent();
		choiceComponent.setType(Integer.class);
	}

	/**
	 * Schreibt das Men� aus allen im Model gespeicherten Strings und f�hrt dann
	 * die gespeicherte UiComponent aus, welche den Benutzer nach dem
	 * gew�nschten Men�punkt fragt.
	 */
	@Override
	public void run() {
		for (String s : model) {
			Console.println(s);
		}
		choiceComponent.run2();
	}
}