package de.travelbasys.training.dialog.customer.yesno;

import java.util.ArrayList;

import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.UiComponent;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.Console;

/**
	 */
public class YesNoView extends ArrayList<UiComponent> implements View {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private YesNoModel model;
	private static final String CUSTOMERDECISION = "Whitespace";
	private UiComponent customerDecisionComponent;

	public AbstractUiComponent getcustomerdecisionComponent() {
		return customerDecisionComponent;
	}

	public YesNoView(YesNoModel model, YesNoControl control) {
		super();
		this.model = model;
	}

	String choice_str;

	public void run() {
		do {
			for (String s : model) {
				Console.println(s);
			}
			for(UiComponent uiComponent : this){
				 uiComponent.run();
			 }
		} while (model.getEndFlag() == false);
	}

	@Override
	public void init(Model model) {
		this.model = (YesNoModel) model;
		customerDecisionComponent = new UiComponent();
		customerDecisionComponent.setName(CUSTOMERDECISION);
		customerDecisionComponent.setValue(this.model.getDecision());
		add(customerDecisionComponent);
	}
}
