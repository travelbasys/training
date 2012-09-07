package de.travelbasys.training.userlist;

import java.io.BufferedReader;
import java.io.FileReader;

import de.travelbasys.training2.User;

public class UserList {

	public static void main(String[] args) {
		
		try {
			FileReader fr = new FileReader("HelloWorld.txt");
			BufferedReader br = new BufferedReader(fr);
			String s;
			while ((s = br.readLine()) != null) {
				User user = User.parse(s);
				System.out.println(user);
			}
			fr.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
