package lesson9.assignment.q10.error;

import javax.swing.*;

import lesson10.tictactoe.PlayerMove;
import lesson10.tictactoe.Winner;
import lesson10.tictactoe.WinnerService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
//import java.sql.Timestamp;

public class PlayerMode2 extends JFrame {

    private JButton onePlayerButton;
    private JButton twoPlayerButton;

    public PlayerMode2() {
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
                new DimensionSize(1);
            }
        });

        twoPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new DimensionSize(2);
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
        SwingUtilities.invokeLater(PlayerMode2::new);
    }
}

class DimensionSize extends JFrame {

    public DimensionSize(int playerMode) {
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
                        new ThirdFrame(playerMode, dimension);
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

class ThirdFrame extends JFrame {

    private JButton[][] buttons;
    private String currentPlayer;
    private int dimension;
    // private int playerMode;
    private PlayerMove currentPlayerMove;

    public ThirdFrame(int playerModes, int dimensions) {
        setTitle("Tic-Tac-Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        dimension = dimensions;
        // playerMode = playerModes;

        buttons = new JButton[dimension][dimension];
        currentPlayer = "X";

        JPanel panel = new JPanel(new GridLayout(dimension, dimension));
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                panel.add(buttons[i][j]);
            }
        }

        add(panel);
        initializePlayerMove();

        setVisible(true);
    }

    private void initializePlayerMove() {
        currentPlayerMove = (currentPlayer == "X") ? new HumanPlayerMove() : new ComputerPlayerMove();
    }

    private class ButtonClickListener implements ActionListener {
        private int row;
        private int col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = buttons[row][col];
            currentPlayerMove.makeMove(clickedButton);
        }
    }

    private class HumanPlayerMove implements PlayerMove {
        @Override
        public void makeMove(JButton button) {
            if (button.getText().equals("")) {
                button.setText(String.valueOf(currentPlayer));
                if (checkWinner()) {
                    JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
                    resetGame();
                } else if (isBoardFull()) {
                    JOptionPane.showMessageDialog(null, "It's a draw!");
                    resetGame();
                } else {
                    switchPlayer();
                    initializePlayerMove();
                }
            }
        }
    }

    private class ComputerPlayerMove implements PlayerMove {
        @Override
        public void makeMove(JButton button) {
            int row, col;
            do {
                row = (int) (Math.random() * dimension);
                col = (int) (Math.random() * dimension);
            } while (!buttons[row][col].getText().equals(""));

            buttons[row][col].setText(String.valueOf(currentPlayer));

            if (checkWinner()) {
                JOptionPane.showMessageDialog(null, "Computer wins!");
                resetGame();
            } else if (isBoardFull()) {
                JOptionPane.showMessageDialog(null, "It's a draw!");
                resetGame();
            } else {
                switchPlayer();
                initializePlayerMove();
            }
        }
    }

    private boolean checkWinner() {
        // Check rows
        for (int i = 0; i < dimension; i++) {
            boolean rowWin = true;
            for (int j = 0; j < dimension; j++) {
                if (!buttons[i][j].getText().equals(String.valueOf(currentPlayer))) {
                    rowWin = false;
                    break;
                }
            }
            if (rowWin) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < dimension; j++) {
            boolean colWin = true;
            for (int i = 0; i < dimension; i++) {
                if (!buttons[i][j].getText().equals(String.valueOf(currentPlayer))) {
                    colWin = false;
                    break;
                }
            }
            if (colWin) {
                return true;
            }
        }

        // Check diagonals
        boolean diagonal1Win = true;
        boolean diagonal2Win = true;
        for (int i = 0; i < dimension; i++) {
            if (!buttons[i][i].getText().equals(String.valueOf(currentPlayer))) {
                diagonal1Win = false;
            }
            if (!buttons[i][dimension - 1 - i].getText().equals(String.valueOf(currentPlayer))) {
                diagonal2Win = false;
            }
        }

        // [0][0] [0][1] [0][2]
        // [1][0] [1][1] [1][2]
        // [2][0] [2][1] [2][2]

        return diagonal1Win || diagonal2Win;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (buttons[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == "X") ? "O" : "X";
    }

    private void resetGame() {
        // Dispose the current JFrame
        dispose();

        Winner winner = new Winner(0, "token", 2, 4);
        // Winner winner = new Winner(0, token, playerMode, dimension);
        WinnerService winnerService = new WinnerService();
        winnerService.insert(winner);
    }

}
