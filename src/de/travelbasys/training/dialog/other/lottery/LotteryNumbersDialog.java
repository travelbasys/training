package de.travelbasys.training.dialog.other.lottery;

import de.travelbasys.training.framework.Dialog;

/**
 * ist verantwortlich f�r das Ausgeben von Lottozahlen. Der Dialog kann durch
 * das Hauptmen� abgebrochen werden.
 * 
 */

public class LotteryNumbersDialog implements Dialog {

	private LotteryNumbersModel model;
	private LotteryNumbersView view;
	private LotteryNumbersControl control;

	public LotteryNumbersDialog() {
		model = new LotteryNumbersModel();
		view = new LotteryNumbersView(model);
		control = new LotteryNumbersControl(model, view);

	}

	/**
	 * F�hrt den Dialog aus.
	 */
	@Override
	public void run() {
		view.run();
		control.execute();
	}

	public void cancel() {
		control.cancel();
	}
}
