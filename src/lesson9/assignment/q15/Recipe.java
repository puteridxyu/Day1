package lesson9.assignment.q15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Recipe {
    private String name;
    private String ingredients;
    private String instructions;

    public Recipe(String name, String ingredients, String instructions) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    // Getters for name, ingredients, and instructions...

    @Override
    public String toString() {
        return String.format("Name: %s\nIngredients: %s\nInstructions: %s\n", name, ingredients, instructions);
    }
}

class RecipeBook {
    private ArrayList<Recipe> recipes;

    public RecipeBook() {
        this.recipes = new ArrayList<>();
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }
}

class RecipeBookGUI extends JFrame {
    private RecipeBook recipeBook;
    private JTextArea displayArea;

    public RecipeBookGUI() {
        this.recipeBook = new RecipeBook();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Recipe Book");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        displayArea = new JTextArea();
        displayArea.setEditable(false);

        JButton addButton = new JButton("Add Recipe");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddRecipeDialog();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);

        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void showAddRecipeDialog() {
        JTextField nameField = new JTextField();
        JTextField ingredientsField = new JTextField();
        JTextField instructionsField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Ingredients:"));
        panel.add(ingredientsField);
        panel.add(new JLabel("Instructions:"));
        panel.add(instructionsField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add Recipe",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String ingredients = ingredientsField.getText();
            String instructions = instructionsField.getText();

            Recipe newRecipe = new Recipe(name, ingredients, instructions);
            recipeBook.addRecipe(newRecipe);
            updateDisplayArea();
        }
    }

    private void updateDisplayArea() {
        displayArea.setText("");
        ArrayList<Recipe> recipes = recipeBook.getRecipes();
        for (Recipe recipe : recipes) {
            displayArea.append(recipe.toString() + "\n\n");
        }
    }
}
