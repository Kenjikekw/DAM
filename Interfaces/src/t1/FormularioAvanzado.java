package t1;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FormularioAvanzado extends JFrame implements ActionListener {

    JLabel lblNombre, lblEdad, lblGenero, lblHobbies;
    JTextField txtNombre, txtEdad;
    JRadioButton rbMasculino, rbFemenino;
    JComboBox<String> cbHobbies;
    JButton btnResumen;
    ButtonGroup bgGenero;

    public FormularioAvanzado() {
        // Propiedades de la ventana
        this.setSize(500, 250);
        this.setLayout(new FlowLayout());
        this.setTitle("Formulario Avanzado con Swing");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear componentes
        lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(20);
        lblEdad = new JLabel("Edad:");
        txtEdad = new JTextField(2);

        lblGenero = new JLabel("Género:");
        rbMasculino = new JRadioButton("Masculino");
        rbFemenino = new JRadioButton("Femenino");
        bgGenero = new ButtonGroup();
        bgGenero.add(rbMasculino);
        bgGenero.add(rbFemenino);

        lblHobbies = new JLabel("Hobbies:");
        String[] hobbies = {"Lectura", "Deporte", "Viajes", "Música"};
        cbHobbies = new JComboBox<>(hobbies);

        btnResumen = new JButton("Ver Resumen");
        btnResumen.addActionListener(this);

        // Añadir componentes a un JPanel
        JPanel panel = new JPanel();
        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblEdad);
        panel.add(txtEdad);
        panel.add(lblGenero);
        panel.add(rbMasculino);
        panel.add(rbFemenino);
        panel.add(lblHobbies);
        panel.add(cbHobbies);
        panel.add(btnResumen);

        // Añadir el JPanel al JFrame
        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnResumen) {
            String nombre = txtNombre.getText();
            String edad = txtEdad.getText();
            String genero = rbMasculino.isSelected() ? "Masculino" : "Femenino";
            String hobby = cbHobbies.getSelectedItem().toString();

            JOptionPane.showMessageDialog(null, "Nombre: " + nombre + 
                                                "\nEdad: " + edad + 
                                                "\nGénero: " + genero + 
                                                "\nHobby: " + hobby);
        }
    }

    public static void main(String[] args) {
        FormularioAvanzado formulario = new FormularioAvanzado();
        formulario.setVisible(true);
    }
}

