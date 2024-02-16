package lesson9.assignment.q9;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;

public class MusicPlayer extends JFrame {

    private AdvancedPlayer player;
    private String currentSong;
    private boolean isPlaying = false;
    private JSlider volumeSlider;

    public MusicPlayer() {
        setTitle("Music Player");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton playButton = new JButton("Play");
        JButton pauseButton = new JButton("Pause");
        JButton stopButton = new JButton("Stop");
        JButton skipButton = new JButton("Skip");
        volumeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                play();
            }
        });

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pause();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stop();
            }
        });

        skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                skip();
            }
        });

        volumeSlider.addChangeListener(e -> setVolume(volumeSlider.getValue()));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(playButton);
        buttonPanel.add(pauseButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(skipButton);

        JPanel volumePanel = new JPanel();
        volumePanel.add(new JLabel("Volume: "));
        volumePanel.add(volumeSlider);

        add(buttonPanel, BorderLayout.CENTER);
        add(volumePanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void play() {
        if (!isPlaying) {
            try {
                FileInputStream fileInputStream = new FileInputStream("path/to/your/music.mp3");
                player = new AdvancedPlayer(fileInputStream);
                player.setPlayBackListener(new PlaybackListener() {
                    @Override
                    public void playbackFinished(PlaybackEvent evt) {
                        stop();
                    }
                });

                new Thread(() -> {
                    try {
                        player.play();
                    } catch (JavaLayerException e) {
                        e.printStackTrace();
                    }
                }).start();

                isPlaying = true;
            } catch (JavaLayerException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void pause() {
        if (isPlaying) {
            player.close();
            isPlaying = false;
        }
    }

    private void stop() {
        if (isPlaying) {
            player.close();
            isPlaying = false;
        }
    }

    private void skip() {
        stop();
        play();
    }

    private void setVolume(int volume) {
        if (isPlaying && player != null) {
            float gain = volume / 100f;
            player.setControllerValue(AdvancedPlayer.GAIN, gain);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MusicPlayer::new);
    }
}
