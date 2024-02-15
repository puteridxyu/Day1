package lesson7.x;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CopyFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the source and destination file names
        System.out.print("Enter the source file name: ");
        String sourceFileName = scanner.nextLine();

        System.out.print("Enter the destination file name: ");
        String destinationFileName = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFileName));
                BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFileName))) {

            String line;

            while ((line = reader.readLine()) != null) {
                // Copy each line from the source file to the destination file
                writer.write(line);
                writer.newLine(); // Add a newline after each line (optional)
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
