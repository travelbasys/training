package de.travelbasys.training.dialog.other.lottery;

import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.service.Lottery;
import de.travelbasys.training.service.ProgressEvent;
import de.travelbasys.training.service.ProgressEventListener;

/**
 * Diese Klasse Kontrolliert Benutzereingaben.
 * 
 * @author tba
 * 
 */
public class LotteryNumbersControl implements ProgressEventListener {

	private LotteryNumbersModel model;
	private LotteryNumbersView view;

	/**
	 * @param model
	 * @param view
	 */
	public LotteryNumbersControl(Model model, View view) {
		this.model = (LotteryNumbersModel) model;
		this.view = (LotteryNumbersView) view;
	}

	public void execute() {
		Lottery service = new Lottery();
		service.addProgressListener(this);
		service.execute();
		model.setNumbers(service.getNumbers());
	}

	@Override
	public void handleProgressEvent(ProgressEvent pe) {
		model.setPercent(pe.getPercent());
		view.showProgress();
	}

}
