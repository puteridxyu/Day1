package lesson9.assignment.q15;

import javax.swing.*;

public class RecipeBookApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RecipeBookGUI recipeBookGUI = new RecipeBookGUI();
            recipeBookGUI.setVisible(true);
        });
    }
}
