package t2;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MusicPlayerInterface extends JFrame {
    private JButton playButton;
    private JButton stopButton;

    public MusicPlayerInterface() {
        setLayout(new BorderLayout());

        // Botón de Reproducir
        playButton = new JButton("Reproducir");
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Reproduciendo música");
            }
        });
        add(playButton, BorderLayout.CENTER);

        // Botón de Detener
        stopButton = new JButton("Detener");
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Música detenida");
            }
        });
        add(stopButton, BorderLayout.SOUTH);

        setSize(250, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MusicPlayerInterface();
    }
}

