package src.com.dcv.feb.day53;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
	private final String PATH = "src/com/dcv/feb/day53/";
	private static Logger instance;
	private FileWriter log;

	private Logger() {};

	public static Logger getInstance () {
		if (Logger.instance == null) {
		  Logger.instance = new Logger ();
		}
		return Logger.instance;
	  }

	public void log(LogType logType, String message) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm:ss");
		String logDateTime = dtf.format(LocalDateTime.now());

		String logMessage = logDateTime + " - " + logType.getCode() + " - " + message;

		System.out.println(logMessage);

		try {
			log = new FileWriter(PATH + "log.txt", true);
			log.write(logMessage + "\n");
			log.close();
		} catch (IOException ioe) {
			System.out.println("IOException");
		}
	}
}
