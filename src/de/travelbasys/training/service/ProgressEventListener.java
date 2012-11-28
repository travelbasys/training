package de.travelbasys.training.service;

/**
 * Stellt ein Interface f�r die Events Fortschritt & Abschluss des Programm
 * bereit.
 * 
 * @author tba
 * 
 */
public interface ProgressEventListener {
	public void handleProgressEvent(ProgressEvent pe);

	public void handleOperationFinished(ProgressEvent pe);
}
