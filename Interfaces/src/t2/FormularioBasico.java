package t2;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

public class FormularioBasico extends Frame implements ActionListener {

    Label lblNombre, lblEdad;
    TextField txtNombre, txtEdad;
    Button btnEnviar;

    public FormularioBasico() {
        // Propiedades de la ventana
        this.setSize(400, 200);
        this.setLayout(new FlowLayout());
        this.setTitle("Formulario con AWT");

        // Crear componentes
        lblNombre = new Label("Nombre:");
        txtNombre = new TextField(20);
        lblEdad = new Label("Edad:");
        txtEdad = new TextField(2);
        btnEnviar = new Button("Enviar");
        btnEnviar.addActionListener(this);

        // Añadir componentes
        this.add(lblNombre);
        this.add(txtNombre);
        this.add(lblEdad);
        this.add(txtEdad);
        this.add(btnEnviar);

        // Cerrar ventana
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnEnviar) {
            String nombre = txtNombre.getText();
            String edad = txtEdad.getText();
            JOptionPane.showMessageDialog(null, "¡Hola, " + nombre + "! Tienes " + edad + " años.");
        }
    }

    public static void main(String[] args) {
        FormularioBasico formulario = new FormularioBasico();
        formulario.setVisible(true);
    }
}
