package server;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.*;
    import java.io.IOException;
    import java.io.ObjectInputStream;
    import java.io.ObjectOutputStream;
    import java.net.Socket;
    import java.net.URI;
    import java.util.Scanner;

    public class Cliente {
        private ObjectOutputStream out;
        private ObjectInputStream in;
        private Socket miSocket;

        private Cliente() {
            try {
                miSocket = new Socket("localhost", 7777);
                out = new ObjectOutputStream(miSocket.getOutputStream());
                in = new ObjectInputStream(miSocket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            Cliente cliente = new Cliente();
            cliente.crearMenu();
        }

        public void crearVentaLogin(JFrame frame) {
            frame.dispose();
            JFrame frame2 = new JFrame("Menu de usuario");
            JPanel window = new JPanel();
            window.setLayout(null);
            window.setBounds(0, 0, 1200, 800);
            String color = "#0b8185";
            window.setBackground(Color.decode(color));

            JLabel title = new JLabel("Login");
            title.setFont(new Font("Arial", Font.BOLD, 20));
            title.setBounds(50, 50, 650, 30);
            title.setHorizontalAlignment(SwingConstants.CENTER);
            title.setHorizontalAlignment(SwingConstants.CENTER);
            title.setOpaque(true);
            title.setBackground(Color.orange);
            window.add(title);

            JLabel userLabel = new JLabel("Usuario");
            userLabel.setFont(new Font("Arial", 0, 20));
            userLabel.setBounds(50, 100, 100, 60);
            window.add(userLabel);
            JTextField txtUser = new JTextField();
            txtUser.setBounds(220, 115, 200, 30);
            window.add(txtUser);

            JLabel pwdLabel = new JLabel("Contrase単a");
            pwdLabel.setFont(new Font("Arial", 0, 20));
            pwdLabel.setBounds(50, 150, 200, 50);
            window.add(pwdLabel);
            JPasswordField txtPwd = new JPasswordField();
            txtPwd.setBounds(220, 165, 200, 30);
            window.add(txtPwd);

            ActionListener listner = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getActionCommand().equalsIgnoreCase("enviar")) {
                        Object respuesta = null;
                        try {
                            String user = txtUser.getText();
                            String pwd = txtPwd.getText();
                            String peticion = "1";

                            out.writeUTF(peticion);
                            out.writeUTF(user);
                            out.writeUTF(pwd);
                            out.flush();

                            respuesta = in.readObject();
                                                    
                            if (respuesta.equals("Logeado con exito")) {
                                JOptionPane.showMessageDialog(frame2, "Buenos dias " + user);
                                HablarServidor(frame2);
                            } else {
                                JOptionPane.showMessageDialog(frame2, "Usuario o contrase単a incorrectos");
                                frame2.dispose();
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        } catch (ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    } else if(e.getActionCommand().equalsIgnoreCase("volver")){
                        frame2.dispose();
                        crearMenu();
                    }
                }
            };

            JButton enviarButton = new JButton();
            enviarButton.setBounds(500, 330, 100, 30);
            enviarButton.setText("Enviar");
            enviarButton.setActionCommand("enviar");
            enviarButton.setFont(new Font("Arial", Font.BOLD, 14));
            color="#403831";
            enviarButton.setBackground(Color.decode(color));
            enviarButton.setForeground(Color.WHITE);
            enviarButton.addActionListener(listner);
            window.add(enviarButton);

            JButton cancelarButton = new JButton();
            cancelarButton.setBounds(600, 330, 100, 30);
            cancelarButton.setText("Volver");
            cancelarButton.setActionCommand("volver");
            cancelarButton.setFont(new Font("Arial", Font.BOLD, 14));
            color="#403831";
            cancelarButton.setBackground(Color.decode(color));
            cancelarButton.setForeground(Color.WHITE);
            cancelarButton.addActionListener(listner);
            window.add(cancelarButton);

            frame2.add(window);
            frame2.setSize(800, 450);
            frame2.setLocationRelativeTo(null);
            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame2.setVisible(true);
        }
        
        public void HablarServidor(JFrame frame) {
        	frame.dispose();
        	JFrame frame2 = new JFrame("Chat servidor");
        	JPanel window = new JPanel();
        	window.setLayout(null);
            window.setBounds(0, 0, 1200, 800);
            String color = "#0b8185";
            window.setBackground(Color.decode(color));
            
            JLabel title = new JLabel("Chat");
            title.setFont(new Font("Arial", Font.BOLD, 20));
            title.setHorizontalAlignment(SwingConstants.CENTER);
            title.setBounds(50, 50, 650, 30);
            title.setHorizontalAlignment(SwingConstants.CENTER);
            title.setOpaque(true);
            title.setBackground(Color.orange);
            window.add(title);
            
            JTextArea chat = new JTextArea();
            chat.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(chat);
            scrollPane.setBounds(50, 180, 650, 200);
            window.add(scrollPane);

            JLabel userLabel = new JLabel("Enviar mensaje");
            userLabel.setBounds(50, 100, 180, 60);
            userLabel.setFont(new Font("Arial", 0, 20));
            window.add(userLabel);
            JTextField txtUser = new JTextField();
            txtUser.setBounds(220, 115, 300, 30);
            txtUser.addActionListener(new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent e) {
					if(txtUser.getText()!= null) {
						try {
						String texto = txtUser.getText();
                        
                        chat.append("Cliente:\n" + texto +"\n\nServidor:\n" + texto);
                        txtUser.setText("");

					} catch (Exception f) {
						f.printStackTrace();					}
				}
				}});
            window.add(txtUser);
            
            
            frame2.add(window);
            frame2.setSize(800, 450);
            frame2.setLocationRelativeTo(null);
            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame2.setVisible(true);
        }

        public void crearVentaRegister(JFrame frame) {
            frame.dispose();
            JFrame frame3 = new JFrame("Menu usuario");
            JPanel window = new JPanel();
            window.setLayout(null);
            window.setBounds(0, 0, 1200, 800);
            String color = "#0b8185";
            window.setBackground(Color.decode(color));

            JLabel title = new JLabel("Register");
            title.setFont(new Font("Arial", Font.BOLD, 20));
            title.setHorizontalAlignment(SwingConstants.CENTER);
            title.setBounds(50, 50, 650, 30);
            title.setHorizontalAlignment(SwingConstants.CENTER);
            title.setOpaque(true);
            title.setBackground(Color.orange);
            window.add(title);

            JLabel userLabel = new JLabel("Usuario");
            userLabel.setBounds(50, 100, 100, 60);
            userLabel.setFont(new Font("Arial", 0, 20));
            window.add(userLabel);
            JTextField txtUser = new JTextField();
            txtUser.setBounds(220, 115, 200, 30);
            window.add(txtUser);

            JLabel pwdLabel = new JLabel("Contraseña");
            pwdLabel.setBounds(50, 150, 200, 50);
            pwdLabel.setFont(new Font("Arial", 0, 20));
            window.add(pwdLabel);
            JPasswordField txtPwd = new JPasswordField();
            txtPwd.setBounds(220, 165, 200, 30);
            window.add(txtPwd);

            JLabel pwdLabel2 = new JLabel("Confirmar contraseña");
            pwdLabel2.setBounds(50, 200, 200, 50);
            pwdLabel2.setFont(new Font("Arial", 0, 20));
            window.add(pwdLabel2);
            JPasswordField txtPwd2 = new JPasswordField();
            txtPwd2.setBounds(270, 210, 200, 30);
            window.add(txtPwd2);


            ActionListener listner = new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getActionCommand().equalsIgnoreCase("enviar")) {
                        Object respuesta = null;
                        try {
                            String user = txtUser.getText();
                            String pwd = txtPwd.getText();
                            String peticion = "2";

                            out.writeUTF(peticion);
                            out.writeUTF(user);
                            out.writeUTF(pwd);
                            out.flush();

                            respuesta = in.readObject();
                            if (respuesta.equals("Registrado con exito") && confirmarPassword(txtPwd.getText(), txtPwd2.getText())) {
                                JOptionPane.showMessageDialog(frame3, "Bienvenido " + user);
                                frame3.dispose();
                            } else if(respuesta.equals("Error al registrar") && confirmarPassword(txtPwd.getText(), txtPwd2.getText())) {
                                JOptionPane.showMessageDialog(frame3, "Usuario repetido");
                                frame3.dispose();
                            }else if((respuesta.equals("Error al registrar") && !confirmarPassword(txtPwd.getText(), txtPwd2.getText()))){
                                JOptionPane.showMessageDialog(frame3, "La contrase単a no coincide y el usuario ya esta en uso");
                                frame3.dispose();
                            }else{
                                JOptionPane.showMessageDialog(frame3,"Error al registrar");
                                frame3.dispose();
                            }

                            in.close();
                            out.close();
                            miSocket.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        } catch (ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    } else if(e.getActionCommand().equalsIgnoreCase("volver")){
                        frame3.dispose();
                        crearMenu();
                    }
                }
            };

            JButton enviarButton = new JButton();
            enviarButton.setBounds(500, 330, 100, 30);
            enviarButton.setText("Enviar");
            enviarButton.setActionCommand("enviar");
            enviarButton.setFont(new Font("Arial", Font.BOLD, 14));
            color="#403831";
            enviarButton.setBackground(Color.decode(color));
            enviarButton.setForeground(Color.WHITE);
            enviarButton.addActionListener(listner);
            window.add(enviarButton);

            JButton cancelarButton = new JButton();
            cancelarButton.setBounds(600, 330, 100, 30);
            cancelarButton.setText("Volver");
            cancelarButton.setActionCommand("volver");
            cancelarButton.setFont(new Font("Arial", Font.BOLD, 14));
            color="#403831";
            cancelarButton.setBackground(Color.decode(color));
            cancelarButton.setForeground(Color.WHITE);
            cancelarButton.addActionListener(listner);
            window.add(cancelarButton);

            frame3.setResizable(false);
            frame3.add(window);
            frame3.setSize(800, 450);
            frame3.setLocationRelativeTo(null);
            frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame3.setVisible(true);
        }


        public void crearMenu() {
            JFrame frame = new JFrame("Menu");
            JPanel window = new JPanel();
            window.setLayout(null);
            window.setBounds(0, 0, 1200, 800);
            String color = "#1f5f61";
            window.setBackground(Color.decode(color));

            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    cerral();
                }
            });


            JLabel title = new JLabel(" Menu ");
            title.setFocusable(true);
            title.setFont(new Font("Arial", Font.BOLD, 20));
            title.setHorizontalAlignment(SwingConstants.CENTER);
            title.setOpaque(true);
            title.setBackground(Color.orange);
            title.setBounds(85, 50, 600, 30);
            window.add(title);

            ActionListener listner = new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getActionCommand().equalsIgnoreCase("login")) {
                        crearVentaLogin(frame);
                    } else if (e.getActionCommand().equalsIgnoreCase("register")) {
                        crearVentaRegister(frame);
                    }else if(e.getActionCommand().equalsIgnoreCase("bbdd")){
                        try {
                            String url = "http://localhost/phpmyadmin/index.php?route=/sql&pos=0&db=bbdduser&table=datos";
                            Desktop.getDesktop().browse(new URI(url));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            };
            JButton bbdd = new JButton();
            bbdd.setBounds(700, 50, 70, 30);
            bbdd.setText("BBDD");
            bbdd.setActionCommand("bbdd");
            bbdd.addActionListener(listner);
            bbdd.setFont(new Font("Arial", Font.BOLD, 10));
            bbdd.setHorizontalAlignment(SwingConstants.CENTER);
            bbdd.setOpaque(true);
            bbdd.setBackground(Color.orange);
            window.add(bbdd);

            JButton loginButton = new JButton();
            loginButton.setBounds(86, 180, 300, 60);
            loginButton.setText("Login");
            loginButton.setActionCommand("login");
            loginButton.setFont(new Font("Arial", Font.BOLD, 14));
            color="#403831";
            loginButton.setBackground(Color.decode(color));
            loginButton.setForeground(Color.WHITE);
            loginButton.addActionListener(listner);
            window.add(loginButton);

            JButton registerButton = new JButton();
            registerButton.setBounds(400, 180, 285, 60);
            registerButton.setText("Register");
            registerButton.setActionCommand("register");
            registerButton.setFont(new Font("Arial", Font.BOLD, 14));
            color="#403831";
            registerButton.setBackground(Color.decode(color));
            registerButton.setForeground(Color.WHITE);
            registerButton.addActionListener(listner);
            window.add(registerButton);


            frame.setResizable(false);
            frame.add(window);
            frame.setSize(800, 450);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }


        private boolean confirmarPassword(String txtPwd, String txtPwd2) {
            if (txtPwd.equals(txtPwd2)) {
                return true;
            }
            return false;
        }
        public void cerral(){
            try {
                if (miSocket != null && !miSocket.isClosed()) {
                    miSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
