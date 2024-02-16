package lesson9.assignment.q13;

import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApp extends JFrame {

    private JTextField cityField;
    private JButton getWeatherButton;
    private JTextArea weatherTextArea;

    private static final String API_KEY = "YOUR_OPENWEATHERMAP_API_KEY";
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";

    public WeatherApp() {
        setTitle("Weather App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cityField = new JTextField(20);
        getWeatherButton = new JButton("Get Weather");
        weatherTextArea = new JTextArea();
        weatherTextArea.setEditable(false);

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("Enter City:"));
        panel.add(cityField);
        panel.add(getWeatherButton);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(weatherTextArea), BorderLayout.CENTER);

        getWeatherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String city = cityField.getText();
                if (!city.isEmpty()) {
                    fetchWeatherData(city);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a city name.");
                }
            }
        });

        setVisible(true);
    }

    private void fetchWeatherData(String city) {
        String apiUrl = String.format(API_URL, city, API_KEY);

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();

            displayWeatherData(new JSONObject(response.toString()));

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error fetching weather data. Please check your internet connection.");
        }
    }

    private void displayWeatherData(JSONObject data) {
        String cityName = data.getString("name");
        String temperature = data.getJSONObject("main").get("temp").toString();
        String description = data.getJSONArray("weather").getJSONObject(0).getString("description");

        String weatherInfo = String.format("City: %s\nTemperature: %s°C\nDescription: %s", cityName, temperature,
                description);
        weatherTextArea.setText(weatherInfo);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WeatherApp::new);
    }
}
