package de.travelbasys.trainingfx.dialog.about;

import de.travelbasys.training.framework.Dialog;

/**
 * Diese Klasse repräsentiert den Dialog des About Fensters.
 * 
 * @author haut
 * 
 */
public class AboutDialogGUI implements Dialog {

	private AboutModelGUI model;
	private AboutViewGUI view;
	@SuppressWarnings("unused")
	private AboutControlGUI control;

	public AboutDialogGUI() {
		model = new AboutModelGUI();
		view = new AboutViewGUI(model);
		control = new AboutControlGUI(model);
	}

	@Override
	public void run() {
		view.init();
		view.run();
	}

}