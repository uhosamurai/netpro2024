package basic;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastServer {
    public static void main(String[] args) {
        MulticastSocket socket = null;
        try {
            socket = new MulticastSocket(9876);
            InetAddress group = InetAddress.getByName("230.0.0.0");
            socket.joinGroup(group);
            byte[] receiveData = new byte[1024];
            byte[] sendData;

            while (true) {
                // 受信パケットを作成
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("受信: " + message);

                // 小文字の文字列を大文字に変換
                String capitalizedMessage = message.toUpperCase();
                sendData = capitalizedMessage.getBytes();

                // 返信パケットを作成
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, group, clientPort);
                socket.send(sendPacket);
                System.out.println("返信: " + capitalizedMessage + " to " + clientAddress + ":" + clientPort);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                try {
                    socket.leaveGroup(InetAddress.getByName("230.0.0.0"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                socket.close();
            }
        }
    }
}

