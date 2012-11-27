package de.travelbasys.training.dialog.other.lottery;

import de.travelbasys.training.framework.Dialog;

public class LotteryNumbersDialog implements Dialog {

	private LotteryNumbersModel model;
	private LotteryNumbersView view;
	private LotteryNumbersControl control;
	private Thread thread;

	public LotteryNumbersDialog() {
		model = new LotteryNumbersModel();
		view = new LotteryNumbersView(model);
		control = new LotteryNumbersControl(model, view);

		thread = new Thread() {
			public void run() {
				control.execute();
				view.showResult();
			}
		};
	}

	@Override
	public void run() {
		view.run();
		thread.start();
	}
}
