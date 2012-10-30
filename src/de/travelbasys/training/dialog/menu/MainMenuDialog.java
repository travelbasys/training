package de.travelbasys.training.dialog.menu;

import de.travelbasys.training.framework.Dialog;

public class MainMenuDialog implements Dialog {

	private MainMenuModel model;
	private MainMenuView view;
	@SuppressWarnings("unused")
	private MainMenuControl control;

	public MainMenuDialog() {

	}

	@Override
	public void run() {
		do {
			model = new MainMenuModel();
			view = new MainMenuView(model);
			control = new MainMenuControl(model, view);
			Dialog d;
			view.run();
			try {
				d = model.getDialog();
				d.run();
			} catch (NullPointerException e) {
			}
		} while (model.getEnd() == false);
	}
}
