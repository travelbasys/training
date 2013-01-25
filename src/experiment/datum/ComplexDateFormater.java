package experiment.datum;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

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
		System.out.println();
		int a,b,c;
		a= 2013;
		b= 12;
		c= 1;
		Date date = new GregorianCalendar(a,b-1,c).getTime();
		System.out.println(gerDateFormat.format(date));
	}

}
