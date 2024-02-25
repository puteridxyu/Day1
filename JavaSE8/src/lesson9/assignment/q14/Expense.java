package lesson9.assignment.q14;

import java.util.Date;

public class Expense {
    private String description;
    private double amount;
    private Date date; // Include other relevant fields as needed

    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
        this.date = new Date(); // For simplicity, using the current date/time
    }

    // Getters and setters for other fields as needed

    @Override
    public String toString() {
        return "Description: " + description + ", Amount: $" + amount + ", Date: " + date;
    }
}
