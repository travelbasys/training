package de.travelbasys.training.dialog.customer.yesno;
//GEHT NICHT MEHR
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Console;

/**
	 */
public class YesNoView implements View {
	private YesNoModel model;
	private YesNoControl control;

	public YesNoView(YesNoModel model, YesNoControl control) {
	}

	public void run() {
		do {
			AppContext.printMessage("DelUserQPrompt");
			AppContext.printMessage("Yes");
			AppContext.printMessage("No");
			String decisiontemp = Console.nextLine();
			model.setDecisiontemp(decisiontemp);
			Console.println(model.getDecisiontemp());
			try {
				control.checkdelete();
			} catch (Exception e) {
				AppContext.printErrString("ChooseErr");

			}

		} while (model.getFlagCheck());
	}

	@Override
	public void init(Model model) {
		// TODO Auto-generated method stub

	}
}
