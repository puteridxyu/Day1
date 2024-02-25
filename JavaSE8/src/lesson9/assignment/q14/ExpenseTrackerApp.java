package lesson9.assignment.q14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExpenseTrackerApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ExpenseTrackerFrame frame = new ExpenseTrackerFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ExpenseTrackerFrame extends JFrame {
    private DefaultListModel<String> listModel;
    private JTextField expenseField;

    public ExpenseTrackerFrame() {
        setTitle("Expense Tracker");
        setSize(400, 300);
        setLocationRelativeTo(null);

        listModel = new DefaultListModel<>();

        JList<String> expenseList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(expenseList);

        expenseField = new JTextField(20);
        JButton addButton = new JButton("Add Expense");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addExpense();
            }
        });

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Expense: "));
        inputPanel.add(expenseField);
        inputPanel.add(addButton);

        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
    }

    private void addExpense() {
        String expense = expenseField.getText().trim();
        if (!expense.isEmpty()) {
            listModel.addElement(expense);
            expenseField.setText("");
        }
    }
}
