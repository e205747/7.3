package bloadcast;

import java.net.*;

public class receiveBloadcast {
    private static DatagramSocket socket;

    public static void main(String[] args) throws Exception {
        int port = 12361;
        socket = new DatagramSocket(port);
        
        byte buf[] = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        socket.receive(packet);
        System.out.write(packet.getData());
        
        socket.close();
    }
}
