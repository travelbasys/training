package experiment.datum;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ComplexDateFormater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("dd.MM.yyyy");
		System.out.println(sdf.format(new Date()));
		
		
		SimpleDateFormat gerDateFormat = new SimpleDateFormat("dd.MM.yyyy");
		gerDateFormat.applyPattern("dd.MM.yyyy");
		SimpleDateFormat isoDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		isoDateFormat.applyPattern("yyyy-MM-dd");
		System.out.println(gerDateFormat.format(new Date()));
		System.out.println(isoDateFormat.format(new Date()));
		
	}

}
