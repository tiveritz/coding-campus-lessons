package src.com.own.nov;

import src.com.own.nov.db.CDatabase;


public class Code05 {

	public static void sqliteDatabase() {
		final String DB_PATH = "src/com/own/nov/db/";
		final String DB_NAME = "sqlite.db";

		CDatabase db = new CDatabase(DB_PATH, DB_NAME);

		db.query("DROP TABLE IF EXISTS people"); // To clear table for the following example

		db.query(
			"CREATE TABLE IF NOT EXISTS people (" + 
			"id INTEGER PRIMARY KEY AUTOINCREMENT, " +
			"name 		STRING		NOT NULL, " +
			"age 		INTEGER		NOT NULL)"
			);
		
		db.query("INSERT INTO PEOPLE (name, age) VALUES ('ignatz', 24)");
		db.query("INSERT INTO PEOPLE (name, age) VALUES ('rudi', 36)");
		db.query("INSERT INTO PEOPLE (name, age) VALUES ('michael', 52)");
		db.query("INSERT INTO PEOPLE (name, age) VALUES ('kate', 26)");
		db.printResults("SELECT * FROM people"); //ToDo: convert to getResults with return value
	}
}
