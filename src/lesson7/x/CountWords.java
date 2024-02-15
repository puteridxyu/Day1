package lesson7.x;

import java.io.BufferedReader;
import java.io.IOException;

public class CountWords extends ReadFileHandler {

    // Constructor
    public CountWords(String fileName) {
        super(fileName);
    }

    public int countWords() {
        int count = 0;

        try (BufferedReader reader = ReadFile.readfileBuffer("src\\\\lesson7\\\\x\\\\outputfile.txt")) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split by space characters
                count += words.length;
            }
        } catch (IOException e) {
            System.err.println("Error in reading the file: " + e.getMessage());
        }

        return count;
    }
}
