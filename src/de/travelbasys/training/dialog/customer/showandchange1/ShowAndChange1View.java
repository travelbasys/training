package de.travelbasys.training.dialog.customer.showandchange1;

import java.util.ArrayList;

import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.UiComponent;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.Console;

/**
 */
public class ShowAndChange1View extends ArrayList<UiComponent> implements View {
	private static final long serialVersionUID = 1L;
	private ShowAndChange1Model model;

	private UiComponent choiceComponent;

	public AbstractUiComponent getchoiceComponent() {
		return choiceComponent;
	}

	public void init(Model model) {
		this.model = (ShowAndChange1Model) model;

		choiceComponent = new UiComponent();
		choiceComponent.setValue(this.model.getIndex());
		add(choiceComponent);

	}

	@Override
	public void run() {
		for (String s : model) {
			Console.println(s);
		}
		for (UiComponent uiComponent : this) {
			uiComponent.run2();
		}
	}
}