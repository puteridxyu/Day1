package lesson7.x;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the file name
        System.out.print("Enter the file name to search: ");
        String fileName = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Prompt the user to enter a word to search
            System.out.print("Enter the word to search: ");
            String userWord = scanner.nextLine();

            // Search for the word in the file
            boolean wordFound = searchWord(reader, userWord);

            if (wordFound) {
                System.out.println("The word '" + userWord + "' exists in the file.");
            } else {
                System.out.println("The word '" + userWord + "' does not exist in the file.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static boolean searchWord(BufferedReader reader, String targetWord) throws IOException {
        String line;

        while ((line = reader.readLine()) != null) {
            if (line.contains(targetWord)) {
                return true;
            }
        }

        return false;
    }
}
