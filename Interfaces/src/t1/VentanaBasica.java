package t1;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

public class VentanaBasica extends Frame implements ActionListener {

    Button btnSaludo;

    public VentanaBasica() {
        // Propiedades de la ventana
        this.setSize(300, 150);
        this.setLayout(new FlowLayout());
        this.setTitle("Ventana con AWT");

        // Crear botón y añadir listener
        btnSaludo = new Button("Saludar");
        btnSaludo.addActionListener(this);
        this.add(btnSaludo);

        // Cerrar ventana al pulsar el botón de cierre
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnSaludo) {
            JOptionPane.showMessageDialog(null, "¡Hola, Mundo!");
        }
    }

    public static void main(String[] args) {
        VentanaBasica ventana = new VentanaBasica();
        ventana.setVisible(true);
    }
}
