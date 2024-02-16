package lesson9.assignment.q8;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageViewer extends JFrame {

    private List<ImageIcon> images;
    private int currentIndex;
    private JLabel imageLabel;

    public ImageViewer() {
        setTitle("Image Viewer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        images = new ArrayList<>();
        currentIndex = 0;

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setVerticalAlignment(SwingConstants.CENTER);

        JButton prevButton = new JButton("Previous");
        JButton nextButton = new JButton("Next");
        JButton openButton = new JButton("Open Image");

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPreviousImage();
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextImage();
            }
        });

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openImage();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(openButton);

        add(imageLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void showPreviousImage() {
        if (currentIndex > 0) {
            currentIndex--;
            displayImage();
        }
    }

    private void showNextImage() {
        if (currentIndex < images.size() - 1) {
            currentIndex++;
            displayImage();
        }
    }

    private void openImage() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
            images.add(imageIcon);
            currentIndex = images.size() - 1;
            displayImage();
        }
    }

    private void displayImage() {
        if (images.isEmpty()) {
            imageLabel.setIcon(null);
        } else {
            ImageIcon currentImage = images.get(currentIndex);
            imageLabel.setIcon(new ImageIcon(currentImage.getImage().getScaledInstance(
                    imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_DEFAULT)));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ImageViewer::new);
    }
}
