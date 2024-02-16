package lesson9.assignment.q7;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ChatServer {

    private static final int PORT = 12345;
    private static final Set<PrintWriter> writers = new HashSet<>();

    public static void main(String[] args) {
        try (ServerSocket listener = new ServerSocket(PORT)) {
            System.out.println("Chat server is running...");
            while (true) {
                new Handler(listener.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;
        private PrintWriter writer;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                Scanner scanner = new Scanner(socket.getInputStream());
                writer = new PrintWriter(socket.getOutputStream(), true);

                writers.add(writer);

                while (true) {
                    if (!scanner.hasNext()) {
                        return;
                    }
                    String message = scanner.nextLine();

                    for (PrintWriter w : writers) {
                        w.println(message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (writer != null) {
                    writers.remove(writer);
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
