package t5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InteractiveFrame extends JFrame {
    private JButton button;
    private JTextField textField;
    private JTextField textField_1;
    private JSlider slider;
    private JLabel sliderValueLabel;
    private JComboBox<String> comboBox;
    private JLabel OptionLabel;
    private JLabel selectedOptionLabel;


    public InteractiveFrame() {
        setTitle("Interactive Listeners Demo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout());

        button = new JButton("Hover over me!");
        textField = new JTextField(20);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(UIManager.getColor("Button.background")); // Esto restablece el color al predeterminado de Swing. Si tienes un color específico que deseas usar, puedes reemplazarlo aquí.
            }
        });

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                textField.setBackground(Color.YELLOW);
            }

            @Override
            public void focusLost(FocusEvent e) {
                textField.setBackground(Color.WHITE);
            }
        });

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                textField.setText("You pressed: " + keyChar);
            }
        });

        getContentPane().add(textField);
        getContentPane().add(button);
              
        textField_1 = new JTextField(20);
        getContentPane().add(textField_1);
        textField_1.requestFocusInWindow();
        setVisible(true);
        
        slider = new JSlider(JSlider.VERTICAL, 0, 100, 50); 
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        sliderValueLabel = new JLabel("Value: " + slider.getValue());

        slider.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int newValue = slider.getValue() - e.getWheelRotation();
                slider.setValue(newValue);
                sliderValueLabel.setText("Value: " + newValue);
            }
        });

        getContentPane().add(slider);
        getContentPane().add(sliderValueLabel);
        
        String[] options = {"10", "9", "8"};
        comboBox = new JComboBox<>(options);
        OptionLabel = new JLabel("Nota del alumno: ");
        selectedOptionLabel = new JLabel();

        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedOption = comboBox.getSelectedItem().toString();
                    selectedOptionLabel.setText(selectedOption.equals("8") ? "Notable" : "Sobresaliente");
                }
            }
        });
        
        getContentPane().add(OptionLabel);
        getContentPane().add(comboBox);
        getContentPane().add(selectedOptionLabel);        
    }

    public static void main(String[] args) {
        InteractiveFrame ifra = new InteractiveFrame();
        ifra.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                ifra.textField_1.requestFocusInWindow();
            }
        });
    }
}