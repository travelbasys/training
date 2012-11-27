package de.travelbasys.training.service;

public interface ProgressEventListener {
	public void handleProgressEvent(ProgressEvent pe);
	public void handleOperationFinished(ProgressEvent pe);
}
