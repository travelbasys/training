package de.travelbasys.training.service;

import java.util.EventObject;

public class ProgressEvent extends EventObject {

	private static final long serialVersionUID = 1L;
	private double percent;
	private boolean isCancelled;

	public ProgressEvent(Object source) {
		super(source);
	}

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
