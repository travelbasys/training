package de.travelbasys.training.userlist;

import java.io.BufferedReader;
import java.io.FileReader;

public class UserList {

	public static void main(String[] args) {

		try {
			FileReader fr = new FileReader("HelloWorld.txt");
			BufferedReader br = new BufferedReader(fr);
			String s;
			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}
			fr.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
