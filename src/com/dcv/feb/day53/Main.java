package src.com.dcv.feb.day53;

import java.util.Scanner;

public class Main {
	public static void main (String[] args) {

		Logger logger = Logger.getInstance();
		Scanner userInput = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Enter a new Password\n" + 
						   "- more than 8 characters\n" +
						   "- shorter than 10 characters\n" +
						   "- has a % sign included\n" +
						   "- has the number 42 included");
	
		boolean passwordIsValid = false;
		String password = "";

		while (!passwordIsValid) {
			password = userInput.nextLine();  // Read user input
			int passwordLength = password.length();
			if (passwordLength <= 8) {
				logger.log(LogType.ERROR, "password too short (" + passwordLength + ")");
			} else if (passwordLength >= 10) {
				logger.log(LogType.ERROR, "password too long (" + passwordLength + ")");
			} else if (!password.contains("%")) {
				logger.log(LogType.WARNING, "the % sign is missing");
			} else if (!password.contains("42")) {
				logger.log(LogType.INFO, "answer to live the universe and everything is missing");
			}
			else {
				passwordIsValid = true;
			}
		}

		System.out.println("Congratulations, your new password is: " + password);

		userInput.close();
	}
}