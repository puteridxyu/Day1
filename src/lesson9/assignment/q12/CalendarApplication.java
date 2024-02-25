package lesson9.assignment.q12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;

public class CalendarApplication extends JFrame {

    private JLabel monthLabel;
    private JButton prevButton, nextButton;
    private JTable calendarTable;
    private JScrollPane calendarScrollPane;
    private DefaultTableModel calendarTableModel;
    private int month, year;

    public CalendarApplication() {
        setTitle("Calendar Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        monthLabel = new JLabel();
        prevButton = new JButton("Previous Month");
        nextButton = new JButton("Next Month");
        calendarTableModel = new DefaultTableModel();
        calendarTable = new JTable(calendarTableModel);
        calendarScrollPane = new JScrollPane(calendarTable);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(monthLabel, BorderLayout.NORTH);
        panel.add(prevButton, BorderLayout.WEST);
        panel.add(nextButton, BorderLayout.EAST);
        panel.add(calendarScrollPane, BorderLayout.CENTER);

        add(panel);

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPreviousMonth();
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextMonth();
            }
        });

        calendarTable.setCellSelectionEnabled(true);

        calendarTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = calendarTable.rowAtPoint(evt.getPoint());
                int col = calendarTable.columnAtPoint(evt.getPoint());
                int day = (int) calendarTable.getValueAt(row, col);
                if (day > 0) {
                    JOptionPane.showMessageDialog(null, "Selected Date: " + day + "/" + (month + 1) + "/" + year);
                }
            }
        });

        Calendar today = Calendar.getInstance();
        month = today.get(Calendar.MONTH);
        year = today.get(Calendar.YEAR);

        updateCalendar();

        setVisible(true);
    }

    private void updateCalendar() {
        String[] monthNames = new DateFormatSymbols().getMonths();
        monthLabel.setText(monthNames[month] + " " + year);

        calendarTableModel.setColumnCount(7);
        calendarTableModel.setRowCount(6);

        for (int i = 0; i < 7; i++) {
            calendarTableModel.setValueAt(getDayAbbreviation(i), 0, i);
        }

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, 1);

        int startDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        int row = 1;
        int col = startDay;

        for (int day = 1; day <= maxDays; day++) {
            calendarTableModel.setValueAt(day, row, col);
            col++;
            if (col == 7) {
                col = 0;
                row++;
            }
        }
    }

    private String getDayAbbreviation(int dayOfWeek) {
        String[] days = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
        return days[dayOfWeek];
    }

    private void showPreviousMonth() {
        month--;
        if (month < 0) {
            month = 11;
            year--;
        }
        updateCalendar();
    }

    private void showNextMonth() {
        month++;
        if (month > 11) {
            month = 0;
            year++;
        }
        updateCalendar();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalendarApplication::new);
    }
}
