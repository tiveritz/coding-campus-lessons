package src.com.dcv.feb.day56;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileWriterAppend {
	private final static String FILEPATH = "src/com/dcv/feb/day56/data/";

	public static void main(String[] args) {

		
		try {
			Path path = Paths.get(FILEPATH + "hello_world.txt");
			
			if (Files.exists(path)) {
				Files.write(path, "Hello World!\n".getBytes(), StandardOpenOption.APPEND);

			} else {
				Files.write(path, "Hello World!\n".getBytes());
			}

		} catch (IOException ioe) {
			System.out.println("IOException");
			ioe.printStackTrace();
		}
	}	
}
