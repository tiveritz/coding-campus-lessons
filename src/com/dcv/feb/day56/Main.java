package src.com.dcv.feb.day56;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	private final static String FILEPATH = "src/com/dcv/feb/day56/data/";

	public static void main(String[] args) {

		
		try {
			Path path = Paths.get(FILEPATH + "hello_world.txt");
			
			int i = 0;
			while (Files.exists(path)) {
				path = Paths.get(FILEPATH + "hello_world_" + i + ".txt");
				i++;
			}

			Files.write(path, "Hello World!".getBytes());

		} catch (IOException ioe) {
			System.out.println("IOException");
			ioe.printStackTrace();
		}
	}	
}
