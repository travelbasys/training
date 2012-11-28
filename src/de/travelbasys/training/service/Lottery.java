package de.travelbasys.training.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Stellt einen Dienst zur Verfügung, welcher Lottozahlen ermittelt. Der Dienst
 * feuert Events, über seinen Fortschritt.
 * 
 * @author tba
 * 
 */

public class Lottery {

	private Set<Integer> numbers;
	List<ProgressEventListener> listeners = new ArrayList<ProgressEventListener>();
	private boolean isCancelled = false;

	/**
	 * Führt den Dienst aus.
	 */
	@SuppressWarnings("static-access")
	public void execute() {

		for (int i = 1; i <= 10; i++) {
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			fireProgressEvent(i / 10.0);
			if (isCancelled)
				return;
		}

		Random rand = new Random();
		numbers = new HashSet<Integer>();
		while (numbers.size() < 6) {
			numbers.add(rand.nextInt(49));
		}
		fireOperationFinished();
	}

	public Set<Integer> getNumbers() {
		return numbers;
	}

	/**
	 * Feuert ein Event über den Fortschritt des Dienstes. Die aktuelle
	 * Implementierung ruft dazu eine weitere Dienstklasse auf, die Fortschritt
	 * Events behandeln kann.
	 * 
	 * @param percent
	 *            Die Angabe des Fortschritts in Prozent.
	 */
	private void fireProgressEvent(double percent) {
		ProgressEvent pe = new ProgressEvent(this, percent);
		for (ProgressEventListener listener : listeners) {
			listener.handleProgressEvent(pe);
			if (pe.isCancelled()) {
				isCancelled = true;
			}
		}
	}

	/**
	 * Feuert ein Event über den Abschluss des Dienstes. Die aktuelle
	 * Implementierung ruft dazu eine Liste gegebener Listener auf, die Fortschritt
	 * Events behandeln können.
	 */
	private void fireOperationFinished() {
		ProgressEvent pe = new ProgressEvent(this);
		for (ProgressEventListener listener : listeners) {
			listener.handleOperationFinished(pe);
		}
	}
/**
 * Fügt einer Liste einen gegebenen Listener hinzu.
 * @param listener Das Listener Objekt.
 */
	public void addProgressListener(ProgressEventListener listener) {
		listeners.add(listener);
	}
}
