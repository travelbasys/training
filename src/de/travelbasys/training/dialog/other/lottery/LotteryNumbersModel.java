package de.travelbasys.training.dialog.other.lottery;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import de.travelbasys.training.framework.Model;
import de.travelbasys.training.util.AppContext;

/**
 * hat die Aufgabe, ein Model f�r den LotteryNumbersDialog zu verwalten.
 * 
 * Die aktuelle Implementierung enth�lt alle Daten um Prozentwerte (Den
 * Anwendungsfortschritt) und (Die Lottozahlen) ein Set von Ganzzahlen zu
 * speichern. Au�erdem stellt das Model eine ArrayList zur Verf�gung, in der
 * Strings hinzugef�gt werden.
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
