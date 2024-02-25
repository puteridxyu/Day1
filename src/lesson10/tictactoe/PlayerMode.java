package lesson10.tictactoe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class PlayerMode extends JFrame {

    private JButton onePlayerButton;
    private JButton twoPlayerButton;

    public PlayerMode() {
        setTitle("Tic-Tac-Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create buttons
        onePlayerButton = new JButton("One Player");
        twoPlayerButton = new JButton("Two Players");

        // Add action listeners
        onePlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new DimensionSize2(1);
            }
        });

        twoPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new DimensionSize2(2);
            }
        });

        // Create and configure panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical alignment
        panel.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0)); // Add some padding

        // Style and add labels
        JLabel startGameLabel = new JLabel("START GAME");
        startGameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        startGameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(startGameLabel);

        // JLabel chooseLabel = new JLabel("Choose:");
        // chooseLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        // panel.add(chooseLabel);

        // Style and add buttons
        styleButton(onePlayerButton);
        panel.add(onePlayerButton);

        styleButton(twoPlayerButton);
        panel.add(twoPlayerButton);

        // Add panel to the frame
        add(panel);
        setVisible(true);
    }

    // Helper method to style buttons
    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(150, 50)); // Set maximum size to control width and height
        button.setFocusPainted(false); // Remove focus border
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PlayerMode::new);
    }
}