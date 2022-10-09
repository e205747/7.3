package bloadcast;

import java.io.*;
import java.net.*;

public class sendBloadcast {
    
    static BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
    DatagramPacket packet;
    DatagramSocket broadcastSendSocket;

    public static void main(String [] args) throws Exception{
	sendBloadcast test = new sendBloadcast();
	test.broadcastSendSocket = new DatagramSocket();
	test.SendBroadcast();
	test.broadcastSendSocket.close();
    }
    
    public boolean SendBroadcast() throws Exception{
	int port = 12361;
	InetAddress isAddress = InetAddress.getByName("10.0.15.255");
	
	System.out.print("Input to send packet size -> ");
	int i = Integer.valueOf(br.readLine());
	byte[] buf = new byte[i];
	packet = new DatagramPacket(buf, buf.length, isAddress, port);
	broadcastSendSocket.send(packet);
	return true;
    }
}