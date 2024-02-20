package lesson9.assignment.q10;

import javax.swing.*;

import lesson10.tictactoe.DimensionSize2;
import lesson10.tictactoe.ThirdFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class PlayerMode extends JFrame {

    private JButton onePlayerButton;
    private JButton twoPlayerButton;

    public PlayerMode() {
        setTitle("TicTacToe");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        onePlayerButton = new JButton("OnePlayer");
        twoPlayerButton = new JButton("TwoPlayer");

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
                new DimensionSize(1);
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("START GAME "));
        panel.add(new JLabel("\nchoose : "));
        panel.add(onePlayerButton);
        panel.add(twoPlayerButton);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PlayerMode::new);
    }
}

class DimensionSize extends JFrame {

    public DimensionSize(int playerMode) {
        setTitle("TicTacToe");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextField dimensionField = new JTextField(5);
        JButton submitButton = new JButton("Submit dimension");

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

        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter your dimensions (1-5): "));
        panel.add(dimensionField);
        panel.add(submitButton);

        add(panel);
        setVisible(true);
    }
}

class ThirdFrame extends JFrame {

    private JButton[][] buttons;
    private char currentPlayer;
    private int dimension;
    private int playerMode;
    private PlayerMove currentPlayerMove;

    public ThirdFrame(int playerModes, int dimensions) {
        setTitle("Tic-Tac-Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        dimension = dimensions;
        playerMode = playerModes;

        buttons = new JButton[dimension][dimension];
        currentPlayer = 'X';

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
        currentPlayerMove = (currentPlayer == 'X') ? new HumanPlayerMove() : new ComputerPlayerMove();
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
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private void resetGame() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                buttons[i][j].setText("");
            }
        }
        initializePlayerMove();
        new PlayerMode();
    }

}
