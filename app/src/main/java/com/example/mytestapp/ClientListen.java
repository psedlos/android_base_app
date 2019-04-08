package com.example.mytestapp;

import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class ClientListen implements Runnable {
    @Override
    public void run() {
        boolean run = true;


        while (run) {
            try {
                DatagramSocket udpSocket = new DatagramSocket(null);
                if (udpSocket.isBound()){
                    udpSocket.setReuseAddress(true);
                    Log.d("UDP Bound:", "address reused");
                }
                udpSocket.setReuseAddress(true);
                InetSocketAddress port = new InetSocketAddress(64442);
                udpSocket.bind( port);
                byte[] message = new byte[8000];
                DatagramPacket packet = new DatagramPacket(message, message.length);
                Log.i("UDP client:", "about to wait to receive");
                udpSocket.receive(packet);
                String text = new String(message, 0, packet.getLength());

                Log.d("Received Data", text);
            } catch (IOException e) {
                Log.e("UDP Client has IOE", "error: ", e);
                run = false;
            }
        }
    }
}
