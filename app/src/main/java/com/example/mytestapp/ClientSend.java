package com.example.mytestapp;

import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class ClientSend implements Runnable{
    @Override
    public void run(){
        try {
            DatagramSocket udpSocket = new DatagramSocket(null);
            if (udpSocket.isBound()){
                udpSocket.setReuseAddress(true);
                Log.d("UDP Bound:", "address reused");
            }

            InetSocketAddress port = new InetSocketAddress(64444);
            udpSocket.bind( port);
            InetAddress serverAddr = InetAddress.getByName("192.168.0.111");
            byte[] buf = ("The String to Send").getBytes();
            DatagramPacket packet = new DatagramPacket(buf,0, buf.length, serverAddr, 64443);
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
