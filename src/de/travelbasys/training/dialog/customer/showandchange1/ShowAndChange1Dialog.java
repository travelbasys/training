package de.travelbasys.training.dialog.customer.showandchange1;

import de.travelbasys.training.framework.Dialog;

/**
 */
public class ShowAndChange1Dialog implements Dialog {

	private ShowAndChange1Model model;
	private ShowAndChange1View view;
	private ShowAndChange1Control control;

	@Override
	public void run() {
		view.run();
	}

	public int getIndex() {
		return model.getIndex();
	}

	public void init() {
		model = new ShowAndChange1Model();
		control = new ShowAndChange1Control();
		view = new ShowAndChange1View();

		view.init(model);
		control.init(model, view);
	}

}
