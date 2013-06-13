package de.travelbasys.training.framework;

public interface Formatter {

	public static final Formatter NULL = new Formatter() {
		public Object parse(String s) {
			return s;
		}
	};
	Object parse(String nextLine) throws Exception;
}
