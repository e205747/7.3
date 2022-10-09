package multicast;

import java.net.*;

public class receiveMulticast {
    private static MulticastSocket multicastRecvSocket;

    public static void main(String [] args) throws Exception{
	int port = 12361;

	multicastRecvSocket = new MulticastSocket(port);
	InetAddress multicastInetAddress = InetAddress.getByName("224.0.0.1");

	multicastRecvSocket.joinGroup(multicastInetAddress);

	byte[] buf = new byte[1024];
	DatagramPacket recvPacket = new DatagramPacket(buf, buf.length);
	multicastRecvSocket.receive(recvPacket);
	System.out.write(recvPacket.getData());
    }
}
