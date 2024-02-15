package lesson7.x;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadText {
    public static void main(String[] args) {
        String filePath = "src\\lesson7\\x\\outputfile.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
