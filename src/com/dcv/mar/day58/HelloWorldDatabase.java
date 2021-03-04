package src.com.dcv.mar.day58;
import src.com.dcv.mar.day58.db.CDatabase;

public class HelloWorldDatabase {

	/* Download jdbc Driver
	 *
	 * 1. Open https://dev.mysql.com/downloads/connector/j/
	 * 2. Select Operating System: Platform Independent
	 * 3. Download (e.g.: zip file)
	 * 4. Unzip file
	 * 5. Place mysql-connector-java-8.0.23.jar in your project
	 * 6. Reference library (procedure depends on your IDE)
	 * 
	 */

	public static void main(String[] args) {

		/* Define the required connection data
		 *
		 * ATTENTION: Do not use your root user and password, cause you may accidently expose this 
		 * data over gitHub. Create a new user (called "Account") with MySQL workbench and grant 
		 * rights to perform all tasks
		 * 
		 */
		final String DB_ADDRESS = "localhost:3306";
		final String DB_NAME = "coding_campus";
		final String DB_USER = "coding_campus";
		final String DB_PASS = "coding_campus_pass";

		// Create Database Object. (The construction will initially also make a database connection
		// without query, just to check if database access is OK)
		CDatabase db = new CDatabase(DB_ADDRESS, DB_NAME, DB_USER, DB_PASS);

		// db.query("DROP TABLE IF EXISTS example"); // To clear table

		// MySQL QueryValidator: https://www.eversql.com/sql-syntax-check-validator/

		db.query(
			"CREATE TABLE IF NOT EXISTS example (" +
			"id int PRIMARY KEY AUTO_INCREMENT," +
			"name varchar(100) NOT NULL," +
			"age int NOT NULL" +
			")"
			);
		
		db.query("INSERT INTO example (name, age) VALUES ('ignatz', 55)");

		db.printResults("SELECT * FROM example");

		// GO NUTS!
	}
}
