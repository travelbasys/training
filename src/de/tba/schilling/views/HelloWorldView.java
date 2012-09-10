package de.tba.schilling.views;

import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import de.tba.schilling.business.user.UserList;
import de.tba.schilling.framework.AbstractView;

public class HelloWorldView extends AbstractView {
	private static final long serialVersionUID = -785191775146724350L;
	public static final String NAME = "Hello World Application";
	public static final String TITLE = "Hello World";

	public JLabel nameLabel;
	public JTextField nameField;

	public JLabel dobLabel;
	public JComboBox<String> dobDayComboBox;
	public JComboBox<String> dobMonthComboBox;
	public JComboBox<String> dobYearComboBox;

	public JButton addButton;

	public JComboBox<String> userComboBox;
	
	public JButton delButton;

	public void init() {
		super.init();
		this.setName(NAME);
		this.setTitle(TITLE);
		this.centerFrame();

		nameLabel = new JLabel("Name:");
		this.addComponent(nameLabel, 1, 1, 1, 1);

		nameField = new JTextField();
		this.addComponent(nameField, 2, 1, 3, 1);

		dobLabel = new JLabel("Date of birth:");
		this.addComponent(dobLabel, 1, 2, 1, 1);

		String[] tmpDays = new String[31];
		for (int i = 1; i <= 31; i++)
			tmpDays[i - 1] = (i < 10) ? "0" + String.valueOf(i) : String
					.valueOf(i);

		dobDayComboBox = new JComboBox<String>(tmpDays);
		this.addComponent(dobDayComboBox, 2, 2, 1, 1);

		String[] tmpMonth = new String[12];
		for (int i = 1; i <= 12; i++)
			tmpMonth[i - 1] = (i < 10) ? "0" + String.valueOf(i) : String
					.valueOf(i);

		dobMonthComboBox = new JComboBox<String>(tmpMonth);
		this.addComponent(dobMonthComboBox, 3, 2, 1, 1);

		String[] tmpYears = new String[100];
		int currYear = Calendar.getInstance().get(Calendar.YEAR);
		int start = currYear - tmpYears.length + 1;
		for (int i = start; i <= currYear; i++)
			tmpYears[i - start] = String.valueOf(i);

		dobYearComboBox = new JComboBox<String>(tmpYears);
		this.addComponent(dobYearComboBox, 4, 2, 1, 1);

		addButton = new JButton("Save");
		this.addComponent(addButton, 1, 3, 4, 1);

		userComboBox = new JComboBox<String>();
		this.addComponent(userComboBox, 1, 4, 3, 1);
		
		delButton = new JButton("Delete");
		this.addComponent(delButton, 4, 4, 1, 1);
	}

	public void updateUserComboBox(UserList userList) {
		if (userList != null) {
			String dataSource[] = new String[userList.size()];

			for (int i = 0; i < dataSource.length; i++) {
				int j = i+1;
				String index = (String) ((j<10)?((j<100)?"00"+j:"0"+j):j);
				dataSource[i] = index + ": Name" + userList.get(i).name + ", Age: " + userList.get(i).getAge();
			}

			this.stop();
			this.remove(userComboBox);
			userComboBox = new JComboBox<String>(dataSource);
			this.addComponent(userComboBox, 1, 4, 3, 1);
			this.start();
		}
	}
}
