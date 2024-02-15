package lesson7.x;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFile extends ReadFileHandler {

    // Constructor
    public ReadFile(String fileName) {
        super(fileName);
    }

    // Method to print the contents of the file
    public void printFile() {
        ReadFile readFile = new ReadFile(super.getFilename());
        try (BufferedReader reader = readFile.readFileBuffer()) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error in reading the file: " + e.getMessage());
        }
    }

    public BufferedReader readFileBuffer() {
        BufferedReader reader = null;
        Path filePath = Paths.get(super.getFilename());

        try {
            reader = new BufferedReader(new FileReader(filePath.toString()));
        } catch (IOException e) {
            System.err.println("Error in reading the file: " + e.getMessage());
        }

        return reader;
    }

}
