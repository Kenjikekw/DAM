package act1;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class main extends JFrame {
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;

    public main() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Usuario Label
        JLabel userLabel = new JLabel("Usuario:");
        c.gridx = 0;
        c.gridy = 0;
        add(userLabel, c);

        // Usuario TextField
        userField = new JTextField(15);
        c.gridx = 1;
        c.gridy = 0;
        add(userField, c);

        // Contraseña Label
        JLabel passLabel = new JLabel("Contraseña:");
        c.gridx = 0;
        c.gridy = 1;
        add(passLabel, c);

        // Contraseña Field
        passField = new JPasswordField(15);
        c.gridx = 1;
        c.gridy = 1;
        add(passField, c);

        // Botón de Inicio de Sesión
        loginButton = new JButton("Iniciar Sesión");
        c.gridx = 1;
        c.gridy = 2;
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = userField.getText();
                String pass = new String(passField.getPassword());
                if (user.equals("admin") && pass.equals("1234")) {
                    JOptionPane.showMessageDialog(null, "Acceso concedido");
                } else {
                    JOptionPane.showMessageDialog(null, "Acceso denegado");
                }
            }
        });
        add(loginButton, c);

        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new main();
    }


}
