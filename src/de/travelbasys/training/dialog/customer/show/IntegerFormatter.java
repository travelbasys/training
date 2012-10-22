package de.travelbasys.training.dialog.customer.show;

public class IntegerFormatter implements Formatter {

	@Override
	public Object parse(String s) throws Exception {
		try {
			return Integer.parseInt(s);
		}
		catch(Exception e ){
			throw new NumberFormatException("IllegalNumberFormat");
		}
	}

}
