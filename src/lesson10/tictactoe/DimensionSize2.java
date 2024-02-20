package lesson10.tictactoe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class DimensionSize2 extends JFrame {

    public DimensionSize2(int playerMode) {
        setTitle("Tic-Tac-Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextField dimensionField = new JTextField(5);
        JButton submitButton = new JButton("Submit Dimension");

        // Style components
        styleTextField(dimensionField);
        styleButton(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int dimension = Integer.parseInt(dimensionField.getText());

                    if (dimension >= 3 && dimension <= 6) {
                        // Assuming you want to open the ThirdFrame here
                        new GameBoard(playerMode, dimension);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a valid dimension between 3 and 6.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer for dimension.");
                }
            }
        });

        // Create and configure panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical alignment
        panel.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0)); // Add some padding

        // Style and add label
        JLabel enterLabel = new JLabel("Enter your dimensions (3-6):");
        enterLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        enterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(enterLabel);

        // Add styled components to the panel
        panel.add(dimensionField);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some spacing
        panel.add(submitButton);

        // Add panel to the frame
        add(panel);
        setVisible(true);
    }

    // Helper method to style text field
    private void styleTextField(JTextField textField) {
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    // Helper method to style buttons
    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(200, 40)); // Set maximum size to control width and height
        button.setFocusPainted(false); // Remove focus border
    }

}