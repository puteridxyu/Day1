package lesson7.x;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteFile {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ASUS\\Desktop\\JavaClassFeb24\\Day1.2\\Day1\\src\\lesson7\\x\\outputfile.txt";

        try (Scanner scanner = new Scanner(System.in);
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            System.out.print("Enter a string to write to the file: ");
            String userInput = scanner.nextLine();

            writer.write(userInput);
            System.out.println("String written to the file successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
