package com.example.mytestapp;

import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class ClientSend{

    public void sendText(String textToSend){
        try {
            DatagramSocket udpSocket = new DatagramSocket(null);
            if (udpSocket.isBound()){
                udpSocket.setReuseAddress(true);
                Log.d("UDP Bound:", "address reused");
            }

            InetSocketAddress port = new InetSocketAddress(64444);
            udpSocket.bind( port);
            InetAddress serverAddr = InetAddress.getByName("192.168.0.76");
            byte[] buf = textToSend.getBytes();
            DatagramPacket packet = new DatagramPacket(buf,0, buf.length, serverAddr, 2148);
            udpSocket.send(packet);
            udpSocket.close();
        }
        catch (SocketException e){
            Log.e("Udp:", "Socket Error:", e);
        }
        catch (IOException e ){
            Log.e("UDP Send:", "IO Error:", e);
        }
    }
}
