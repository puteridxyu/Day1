package lesson7.x;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ASUS\\Desktop\\JavaClassFeb24\\Day1.2\\Day1\\src\\lesson7\\x\\outputfile2.txt"; // Replace
                                                                                                                      // with
                                                                                                                      // the
        // desired output
        // file path

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            String content = "dbhebdhewjd";
            writer.write(content);
            System.out.println("File created successfully with content: " + content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
