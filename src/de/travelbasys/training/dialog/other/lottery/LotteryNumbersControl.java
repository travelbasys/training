package de.travelbasys.training.dialog.other.lottery;

import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.Console;

/**
 * Diese Klasse Kontrolliert Benutzereingaben.
 * 
 * @author tba
 * 
 */
public class LotteryNumbersControl {

	@SuppressWarnings("unused")
	private LotteryNumbersModel model;
	@SuppressWarnings("unused")
	private LotteryNumbersView view;
	Thread thread = null;

	/**
	 * 
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
				for (int i = 1; i <= 10; i++) {
					actionperform(i);
				}
			}
		};
		thread.start();
		try {
			thread.join();
			return;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void actionperform(int wert) {
		wert = (wert * 10);
		Console.println(wert + "%");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
