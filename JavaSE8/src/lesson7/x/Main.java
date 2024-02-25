//Main.java
package lesson7.x;

public class Main {
    static String filename = "src\\lesson7\\x\\outputfile.txt";

    public static void main(String[] args) {
        // Readfile
        ReadFile readFile = new ReadFile("src\\lesson7\\x\\encrypted_output.txt");
        readFile.printFile();

        // readFile.printFile();
        // Count words
        // CountWords countWords = new CountWords(filename);
        // int countWords.countWords();
        // System.out.print("Length of the words "+ count);
        // Write File
        // WriteFile writeFile = new WriteFile(newfile);
        // WriteFile.write("Write some text");
        // readFile.printFile();
        // copy file 1 to file 2

        Decryption decryption = new Decryption("src\\lesson7\\x\\encrypted_output.txt");
        decryption.decrypt();

    }
}
