package de.tba.schilling.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import de.tba.schilling.business.user.User;
import de.tba.schilling.business.user.UserList;
import de.tba.schilling.framework.AbstractController;
import de.tba.schilling.framework.AnonymousClass;
import de.tba.schilling.models.HelloWorldModel;
import de.tba.schilling.views.HelloWorldView;

public class HelloWorldController extends AbstractController {
	private HelloWorldModel model;
	private HelloWorldView view;
	private UserList userList;

	private static final String FILENAME = "Users.user";

	public HelloWorldController() {
		super.model = model = new HelloWorldModel();
		super.view = view = new HelloWorldView();
	}

	public void init() {
		super.init();

		readUserList();
		if (userList == null)
			userList = new UserList();

		model.setStr("dobDay", (String) view.dobDayComboBox.getSelectedItem());
		model.setStr("dobMonth",
				(String) view.dobMonthComboBox.getSelectedItem());
		model.setStr("dobYear", (String) view.dobYearComboBox.getSelectedItem());

		view.nameField.addKeyListener(new AnonymousClass() {
			public void keyReleased(KeyEvent e) {
				model.setStr("name", view.nameField.getText());
			}
		});

		view.dobDayComboBox.addActionListener(new AnonymousClass() {
			public void actionPerformed(ActionEvent e) {
				model.setStr("dobDay",
						(String) view.dobDayComboBox.getSelectedItem());
			}
		});

		view.dobMonthComboBox.addActionListener(new AnonymousClass() {
			public void actionPerformed(ActionEvent e) {
				model.setStr("dobMonth",
						(String) view.dobMonthComboBox.getSelectedItem());
			}
		});

		view.dobYearComboBox.addActionListener(new AnonymousClass() {
			public void actionPerformed(ActionEvent e) {
				model.setStr("dobYear",
						(String) view.dobYearComboBox.getSelectedItem());
			}
		});

		view.addButton.addActionListener(new AnonymousClass() {
			public void actionPerformed(ActionEvent e) {
				User user = new User();
				user.name = model.getStr("name");
				user.dobDay = model.getStr("dobDay");
				user.dobMonth = model.getStr("dobMonth");
				user.dobYear = model.getStr("dobYear");
				if (user.getAge() < 0) {
					JOptionPane.showMessageDialog(view, "Invalid date of birth!");
				} else {
					userList.add(user);
					writeUserList();
				}
			}
		});

		view.delButton.addActionListener(new AnonymousClass() {
			public void actionPerformed(ActionEvent e) {
				int index = view.userComboBox.getSelectedIndex();
				int choice = JOptionPane.showConfirmDialog(
						view,
						"Do you really want to delete user\n" + "\""
								+ userList.get(index).name + "\" ?");
				if (choice == 0) {
					userList.remove(index);
					writeUserList();
				}
			}
		});
	}

	private void writeUserList() {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(FILENAME);
			out = new ObjectOutputStream(fos);
			out.writeObject(userList);
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		view.updateUserComboBox(userList);
	}

	private void readUserList() {
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(FILENAME);
			in = new ObjectInputStream(fis);
			userList = (UserList) in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		view.updateUserComboBox(userList);
	}
}
