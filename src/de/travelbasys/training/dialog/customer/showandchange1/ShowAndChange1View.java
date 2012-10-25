package de.travelbasys.training.dialog.customer.showandchange1;

import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.UiComponent;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.Console;

/**
 * zeigt ein Menü bestehend aus im Model abgelegten Menüpunkten und fragt den
 * Anwender nach der gewünschten Alternative.
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
	 * Erzeugt einen Wert für die ChoiceComponent Eigenschaft mit Integer.class
	 * als Typ.
	 */
	public void init(Model model) {
		this.model = (ShowAndChange1Model) model;

		choiceComponent = new UiComponent();
		choiceComponent.setType(Integer.class);
	}

	/**
	 * Schreibt das Menü aus allen im Model gespeicherten Strings und führt dann
	 * die gespeicherte UiComponent aus, welche den Benutzer nach dem
	 * gewünschten Menüpunkt fragt.
	 */
	@Override
	public void run() {
		for (String s : model) {
			Console.println(s);
		}
		choiceComponent.run2();
	}
}