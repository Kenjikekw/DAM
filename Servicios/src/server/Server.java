package server;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket miServerSocket = new ServerSocket(7777);

            while (true) {
                Socket miSocket = miServerSocket.accept();
                System.out.println("Conexion establecida");
                Hilo hilo = new Hilo(miSocket);
                hilo.start();
            }
        } catch (SocketException e) {
            System.out.println("Cliente desconectado");
        }

    }

}
