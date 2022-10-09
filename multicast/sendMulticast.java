package multicast;

import java.io.*;
import java.net.*;

public class sendMulticast{
    int port = 12361;
    MulticastSocket multicastSendSocket = new MulticastSocket(port);
    InetAddress multicastInetAddress = InetAddress.getByName("224.0.0.1");

    static BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

    public static void main(String [] args) throws Exception{
	sendMulticast test = new sendMulticast();
	test.SendMulticast();
	test.multicastSendSocket.leaveGroup(test.multicastInetAddress);
	test.multicastSendSocket.close();
    }

    public sendMulticast() throws Exception{
	multicastSendSocket.joinGroup(multicastInetAddress);
    }


    public boolean SendMulticast() throws Exception{
	System.out.print("Input to send packet size -> ");
	int i = Integer.valueOf(br.readLine());
	byte[] buf = new byte[i];
	DatagramPacket packet = new DatagramPacket(buf, buf.length, multicastInetAddress, port);
	multicastSendSocket.send(packet);
	if(br.readLine().equals("")){
	    return false;
	}
	return true;
    }
}
