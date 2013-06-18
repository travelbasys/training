package experiment.datum;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComplexDateFormater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("dd.MM.yyyy");
		System.out.println(sdf.format(new Date()));

		SimpleDateFormat gerDateFormat = new SimpleDateFormat("dd.MM.yyyy");
		SimpleDateFormat isoDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		isoDateFormat.applyPattern("yyyy-MM-dd");
		System.out.println(gerDateFormat.format(new Date()));
		System.out.println(isoDateFormat.format(new Date()));
		System.out.println();
		Matcher matcher;

		String datestr = "2012-9-31";

		// Pattern gerPattern = Pattern
		// .compile("([0-2]?[0-9]|30|31)\\.([0]?[0-9]|10|11|12)\\.[0-9][0-9][0-9][0-9]");
		Pattern isoPattern = Pattern
				.compile("[0-9][0-9][0-9][0-9]\\-([0]?[0-9]|10|11|12)\\-([0-2]?[0-9]|30|31)");

		System.out.println(Locale.getDefault().getLanguage());
		matcher = isoPattern.matcher(datestr);
		System.out.println(matcher.matches());

		if (matcher.matches()) {
			System.out.println(datestr);
		}
		GregorianCalendar old = null;
		;
		old = new GregorianCalendar(1957, Calendar.JANUARY, 30);
		Date now = new Date();
		System.out.println(now.getTime() - old.getTime().getTime());
		Date b = new Date();
		System.out.println(b);
	}

}
