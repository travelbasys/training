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
	private Thread thread;
	private boolean isCancelled = false;

	/**
	 * @param model
	 * @param view
	 */
	public LotteryNumbersControl(Model model, View view) {
		this.model = (LotteryNumbersModel) model;
		this.view = (LotteryNumbersView) view;
	}

	public void execute() {
		thread = new Thread() {
			public void run() {
				Lottery service = new Lottery();
				service.addProgressListener(LotteryNumbersControl.this);
				service.execute();
			}
		};
		thread.start();
	}

	@Override
	public void handleProgressEvent(ProgressEvent pe) {
		model.setPercent(pe.getPercent());
		view.showProgress();
		if( isCancelled ){
			pe.setCancelled(true);
		}
	}

	@Override
	public void handleOperationFinished(ProgressEvent pe) {
		Lottery service = (Lottery)pe.getSource();
		model.setNumbers(service.getNumbers());
		view.showResult();
	}

	public void cancel() {
		this.isCancelled = true;
	}

}
