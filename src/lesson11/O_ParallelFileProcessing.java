package lesson11;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class O_ParallelFileProcessing {

    public static void main(String[] args) {
        // Specify the directory containing files to process
        String directoryPath = "/path/to/files";

        // Specify the number of threads to use
        int numThreads = 5;

        // Create an ExecutorService with a fixed thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        // List all files in the directory
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        // Process each file concurrently using threads
        if (files != null) {
            for (File file : files) {
                executorService.execute(new FileProcessor(file));
            }
        }

        // Shutdown the ExecutorService
        executorService.shutdown();
    }

    static class FileProcessor implements Runnable {
        private final File file;

        public FileProcessor(File file) {
            this.file = file;
        }

        @Override
        public void run() {
            // Perform processing on the file (e.g., read, modify, analyze)
            // Replace this with your actual file processing logic
            System.out.println("Processing file: " + file.getName());
        }
    }
}
