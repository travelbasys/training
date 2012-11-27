package de.travelbasys.training.dialog.other.lottery;

import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.Console;

/**
 * Ist verantwortlich dem Benutzer ein Hauptmenü zur Verfügung zu stellen,
 * welches weitere Komponenten aufrufen kann.
 * 
 * @autor tba
 */
public class LotteryNumbersView implements View {

	private LotteryNumbersModel model;

	public LotteryNumbersView(Model model) {
		this.model = (LotteryNumbersModel) model;
	}

	public void run() {
		for (String s : model) {
			Console.println(s);
		}
	}
}
