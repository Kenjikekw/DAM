package t7;

import javax.swing.*;
import java.awt.*;

public class ReservaRestaurante {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Reservas Restaurante");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Nombre:");
        nameLabel.setBounds(10, 10, 80, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(100, 10, 160, 25);
        panel.add(nameText);

        JLabel dateLabel = new JLabel("Fecha:");
        dateLabel.setBounds(10, 40, 80, 25);
        panel.add(dateLabel);

        JTextField dateText = new JTextField(20);
        dateText.setBounds(100, 40, 160, 25);
        panel.add(dateText);

        JLabel timeLabel = new JLabel("Hora:");
        timeLabel.setBounds(10, 70, 80, 25);
        panel.add(timeLabel);

        JTextField timeText = new JTextField(20);
        timeText.setBounds(100, 70, 160, 25);
        panel.add(timeText);

        JLabel peopleLabel = new JLabel("Número de personas:");
        peopleLabel.setBounds(10, 100, 150, 25);
        panel.add(peopleLabel);

        JTextField peopleText = new JTextField(20);
        peopleText.setBounds(160, 100, 100, 25);
        panel.add(peopleText);

        JLabel tableLabel = new JLabel("Tipo de mesa:");
        tableLabel.setBounds(10, 130, 100, 25);
        panel.add(tableLabel);

        String[] tableTypes = {"Normal", "VIP", "Terraza"};
        JComboBox<String> tableComboBox = new JComboBox<>(tableTypes);
        tableComboBox.setBounds(120, 130, 140, 25);
        panel.add(tableComboBox);

        JButton reserveButton = new JButton("Reservar");
        reserveButton.setBounds(10, 170, 100, 25);
        panel.add(reserveButton);

        nameText.setToolTipText("Escriba su nombre completo");
        dateText.setToolTipText("Escriba la fecha de la reserva (dd/mm/aaaa)");
        timeText.setToolTipText("Escriba la hora de la reserva (hh:mm AM/PM)");
        peopleText.setToolTipText("Escriba el número de personas para la reserva");

        panel.setBackground(new Color(240, 240, 240));
        reserveButton.setBackground(new Color(50, 150, 50)); 
        reserveButton.setForeground(Color.white); 

        Font labelFont = new Font("Arial", Font.BOLD, 12);
        nameLabel.setFont(labelFont);
        dateLabel.setFont(labelFont);
        timeLabel.setFont(labelFont);
        peopleLabel.setFont(labelFont);
        tableLabel.setFont(labelFont);
    }
}
