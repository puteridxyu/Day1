package lesson8.assignment.q10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipAlgorithm extends CompressionAlgorithm {

    @Override
    public void compress(String inputFile, String outputFile) {
        try (FileInputStream fis = new FileInputStream(inputFile);
                ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(outputFile))) {

            // Create a new ZIP entry
            ZipEntry zipEntry = new ZipEntry(getFileName(inputFile));
            zipOut.putNextEntry(zipEntry);

            // Read data from the input file and write it to the ZIP file
            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }

            // Close the ZIP entry and the streams
            zipOut.closeEntry();
            System.out.println("\nZIP compression applied to " + inputFile + ". Result saved in " + outputFile);
            System.out.println("Result saved in " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to get the file name from the full path
    private String getFileName(String filePath) {
        int lastIndex = filePath.lastIndexOf("\\");
        return filePath.substring(lastIndex + 1);
    }
}
