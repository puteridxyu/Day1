package lesson9.assignment.q5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class DrawingProgram extends JFrame {

    private List<Shape> shapes;
    private Shape currentShape;

    public DrawingProgram() {
        setTitle("Drawing Program");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        shapes = new ArrayList<>();

        Canvas canvas = new Canvas();
        canvas.addMouseListener(new DrawingMouseListener());
        canvas.addMouseMotionListener(new DrawingMouseListener());

        add(canvas);
        setVisible(true);
    }

    private class DrawingMouseListener extends MouseAdapter {

        private int startX, startY;

        @Override
        public void mousePressed(MouseEvent e) {
            startX = e.getX();
            startY = e.getY();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            int currentX = e.getX();
            int currentY = e.getY();

            if (currentShape != null) {
                shapes.remove(currentShape);
            }

            if (e.isShiftDown()) {
                currentShape = new Line(startX, startY, currentX, currentY);
            } else if (e.isControlDown()) {
                currentShape = new Rectangle(startX, startY, currentX - startX, currentY - startY);
            } else {
                currentShape = new Ellipse(startX, startY, currentX - startX, currentY - startY);
            }

            shapes.add(currentShape);
            repaint();
        }
    }

    private class Canvas extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            for (Shape shape : shapes) {
                shape.draw(g2d);
            }
        }
    }

    private interface Shape {
        void draw(Graphics2D g2d);
    }

    private class Line implements Shape {
        private int x1, y1, x2, y2;

        public Line(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        @Override
        public void draw(Graphics2D g2d) {
            g2d.drawLine(x1, y1, x2, y2);
        }
    }

    private class Rectangle implements Shape {
        private int x, y, width, height;

        public Rectangle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        @Override
        public void draw(Graphics2D g2d) {
            g2d.drawRect(x, y, width, height);
        }
    }

    private class Ellipse implements Shape {
        private int x, y, width, height;

        public Ellipse(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        @Override
        public void draw(Graphics2D g2d) {
            g2d.drawOval(x, y, width, height);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DrawingProgram::new);
    }
}
