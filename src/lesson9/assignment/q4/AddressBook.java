package lesson9.assignment.q4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressBook extends JFrame {

    private DefaultListModel<String> contactListModel;
    private JList<String> contactList;
    private JTextField nameField, emailField;
    private JButton addButton, editButton, deleteButton;

    public AddressBook() {
        setTitle("Address Book");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initializeComponents();
        setLayout();
        setListeners();

        setVisible(true);
    }

    private void initializeComponents() {
        contactListModel = new DefaultListModel<>();
        contactList = new JList<>(contactListModel);

        nameField = new JTextField(20);
        emailField = new JTextField(20);

        addButton = new JButton("Add Contact");
        editButton = new JButton("Edit Contact");
        deleteButton = new JButton("Delete Contact");
    }

    private void setLayout() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2, 5, 5));
        inputPanel.add(new JLabel("Name: "));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Email: "));
        inputPanel.add(emailField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BorderLayout());
        listPanel.add(new JLabel("Contacts:"), BorderLayout.NORTH);
        listPanel.add(new JScrollPane(contactList), BorderLayout.CENTER);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(listPanel, BorderLayout.SOUTH);
    }

    private void setListeners() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addContact();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editContact();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteContact();
            }
        });
    }

    private void addContact() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();

        if (!name.isEmpty() && !email.isEmpty()) {
            contactListModel.addElement(name + " - " + email);
            clearFields();
        }
    }

    private void editContact() {
        int selectedIndex = contactList.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedContact = contactListModel.getElementAt(selectedIndex);
            String[] parts = selectedContact.split(" - ");

            nameField.setText(parts[0]);
            emailField.setText(parts[1]);

            contactListModel.remove(selectedIndex);
        }
    }

    private void deleteContact() {
        int selectedIndex = contactList.getSelectedIndex();
        if (selectedIndex != -1) {
            contactListModel.remove(selectedIndex);
            clearFields();
        }
    }

    private void clearFields() {
        nameField.setText("");
        emailField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AddressBook());
    }
}
