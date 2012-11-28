package de.travelbasys.training.service;

import java.util.EventObject;

/**
 * Repräsentiert ein Fortschrittsobjekt (Event), dessen aktuelle Implementierung
 * den Ursprung des Aufrufes & den Fortschritt in Form einer Pronzentzahl
 * (Gleitkommazahl 0-1) enthält.
 * 
 * @author tba
 * 
 */
public class ProgressEvent extends EventObject {

	private static final long serialVersionUID = 1L;
	private double percent;
	private boolean isCancelled;

	/**
	 * Initialisiert das Objekt mit dem Ursprungsaufruf.
	 * 
	 * @param source
	 *            Ursprungsobjekt, dass diese Funktion aufgerufen hat.
	 */

	public ProgressEvent(Object source) {
		super(source);
	}

	/**
	 * Initialisiert das Objekt mit dem Ursprungsaufruf & der Prozentangabe.
	 * 
	 * @param source
	 *            Ursprungsobjekt, dass diese Funktion aufgerufen hat.
	 * @param percent
	 *            Prozentangabe des Fortschritts (Gleitkommazahl 0-1).
	 */
	public ProgressEvent(Object source, double percent) {
		super(source);
		this.percent = percent;
	}

	public double getPercent() {
		return percent;
	}

	public void setCancelled(boolean b) {
		this.isCancelled = b;
	}

	public boolean isCancelled() {
		return this.isCancelled;
	}

}
