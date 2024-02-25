package lesson10.tictactoe;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class GameBoard extends JFrame {

    private JButton[][] buttons;
    private String currentPlayer;
    private int dimension;
    // private int playerMode;
    private PlayerMove currentPlayerMove;

    public GameBoard(int playerModes, int dimensions) {
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

        String token = currentPlayer;
        Winner winner = new Winner(0, token, 2, 4);
        // Winner winner = new Winner(0, token, playerMode, dimension);
        WinnerService winnerService = new WinnerService();
        winnerService.insert(winner);
    }

}
