package server;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

public class Hilo extends Thread {
    Socket miSocket;

    public Hilo(Socket s) {
        this.miSocket = s;
    }

    public void run() {
        try {
            ObjectInputStream in = new ObjectInputStream(miSocket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(miSocket.getOutputStream());

            Modelo modelo = new Modelo();
            Object resp = "";
            String user = "";
            String pwd = "";
            String peticion = in.readUTF();
            
            modelo.baseDatos();
            switch (peticion) {
                case "1":
                    user = in.readUTF();
                    pwd = in.readUTF();

                    if (modelo.login(user, pwd)) {
                        resp = "Logeado con exito";
                    } else {
                        resp = "Nombre de usuario o contraseña no validos";
                    }
                    break;

                case "2":
                    user = in.readUTF();
                    pwd = in.readUTF();

                    if (modelo.registro(user, pwd)) {
                        resp = "Registrado con exito";
                    } else {
                        resp = "Error al registrar";
                    }
                    break;
                    
                case "3":
                	 user = in.readUTF();
                     pwd = in.readUTF();
                     
                     resp = user;
                     
                     break;
                     
                default:
                    resp = "Operacion no válida";
                    break;

            }
            out.writeObject(resp);

        } catch (SocketException e) {
            System.out.print("sa cerrao");
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
