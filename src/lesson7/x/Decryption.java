// Decryption.java
package lesson7.x;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Decryption extends ReadFileHandler {

    public Decryption(String filename) {
        super(filename);
    }

    public void decrypt() {
        String encryptedFileName = getFilename(); // Use the getter method

        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the decryption key (shift value)
        System.out.print("Enter the decryption key (shift value): ");
        int shiftValue = scanner.nextInt();

        try (BufferedReader reader = new BufferedReader(new FileReader(encryptedFileName))) {
            String line;

            System.out.println("Decrypted Content:");

            while ((line = reader.readLine()) != null) {
                // Decrypt each line using the Caesar cipher
                String decryptedLine = decrypt(line, shiftValue);
                System.out.println(decryptedLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private String decrypt(String input, int shiftValue) {
        StringBuilder decryptedText = new StringBuilder();

        for (char character : input.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                char decryptedChar = (char) ((character - base - shiftValue + 26) % 26 + base);
                decryptedText.append(decryptedChar);
            } else {
                // Non-alphabetic characters remain unchanged
                decryptedText.append(character);
            }
        }

        return decryptedText.toString();
    }
}
