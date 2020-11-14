package src.com.own.nov.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CDatabase {

	String db_path;
	String db_name;

	public CDatabase(String db_path, String db_name) {
		this.db_path = db_path;
		this.db_name = db_name;
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
			connection = DriverManager.getConnection("jdbc:sqlite:" + db_path + db_name);
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(10);

			switch (state) {
				case 1:
					statement.executeUpdate(sqlStatement);
					break;
				case 2:
					rs = statement.executeQuery("SELECT * FROM people");
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
