package de.travelbasys.training.dialog.customer.show;

public interface Formatter {

	public static final Formatter NULL = new Formatter(){
		public Object parse(String s){
			return s;
		}
	};

	Object parse(String nextLine) throws Exception;

}
