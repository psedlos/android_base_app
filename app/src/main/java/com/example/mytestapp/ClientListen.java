package com.example.mytestapp;

import android.content.res.Resources;
import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;


public class ClientListen implements Runnable {
    MainContainer mc;
    public ClientListen(MainContainer mc){
        this.mc = mc;
    }
    int trailerNo;
    int stat_int;
    int addr_int;


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
                if (message[0] == '$' && message[5] == '^'){
                    if(message[1] == 'f' && message[2] == 'f' && message[3] == '1' && message[4] == '0' ){
                        mc.trailer_number = message[7];
                        if(message[8] == 1) {
                            mc.trailers[1].typeoftralier = Trailer.typeoftraliers.PLATFORM;}
                        else if (message[8]==2){
                            mc.trailers[1].typeoftralier = Trailer.typeoftraliers.TRAILER;}
                    }else if(message[1] == 'f' && message[2] == 'f' && message[3] == '2' && message[4] == '0' ){
                        trailerNo = (int)message[7];
                        if (message[8] == 0){mc.trailers[trailerNo].error = Trailer.errors.NON;}
                        else if(message[8] == 1){mc.trailers[trailerNo].error = Trailer.errors.CCU1;}
                        else if(message[8] == 2){mc.trailers[trailerNo].error = Trailer.errors.CCU2;}
                        else if(message[8] == 3){mc.trailers[trailerNo].error = Trailer.errors.CCUs;}
                        mc.trailers[trailerNo].numberOfAxles = (int)message[9];
                        mc.trailers[trailerNo].numberOfWheels= (int)message[10];
                    }else if(message[1] == 'f' && message[2] == 'f' && message[3] == '3' && message[4] == '0' ){
                        trailerNo = message[7]-48;
                        for (int i =0 ; i<8 ; i++){
                            stat_int = message[(8+i)]/64;
                            addr_int = message[(8+i)]%64;
                            switch (stat_int){
                                case 0:    {mc.trailers[trailerNo].wheels[addr_int].status = Trailer.Wheel.statuses.BLACK;}
                                case 1:    {mc.trailers[trailerNo].wheels[addr_int].status = Trailer.Wheel.statuses.GREEN;}
                                case 2:    {mc.trailers[trailerNo].wheels[addr_int].status = Trailer.Wheel.statuses.ORANGE;}
                                case 3:    {mc.trailers[trailerNo].wheels[addr_int].status = Trailer.Wheel.statuses.RED;}
                            }
                        }
                    }else if(message[1] == 'f' && message[2] == 'f' && message[3] == '4' && message[4] == '0' ){

                    }
                }
                mc.update_trailers();
            } catch (IOException e) {
                Log.e("UDP Client has IOE", "error: ", e);
                run = false;
            }
        }
    }
}
