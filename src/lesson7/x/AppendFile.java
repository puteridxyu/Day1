package lesson7.x;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AppendFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the file name
        System.out.print("Enter the file name to append to: ");
        String fileName = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            // Prompt the user to enter a string to append
            System.out.print("Enter the string to append: ");
            String userString = scanner.nextLine();

            // Append the user's string to the file
            writer.write(userString);
            writer.newLine(); // Add a newline after the appended string (optional)

            System.out.println("String appended to the file successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
