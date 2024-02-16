package lesson9.assignment.q11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizApplication extends JFrame {

    private JLabel questionLabel;
    private JRadioButton[] optionButtons;
    private ButtonGroup buttonGroup;
    private JButton submitButton;
    private int currentQuestionIndex;
    private int score;

    private String[][] questions = {
            { "What is the capital of France?", "Paris", "Berlin", "Madrid", "Rome", "Paris" },
            { "Which planet is known as the Red Planet?", "Mars", "Venus", "Jupiter", "Saturn", "Mars" },
            { "What is the largest mammal in the world?", "Elephant", "Blue Whale", "Giraffe", "Hippopotamus",
                    "Blue Whale" }
    };

    public QuizApplication() {
        setTitle("Quiz Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        questionLabel = new JLabel();
        optionButtons = new JRadioButton[4];
        buttonGroup = new ButtonGroup();
        submitButton = new JButton("Submit");

        JPanel panel = new JPanel(new GridLayout(6, 1));

        panel.add(questionLabel);

        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            buttonGroup.add(optionButtons[i]);
            panel.add(optionButtons[i]);
        }

        panel.add(submitButton);

        add(panel);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                showNextQuestion();
            }
        });

        currentQuestionIndex = -1;
        score = 0;

        showNextQuestion();

        setVisible(true);
    }

    private void showNextQuestion() {
        currentQuestionIndex++;

        if (currentQuestionIndex < questions.length) {
            questionLabel.setText(questions[currentQuestionIndex][0]);

            for (int i = 0; i < 4; i++) {
                optionButtons[i].setText(questions[currentQuestionIndex][i + 1]);
                optionButtons[i].setSelected(false);
            }
        } else {
            endQuiz();
        }
    }

    private void checkAnswer() {
        for (int i = 0; i < 4; i++) {
            if (optionButtons[i].isSelected()
                    && optionButtons[i].getText().equals(questions[currentQuestionIndex][5])) {
                score++;
                break;
            }
        }
    }

    private void endQuiz() {
        JOptionPane.showMessageDialog(this, "Quiz Completed!\nYour Score: " + score + "/" + questions.length);
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(QuizApplication::new);
    }
}
