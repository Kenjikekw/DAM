package t4;

import java.awt.FlowLayout;

import javax.swing.*;

public class Aplicacion {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Crear una instancia del JavaBean LabelTextFieldPanel
            LabelTextFieldPanel labelTextFieldPanel = new LabelTextFieldPanel();
            
            // Configurar el texto del JLabel y el JTextField
            labelTextFieldPanel.setLabelText("Nombre");
            labelTextFieldPanel.setTextFieldContent("");
            
            // Crear un JFrame y añadir el JavaBean al contenido
            JFrame frame = new JFrame("Prueba de LabelTextFieldPanel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());
            frame.add(labelTextFieldPanel);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
