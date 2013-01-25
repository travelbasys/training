package experiment.mysqltest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

/*
 create database feedback;
 use feedback;
 CREATE USER sqluser IDENTIFIED BY 'sqluserpw'; 
 grant usage on *.* to sqluser@localhost identified by 'sqluserpw'; 
 grant all privileges on feedback.* to sqluser@localhost;

 CREATE TABLE COMMENTS (id INT NOT NULL AUTO_INCREMENT, 
 MYUSER VARCHAR(30) NOT NULL,
 EMAIL VARCHAR(30), 
 WEBPAGE VARCHAR(100) NOT NULL, 
 DATUM DATE NOT NULL, 
 SUMMERY VARCHAR(40) NOT NULL,
 COMMENTS VARCHAR(400) NOT NULL,
 PRIMARY KEY (ID));

 INSERT INTO COMMENTS values (default, 'lars', 'myemail@gmail.com','http://www.myWeb.com', '2009-09-14 10:33:11', 'Summery','My first comment'); 
 */
public class MySQLAccess {
	Scanner scan = new Scanner(System.in);
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public static void main(String[] args) throws Exception {
		MySQLAccess dao = new MySQLAccess();

		dao.readDataBase();
	}

	// @SuppressWarnings("deprecation")
	public void readDataBase() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost:8080/feedback?"
							+ "user=sqluser&password=sqluserpw");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement
					.executeQuery("select * from FEEDBACK.COMMENTS");
			writeResultSet(resultSet);

			// PreparedStatements can use variables and are more efficient
			preparedStatement = connect
					.prepareStatement("insert into  FEEDBACK.COMMENTS values (default, ?, ?, ?, ? , ?, ?)");
			// "myuser, webpage, datum, summery, COMMENTS from FEEDBACK.COMMENTS");
			// Parameters start with 1
			// 0 = id = default (Autowert)
			// 1 = Name
			// 2 = Email
			// 3 = Webpage
			// 4 = Datum
			// 5 = Text
			// 6 = Text
			String[] input = new String[6];
			String[] prompt = { "Name", "Email", "Webpage", "Summary",
					"Comment" };
			for (int i = 0; i < prompt.length; i++) {
				System.out.println("Please insert " + prompt[i] + " :");
				input[i] = scan.nextLine();
			}
			preparedStatement.setString(1, input[0]);
			preparedStatement.setString(2, input[1]);
			preparedStatement.setString(3, input[2]);
			preparedStatement.setDate(4,
					new java.sql.Date(new Date().getTime()));
			preparedStatement.setString(5, input[3]);
			preparedStatement.setString(6, input[4]);
			preparedStatement.executeUpdate();

			preparedStatement = connect
					.prepareStatement("SELECT myuser, webpage, datum, summery, COMMENTS from FEEDBACK.COMMENTS");
			resultSet = preparedStatement.executeQuery();
			writeResultSet(resultSet);

			// Remove again the insert comment

			resultSet = statement
					.executeQuery("select * from FEEDBACK.COMMENTS");
			writeMetaData(resultSet);

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}

	private void writeMetaData(ResultSet resultSet) throws SQLException {
		// Now get some metadata from the database
		// Result set get the result of the SQL query

		System.out.println("The columns in the table are: ");

		System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
		for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
			System.out.println("Column " + i + " "
					+ resultSet.getMetaData().getColumnName(i));
		}
	}

	private void writeResultSet(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set
		while (resultSet.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g. resultSet.getSTring(2);
			String user = resultSet.getString("myuser");
			String website = resultSet.getString("webpage");
			String summery = resultSet.getString("summery");
			Date date = resultSet.getDate("datum");
			String comment = resultSet.getString("comments");
			System.out.println("User: " + user);
			System.out.println("Website: " + website);
			System.out.println("Summery: " + summery);
			System.out.println("Date: " + date);
			System.out.println("Comment: " + comment);
		}
	}

	// You need to close the resultSet
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

}