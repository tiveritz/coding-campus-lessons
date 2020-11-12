package src.com.own.nov;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Code05 {
    public static void sqliteDatabase() {
        
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:src/com/own/nov/db/sqlite.db");
			Statement statement = connection.createStatement();
			dbPlayground(statement);
			statement.setQueryTimeout(10);

			printResults(statement);

		} catch (SQLException sqlE) {
			System.err.println(sqlE.getMessage());
		} finally {
			try {
				if (connection != null) connection.close();
			} catch(SQLException sqlE) {
				System.err.println(sqlE.getMessage());
			}
		}
	}

	public static void dbPlayground(Statement statement) throws SQLException {
		statement.executeUpdate(
			"CREATE TABLE IF NOT EXISTS people (" + 
			"id INTEGER PRIMARY KEY AUTOINCREMENT, " +
			"name 		STRING		NOT NULL, " +
			"age 		INTEGER		NOT NULL)"
			);

		statement.executeUpdate("INSERT INTO PEOPLE (name, age) VALUES ('ignatz', 22)");
	}

	public static void printResults(Statement statement) throws SQLException {
		ResultSet rs = statement.executeQuery("SELECT * FROM people");

		while (rs.next()) {
			System.out.println("name = " + rs.getString("name") + rs.getInt("age"));
		}
	}
}
