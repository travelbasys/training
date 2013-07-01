package experiment.fillDB;

import java.util.Calendar;
import java.util.GregorianCalendar;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.CustomerDaoException;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.util.CommandLine;
import de.travelbasys.training.util.Configuration;
import de.travelbasys.training.util.Datum;

public class FillDB {

	private static int anz = 99999;
	private static double millis = 0;

	public static void main(String[] args) {

		Configuration.init(CommandLine.getOptions());
		Dao.setDAO(3);
		Dao.getDAO().init((String) Configuration.get("db"));

		Calendar cal1 = new GregorianCalendar();
		for (int i = 0; i < anz; i++) {
			try {
				int dummyId = 0;
				Customer customer = new Customer(dummyId, "Test" + i, "Test"
						+ i, Datum.getFormattedDate("01.01.1970"), "Test" + i,
						"44444", "Test" + i);
				Dao.getDAO().create(customer);
				System.out.println(i);
			} catch (CustomerDaoException e) {
				e.printcustomererr();
			}
		}
		Dao.getDAO().terminate();

		Calendar cal2 = new GregorianCalendar();
		millis = cal2.getTimeInMillis() - cal1.getTimeInMillis();
		System.out.println("Process took " + (millis / 1000) + " seconds.");
		System.out.println("Those equal " + ((millis / 1000) / 60)
				+ " minutes.");
	}

}
