package de.travelbasys.training.dialog.other.lottery;

import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.service.Lottery;
import de.travelbasys.training.service.ProgressEvent;
import de.travelbasys.training.service.ProgressEventListener;

/**
 * hat die Aufgabe einen Dienst aufzurufen, der Lottozahlen ermittelt & einen
 * View innerhalb des LotteryNumberDialoges zu steuern.
 * 
 * Die aktuelle Implementierung startet einen neuen Thread, die mit
 * Dienstklassen eines anderes Packages arbeitet. Unser Controller implementiert
 * ein ProgressEventListener Interface, und überschreibt dessen
 * Listener-Methoden. (Der Controller lauscht, ob eine Dienstklasse ein Event
 * abgefeuert hat.)
 * 
 * @author tba
 * 
 */

public class LotteryNumbersControl implements ProgressEventListener {

	private LotteryNumbersModel model;
	private LotteryNumbersView view;
	private Thread thread;
	private boolean isCancelled = false;

	/**
	 * Initialisiert den Controller mit Model und View des Packages.
	 * 
	 * @param model
	 *            Das Model.
	 * @param view
	 *            Der View.
	 */
	public LotteryNumbersControl(Model model, View view) {
		this.model = (LotteryNumbersModel) model;
		this.view = (LotteryNumbersView) view;
	}

	/**
	 * Ist dafür zuständig einen neuen Thread zu starten, in dem der
	 * Lotto-Dienst ausgeführt wird.
	 */
	public void execute() {
		thread = new Thread() {
			public void run() {
				Lottery service = new Lottery();
				service.addProgressListener(LotteryNumbersControl.this);
				service.execute();
			}
		};
		thread.start();
	}

	/**
	 * Ist dafür zuständig das gefeuerte Fortschritts-Event zu behandeln. Die
	 * aktuelle Implementierung ruft einen View, der den Fortschritt anzeigt.
	 */
	@Override
	public void handleProgressEvent(ProgressEvent pe) {
		model.setPercent(pe.getPercent());
		if (!isCancelled) {
			view.showProgress();
		} else {
			pe.setCancelled(true);
		}
	}

	/**
	 * Ist dafür zuständig Operationen auszuführen, nachdem unser Dienst
	 * durchgelaufen ist.
	 */
	@Override
	public void handleOperationFinished(ProgressEvent pe) {
		Lottery service = (Lottery) pe.getSource();
		model.setNumbers(service.getNumbers());
		view.showResult();
	}

	/**
	 * hat die Aufgabe einen Wert zu verändern, der bestimmt, ob die Anwendung
	 * noch weiterläuft.
	 */
	public void cancel() {
		this.isCancelled = true;
	}

}
