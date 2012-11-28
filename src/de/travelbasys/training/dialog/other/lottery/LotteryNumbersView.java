package de.travelbasys.training.dialog.other.lottery;

import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.Console;

/**
 * Ist verantwortlich dafür etwas visuell auf dem Bildschirm darzustellen, um
 * den Benutzer ggf. zu informieren.
 * 
 * @autor tba
 */
public class LotteryNumbersView implements View {

	private LotteryNumbersModel model;

	/**
	 * * Initialisiert den aktuellen View. Speichert das gegebene Model Objekt.
	 */
	public LotteryNumbersView(Model model) {
		this.model = (LotteryNumbersModel) model;
	}

	/**
	 * Ausgabe von im Model abgelegten Strings.
	 */
	public void run() {
		for (String s : model) {
			Console.println(s);
		}
	}

	/**
	 * Zeigt eine Prozentzahl aus dem Model an.
	 */
	public void showProgress() {
		System.out.println((model.getPercent() * 100) + "%");
	}

	/**
	 * Zeigt ein Array von Zahlen aus dem Model an.
	 */
	public void showResult() {
		System.out.println(model.getNumbers());
	}
}
