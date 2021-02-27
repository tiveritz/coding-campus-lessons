package src.com.dcv.feb.day56;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Reader {
	public static BufferedReader readFile() {
		return readFile("UTF-8");
	}

	public static BufferedReader readFile(String encoding) {
		final String PATH = "src/com/dcv/feb/day56/data/";
		
		Scanner scanner = new Scanner(System.in);
		BufferedReader reader = null;

		boolean validFile = false;
		while (!validFile) {
			System.out.println("Please enter filename.");
			String userInput = scanner.nextLine().trim();

			String fullpath = PATH + userInput;

			try {
				File file = new File(fullpath);
				// FileReader fileReader = new FileReader(file);
				FileReader fileReader = new FileReader(file, Charset.forName(encoding));
				// System.out.println(Charset.forName(fileReader.getEncoding()));
				// BufferedReader bufferedReader = new BufferedReader(fileReader);
				
				/*
				String line = null;
				while ((line = bufferedReader.readLine()) != null) {
					System.out.println(line);
				}
				bufferedReader.close();
				*/
				validFile = true;
				reader = new BufferedReader(fileReader);

			} catch (FileNotFoundException fnfe) {
				System.out.println("ERROR: The filename you entered does not exist.");

			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

		scanner.close();
		return reader;
	}

	public static String input(String message) {
		System.out.println(message);

		Scanner sc = new Scanner(System.in);
		String filename = sc.nextLine().trim();
		sc.close();
		return filename;
	}
}
