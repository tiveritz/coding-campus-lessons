package src.com.dcv.mar.day58.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CDatabase {
	String db_address;
	String db_name;
	String db_user;
	String db_pass;

	public CDatabase(String db_address, String db_name, String db_user, String db_pass) {
		// Database connection data
		this.db_address = db_address;
		this.db_name = db_name;
		this.db_user = db_user;
		this.db_pass = db_pass;

		// call dbDriver without query to test database connection. Any error in the connection
		// data or improperly configured database will immediately throw errors
		dbDriver();
	}

	public void query(String sqlStatement) {
		dbDriver(sqlStatement, 1);
	}

	public void printResults(String sqlStatement) {
		dbDriver(sqlStatement, 2);
	}

	private void dbDriver() {
		dbDriver("", 0);
	}

	

	private void dbDriver(String sqlStatement, int state) {
		ResultSet rs = null;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://" + db_address + "/" + db_name, db_user, db_pass); 
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(10);

			switch (state) {
				case 1:
					statement.executeUpdate(sqlStatement);
					break;
				case 2:
					rs = statement.executeQuery(sqlStatement);
					while (rs.next()) {
						System.out.println("name: " + rs.getString("name") + ", age: " + rs.getInt("age"));
					}
					break;
			}

		} catch (SQLException sqlE) {
			System.err.println(sqlE.getMessage());
		} finally {
			try {
				if (connection != null) connection.close();
			} catch (SQLException sqlE) {
				System.err.println(sqlE.getMessage());
			}
		}
	}
}
