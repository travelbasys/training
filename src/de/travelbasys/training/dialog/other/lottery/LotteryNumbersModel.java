package de.travelbasys.training.dialog.other.lottery;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import de.travelbasys.training.framework.Model;
import de.travelbasys.training.util.AppContext;

/**
 * hat die Aufgabe, ein Model für den LotteryNumbersDialog zu verwalten.
 * 
 * Die aktuelle Implementierung enthält alle Daten um Prozentwerte (Den
 * Anwendungsfortschritt) und (Die Lottozahlen) ein Set von Ganzzahlen zu
 * speichern. Außerdem stellt das Model eine ArrayList zur Verfügung, in der
 * Strings hinzugefügt werden.
 */

public class LotteryNumbersModel extends ArrayList<String> implements Model {

	private static final long serialVersionUID = 1L;

	private Set<Integer> numbers = new HashSet<Integer>();

	private double percent;

	public LotteryNumbersModel() {
		add(AppContext.getMessage("LotteryNumbersStart"));
	}

	public void setNumbers(Set<Integer> numbers) {
		this.numbers = numbers;
	}

	public Set<Integer> getNumbers() {
		return numbers;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	public double getPercent() {
		return percent;
	}

}
