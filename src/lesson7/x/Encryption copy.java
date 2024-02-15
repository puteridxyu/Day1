package lesson7.x;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Encryption extends ReadFileHandler {

    public Encryption(String filename) {
        super(filename);
    }

    public void encrypt() {
        String sourceFileName = getFilename();

        // Test if the source file exists
        if (!testFile(sourceFileName)) {
            System.out.println("Source file does not exist. Aborting encryption.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the destination file name for encrypted content: ");
        String destinationFileName = scanner.nextLine();

        System.out.print("Enter the encryption key (shift value): ");
        int shiftValue = scanner.nextInt();

        encryptFile(sourceFileName, destinationFileName, shiftValue);

        scanner.close();
    }

    // Method to test if the file exists
    private boolean testFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    // Method to encrypt the file
    private void encryptFile(String sourceFileName, String destinationFileName, int shiftValue) {
        try (BufferedReader reader = readFileBuffer();
                BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFileName))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String encryptedLine = encrypt(line, shiftValue);
                writer.write(encryptedLine);
                writer.newLine();
            }

            System.out.println("File encrypted successfully.");
        } catch (IOException e) {
            System.err.println("Error in reading/writing the file: " + e.getMessage());
        }
    }

    private String encrypt(String input, int shiftValue) {
        StringBuilder encryptedText = new StringBuilder();

        for (char character : input.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                char encryptedChar = (char) ((character - base + shiftValue) % 26 + base);
                encryptedText.append(encryptedChar);
            } else {
                // Non-alphabetic characters remain unchanged
                encryptedText.append(character);
            }
        }

        return encryptedText.toString();
    }
}
