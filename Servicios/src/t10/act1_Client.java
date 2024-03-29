package t10;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class act1_Client {
        public static void main(String args[]) throws Exception {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName("localhost");
            byte[] sendData;
            byte[] receiveData = new byte[1024];

            Scanner scanner = new Scanner(System.in);
            while(true) {
                System.out.print("Escribe tu mensaje: ");
                String sentence = scanner.nextLine();
                sendData = sentence.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
                clientSocket.send(sendPacket);

                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);
                String modifiedSentence = new String(receivePacket.getData());
                System.out.println("DEL SERVIDOR:" + modifiedSentence);
                if(modifiedSentence.equals("Cliente desconectado")) {
                	clientSocket.close();
                }
            }
        }
    }