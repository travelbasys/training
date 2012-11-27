package de.travelbasys.training.dialog.other.lottery;

import de.travelbasys.training.framework.Dialog;

public class LotteryNumbersDialog implements Dialog {

	private LotteryNumbersModel model;
	private LotteryNumbersView view;
	private LotteryNumbersControl control;

	public LotteryNumbersDialog() {
		model = new LotteryNumbersModel();
		view = new LotteryNumbersView(model);
		control = new LotteryNumbersControl(model, view);

	}

	@Override
	public void run() {
		view.run();
		control.execute();
	}

	public void cancel() {
		control.cancel();
	}
}
