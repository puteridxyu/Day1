package lesson9.assignment.q3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TodoListManager extends JFrame {

    private DefaultListModel<String> todoListModel;
    private JList<String> todoList;
    private JTextField taskField;
    private JButton addButton, completeButton, deleteButton;

    public TodoListManager() {
        setTitle("Todo List Manager");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initializeComponents();
        setLayout();
        setListeners();

        setVisible(true);
    }

    private void initializeComponents() {
        todoListModel = new DefaultListModel<>();
        todoList = new JList<>(todoListModel);

        taskField = new JTextField(20);

        addButton = new JButton("Add Task");
        completeButton = new JButton("Mark Completed");
        deleteButton = new JButton("Delete Task");
    }

    private void setLayout() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Task: "));
        inputPanel.add(taskField);
        inputPanel.add(addButton);

        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BorderLayout());
        listPanel.add(new JLabel("Todo List:"), BorderLayout.NORTH);
        listPanel.add(new JScrollPane(todoList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(completeButton);
        buttonPanel.add(deleteButton);

        add(inputPanel, BorderLayout.NORTH);
        add(listPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void setListeners() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        completeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markCompleted();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteTask();
            }
        });
    }

    private void addTask() {
        String task = taskField.getText().trim();
        if (!task.isEmpty()) {
            todoListModel.addElement(task);
            taskField.setText("");
        }
    }

    private void markCompleted() {
        int selectedIndex = todoList.getSelectedIndex();
        if (selectedIndex != -1) {
            todoListModel.setElementAt("[Completed] " + todoListModel.getElementAt(selectedIndex), selectedIndex);
        }
    }

    private void deleteTask() {
        int selectedIndex = todoList.getSelectedIndex();
        if (selectedIndex != -1) {
            todoListModel.remove(selectedIndex);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TodoListManager());
    }
}
