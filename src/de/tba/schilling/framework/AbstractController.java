package de.tba.schilling.framework;

public abstract class AbstractController implements Controller {

	protected Model	model;
	protected View	view;

	public void init() {
		view.init();
	}

	public void start() {
		view.start();
	}

	public void stop() {
		view.stop();
	}

	public void destroy() {
		view.destroy();
	}
}
