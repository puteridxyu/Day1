package lesson9.assignment.q1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {

    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] operationButtons;
    private JButton addButton, subButton, mulButton, divButton, eqButton, clrButton;
    private JPanel panel;

    private double num1, num2, result;
    private char operator;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initializeComponents();
        setLayout();
        setListeners();

        setVisible(true);
    }

    private void initializeComponents() {
        textField = new JTextField();
        numberButtons = new JButton[10];
        operationButtons = new JButton[6];

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
        }

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        clrButton = new JButton("C");

        panel = new JPanel();
    }

    private void setLayout() {
        setLayout(new BorderLayout());

        textField.setPreferredSize(new Dimension(300, 50));
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        add(textField, BorderLayout.NORTH);

        panel.setLayout(new GridLayout(4, 4, 10, 10));
        for (int i = 1; i <= 9; i++) {
            panel.add(numberButtons[i]);
        }
        panel.add(addButton);
        panel.add(numberButtons[0]);
        panel.add(eqButton);
        panel.add(subButton);
        panel.add(mulButton);
        panel.add(clrButton);
        panel.add(divButton);

        add(panel, BorderLayout.CENTER);
    }

    private void setListeners() {
        for (int i = 0; i < 10; i++) {
            final int number = i;
            numberButtons[i].addActionListener(e -> textField.setText(textField.getText() + number));
        }

        addButton.addActionListener(e -> setOperator('+'));
        subButton.addActionListener(e -> setOperator('-'));
        mulButton.addActionListener(e -> setOperator('*'));
        divButton.addActionListener(e -> setOperator('/'));
        eqButton.addActionListener(e -> calculate());
        clrButton.addActionListener(e -> clear());
    }

    private void setOperator(char op) {
        if (!textField.getText().isEmpty()) {
            num1 = Double.parseDouble(textField.getText());
            operator = op;
            textField.setText("");
        }
    }

    private void calculate() {
        if (!textField.getText().isEmpty()) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        textField.setText("Error");
                        return;
                    }
                    break;
            }

            textField.setText(String.valueOf(result));
        }
    }

    private void clear() {
        textField.setText("");
        num1 = num2 = result = 0;
        operator = '\0';
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleCalculator());
    }
}
