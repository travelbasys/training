package de.travelbasys.training.dialog.customer.yesno;

//GEHT NICHT MEHR
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.Console;

/**
	 */
public class YesNoView implements View {
	private YesNoModel model;
	private YesNoControl control;

	public YesNoView(YesNoModel model, YesNoControl control) {
		super();
		this.model = model;
		this.control = control;
	}

	String choice_str;

	public void run() {
		do {
			for (String s : model) {
				Console.println(s);
			}
			choice_str = Console.nextLine();
			model.setDecisiontemp(choice_str);
			control.checkdelete();
		} while (model.getEndFlag() == false);
	}

	@Override
	public void init(Model model) {

	}
}
