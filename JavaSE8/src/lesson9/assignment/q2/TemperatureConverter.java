package lesson9.assignment.q2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter extends JFrame {

    private JTextField inputField, outputField;
    private JButton convertButton;
    private JComboBox<String> fromComboBox, toComboBox;

    public TemperatureConverter() {
        setTitle("Temperature Converter");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initializeComponents();
        setLayout();
        setListeners();

        setVisible(true);
    }

    private void initializeComponents() {
        inputField = new JTextField(10);
        outputField = new JTextField(10);
        outputField.setEditable(false);

        convertButton = new JButton("Convert");

        String[] temperatureUnits = { "Celsius", "Fahrenheit", "Kelvin" };
        fromComboBox = new JComboBox<>(temperatureUnits);
        toComboBox = new JComboBox<>(temperatureUnits);
    }

    private void setLayout() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Temperature: "));
        inputPanel.add(inputField);
        inputPanel.add(fromComboBox);

        JPanel outputPanel = new JPanel();
        outputPanel.add(new JLabel("Converted Temperature: "));
        outputPanel.add(outputField);
        outputPanel.add(toComboBox);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(convertButton);

        add(inputPanel, BorderLayout.NORTH);
        add(outputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void setListeners() {
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        try {
            double inputValue = Double.parseDouble(inputField.getText());
            String fromUnit = fromComboBox.getSelectedItem().toString();
            String toUnit = toComboBox.getSelectedItem().toString();

            double result = convert(inputValue, fromUnit, toUnit);
            outputField.setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            outputField.setText("Invalid input");
        }
    }

    private double convert(double value, String fromUnit, String toUnit) {
        if (fromUnit.equals(toUnit)) {
            return value; // No conversion needed
        }

        if (fromUnit.equals("Celsius")) {
            if (toUnit.equals("Fahrenheit")) {
                return (value * 9 / 5) + 32;
            } else if (toUnit.equals("Kelvin")) {
                return value + 273.15;
            }
        } else if (fromUnit.equals("Fahrenheit")) {
            if (toUnit.equals("Celsius")) {
                return (value - 32) * 5 / 9;
            } else if (toUnit.equals("Kelvin")) {
                return (value + 459.67) * 5 / 9;
            }
        } else if (fromUnit.equals("Kelvin")) {
            if (toUnit.equals("Celsius")) {
                return value - 273.15;
            } else if (toUnit.equals("Fahrenheit")) {
                return (value * 9 / 5) - 459.67;
            }
        }

        return 0; // Default case (should not happen)
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TemperatureConverter());
    }
}
