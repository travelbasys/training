package de.travelbasys.training.dialog.other.lottery;

import de.travelbasys.training.framework.Dialog;

/**
 * ist verantwortlich für das Ausgeben von Lottozahlen. Der Dialog kann durch
 * das Hauptmenü abgebrochen werden.
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
	 * Führt den Dialog aus.
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
