/* Ejemplo mínimo para el T10act1*/
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.GridLayout;
import java.net.URL;
import javax.help.*;

public class Sumador extends JFrame {
    private final JButton button = new JButton("New button");
    private void ponLaAyuda() {
        try {
            File fichero = new File("./help/help_set.hs");
            URL hsURL = fichero.toURI().toURL();
            HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            HelpBroker hb = helpset.createHelpBroker();
            hb.enableHelpKey(this.getContentPane(), "suma", helpset); // Manda al topic "suma" al pulsar F1
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Sumador() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(3, 2));
        setContentPane(panelPrincipal);
        panelPrincipal.add(button);
        setTitle("Test");
        setSize(400,200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.ponLaAyuda();
        setVisible(true);
    }
    public static void main(String[] args) {
        new Sumador();
    }
}