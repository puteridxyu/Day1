package lesson8.assignment.q10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class LZMAAlgorithm extends CompressionAlgorithm {

    @Override
    public void compress(String inputFile, String outputFile) {
        try (FileInputStream fis = new FileInputStream(inputFile);
                ZipOutputStream zipOS = new ZipOutputStream(new FileOutputStream(outputFile))) {

            ZipEntry zipEntry = new ZipEntry(inputFile);
            zipOS.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                zipOS.write(buffer, 0, bytesRead);
            }

            zipOS.closeEntry();
            System.out.println("\nLZMA compression applied to " + inputFile + ". Result saved in " + outputFile);
            System.out.println("Result saved in " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
