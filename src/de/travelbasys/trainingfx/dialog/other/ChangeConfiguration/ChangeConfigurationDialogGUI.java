package de.travelbasys.trainingfx.dialog.other.ChangeConfiguration;

import de.travelbasys.training.framework.Dialog;

public class ChangeConfigurationDialogGUI implements Dialog {

	private ChangeConfigurationModelGUI model;
	private ChangeConfigurationViewGUI view;
	private ChangeConfigurationControlGUI control;

	public ChangeConfigurationDialogGUI() {
		model = new ChangeConfigurationModelGUI();
		view = new ChangeConfigurationViewGUI(model);
		control = new ChangeConfigurationControlGUI();
	}

	@Override
	public void run() {
		view.init();
		control.init(model, view);
		view.run();
	}

}
