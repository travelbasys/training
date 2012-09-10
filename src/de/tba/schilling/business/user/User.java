package de.tba.schilling.business.user;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User implements Serializable {
	private static final long serialVersionUID = -6220647225821300304L;
	public String name;
	public String dobDay;
	public String dobMonth;
	public String dobYear;
	
	public int getAge() {
		int age = 0;
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date parsedDate;
			parsedDate = (Date) formatter.parse(dobYear + "-" + dobMonth + "-" +  dobDay);

			GregorianCalendar cal = new GregorianCalendar();
			int y, m, d;

			y = cal.get(Calendar.YEAR);
			m = cal.get(Calendar.MONTH);
			d = cal.get(Calendar.DAY_OF_MONTH);
			cal.setTime(parsedDate);
			age = y - cal.get(Calendar.YEAR);
			if ((m < cal.get(Calendar.MONTH))
					|| ((m == cal.get(Calendar.MONTH)) && (d < cal
							.get(Calendar.DAY_OF_MONTH)))) {
				--age;
			}
			if (age < 0)
				throw new IllegalArgumentException("Age < 0");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return age;
	}

	/*
	 * Static function to parse a user from a String that is build like:
	 * User [field=value, field=value, ...]
	 * 
	 * The function prepares the string to be split in it's name-value pairs
	 * to assign values to the correct field from class instance.
	 */
	public static User parse(String s) {
		// Create new instance of 'User'
		User user = new User();
		String values = "";
		
		// Extract string between []
		Pattern p = Pattern.compile("\\[(.*?)\\]");
		Matcher m = p.matcher(s);
		if (m.find())
			values = m.group(1);

		// Split the string at commas (,) to get the name-value pairs
		String[] tmp = values.split(",");

		// Iterate over string array contains name-value pairs (name=value)
		for (String var : tmp) {
			// Use trim to replace leading and ending whitespace
			var = var.trim();
			// Split name-value pair to separate name and value into array
			String[] value = var.split("=");
			try {
				// Get the field by name of class User
				Field field = user.getClass().getField(value[0]);
				// Get type of field to assign by using correct Modifiers
				Type type = field.getGenericType();
				// Check which type to use to assign Value
				if (type.equals(Integer.TYPE)) {
					field.set(user, new Integer(value[1]));
				} else if (type.equals(Float.TYPE)) {
					field.set(user, new Float(value[1]));
				} else if (type.equals(Double.TYPE)) {
					field.set(user, new Double(value[1]));
				} else if (type.equals(String.class)) {
					field.set(user, new String(value[1]));
				}
			} catch (Exception e) {
				System.out.println("Field '" + value[0] + "' doesn't exists!");
			}

		}
		return user;
	}

	public String toString() {
		String user = "class User {\n";
		String temp = "\t %s %s \t %s \t : %s \n";
		Field[] fields = this.getClass().getFields();
		for (Field field : fields) {
			try {
				String mod = Modifier.toString(field.getModifiers());
				String typ = field.getType().toString().replace("class java.lang.", "");;
				String nme = field.getName();
				String val = field.get(this).toString();
				user += String.format(temp, mod, typ, nme, val);
			} catch (Exception e) {
				// e.printStackTrace();
			}
		}
		user += "}\n";
		return user;
	}
}