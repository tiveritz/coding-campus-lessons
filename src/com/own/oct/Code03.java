package src.com.own.oct;

// With FileWriter
import java.io.FileWriter;
import java.io.IOException;

// With FileOutputStream
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;

public class Code03 {
    public static void writeFileWithFileWriter() {
        // There are various ways of handling files. Personal favourite is FileWriter
        // Take care about the Path -> double backslash \\ and for relative paths
        // use the path from your Main.java including the folder

        try {
            FileWriter file = new FileWriter("src\\com\\own\\oct\\filepath\\file01.txt");

            file.write("Hi\n");
            file.write("What's up 💩?");
            file.close();
        } catch (IOException e) {
            System.out.println("Badly handled error");
        }
    }
        public static void writeFileWithFileOutputStream() {
        // Working with utf-8 files. (explicitly, otherwise java wil use system default)
        // Not sure if this is required, but maybe this is helpful later... FileInputStream can be
        // used in a similar way for reading files
        try {
            FileOutputStream fileOutStream = new FileOutputStream(new File("src\\com\\own\\oct\\filepath\\file02.txt"));
            OutputStreamWriter file = new OutputStreamWriter(fileOutStream, "UTF-8");
            
            file.write("Hi\n");
            file.write("What's up 💩?");
            file.close();
        } catch (Exception e) {
            System.out.println("Badly handled error");
        }
    }
    public static void readFileWithFileReader() {
        // Reading a file
        String string = "";
        try {
            FileReader file = new FileReader("src\\com\\own\\oct\\filepath\\file03.txt");

            char [] characters = new char[128];
            file.read(characters);

            for(char character : characters) {
                System.out.print(character);
            }

            file.close();
        } catch (Exception e) {
            System.out.println("Badly handled error");
        }
        System.out.println(string);
    }
}
