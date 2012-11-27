package de.travelbasys.training.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Lottery {

	private Set<Integer> numbers;
	List<ProgressEventListener> listeners = new ArrayList<ProgressEventListener>();
	private boolean isCancelled = false;

	@SuppressWarnings("static-access")
	public void execute() {

		for (int i = 1; i <= 10; i++) {
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			fireProgressEvent(i / 10.0);
			if( isCancelled ) return;
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

	private void fireProgressEvent(double percent) {
		ProgressEvent pe = new ProgressEvent(this, percent);
		for (ProgressEventListener listener: listeners ) {
			listener.handleProgressEvent(pe);
			if( pe.isCancelled() ){
				isCancelled = true;
			}
		}
	}

	private void fireOperationFinished() {
		ProgressEvent pe = new ProgressEvent(this);
		for (ProgressEventListener listener: listeners ) {
			listener.handleOperationFinished(pe);
		}
	}

	public void addProgressListener(ProgressEventListener listener) {
		listeners.add(listener);
	}
}
