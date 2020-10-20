package src.com.own.oct;

// With FileWriter
import java.io.FileWriter;
import java.io.IOException;

// With FileOutputStream
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Code03 {
    public static void funWithFiles() {
        // There are various ways of handling files. Personal favourite is FileWriter
        // Take care about the Path -> double backslash \\ and for relative paths
        // use the path from your Main.java including the folder

        try {
            FileWriter file = new FileWriter("src\\com\\own\\oct\\filepath\\file01.txt");

            file.write("Hi\n");
            file.write("Whats up 💩?");
            file.close();
        } catch (IOException e) {
            System.out.println("Badly handled error");
        }
        
        
        // Working with utf-8 files. (explicitly, otherwise java wil use system default)
        // Not sure if this is required, but maybe this is helpful later...
        try {
            FileOutputStream fileStream = new FileOutputStream(new File("src\\com\\own\\oct\\filepath\\file02.txt"));
            OutputStreamWriter file = new OutputStreamWriter(fileStream, "UTF-8");
            
            file.write("Hi\n");
            file.write("Whats up 💩?");
            file.close();
        } catch (Exception e) {
            System.out.println("Badly handled error");
        }
    }
}
