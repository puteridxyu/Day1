package lesson9.assignment.q7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    private JFrame frame = new JFrame("Chat Client");
    private JTextArea messageArea = new JTextArea(10, 30);
    private JTextField messageField = new JTextField(30);
    private PrintWriter writer;

    public ChatClient() {
        messageArea.setEditable(false);
        frame.getContentPane().add(new JScrollPane(messageArea), BorderLayout.CENTER);
        frame.getContentPane().add(messageField, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);

        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            Scanner scanner = new Scanner(socket.getInputStream());
            writer = new PrintWriter(socket.getOutputStream(), true);

            new Thread(() -> {
                while (scanner.hasNext()) {
                    messageArea.append(scanner.nextLine() + "\n");
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        messageField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writer.println(messageField.getText());
                messageField.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChatClient::new);
    }
}
