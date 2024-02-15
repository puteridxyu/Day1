package lesson8.assignment.q10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class GZipAlgorithm extends CompressionAlgorithm {

    @Override
    public void compress(String inputFile, String outputFile) {
        try (FileInputStream fis = new FileInputStream(inputFile);
                GZIPOutputStream gzipOS = new GZIPOutputStream(new FileOutputStream(outputFile))) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                gzipOS.write(buffer, 0, bytesRead);
            }

            System.out.println("\nGZip compression applied to " + inputFile + ". Result saved in " + outputFile);
            System.out.println("Result saved in " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
