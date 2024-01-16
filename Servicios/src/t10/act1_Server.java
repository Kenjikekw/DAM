package t10;

import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class act1_Server {

    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData;

        System.out.println("Servidor UDP iniciado en el puerto 9876");

        while(true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData(), 0, receivePacket.getLength());
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            if(sentence.toLowerCase().equals("byebye")) {
            	sentence = "Cliente desconectado";
            }else {
            	sentence = sentence.toUpperCase();
            }
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);

            System.out.println("Recibido de " + IPAddress + ":" + port + " - " + sentence);
        }
    }
}