package src.com.dcv.feb.day56;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {

		// -- Read testfiles with various encodings ---------------------------
		// example1();
	
		// -- Read the config files and clean the data ------------------------
		example2();
	}

	public static void example1() {
		BufferedReader reader = Reader.readFile();
		// BufferedReader reader = Reader.readFile("ISO-8859-2"); // testfile_3 ist speziell codiert
		printToConsole(reader);
	}

	public static void example2() {
		BufferedReader reader = Reader.readFile();
		HashMap<String, String> configuration = parseConfigFile(reader);

		System.out.println(configuration.toString());
	}
	
	public static void printToConsole(BufferedReader reader) {
		try {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("LOL");
		}
	}

	public static HashMap<String, String> parseConfigFile(BufferedReader reader) {
		HashMap<String, String> parsed = new HashMap<>();

		try {
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (line.startsWith(";") || line.trim().equals("")) {
					continue;
				}

				String[] content = line.replaceAll("\\s+","").split("=");

				try {
					parsed.put(content[0], content[1]);
				} catch (IndexOutOfBoundsException ioobe) {
					parsed.put(content[0], "");
				}
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("LOL");
		}

		return parsed;
	}
}
