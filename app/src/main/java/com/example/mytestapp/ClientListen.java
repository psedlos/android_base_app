package com.example.mytestapp;

import android.app.Activity;
import android.os.Looper;
import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;


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
        Looper.prepare();
        boolean run = true;
        while (run) {
            try {
                DatagramSocket udpSocket = new DatagramSocket(null);
                if (udpSocket.isBound()) {
                    udpSocket.setReuseAddress(true);
                    Log.d("UDP Bound:", "address reused");
                }
                udpSocket.setReuseAddress(true);
                InetSocketAddress port = new InetSocketAddress(64442);
                udpSocket.bind(port);
                byte[] message = new byte[8000];
                DatagramPacket packet = new DatagramPacket(message, message.length);
                Log.i("UDP client:", "about to wait to receive");
                udpSocket.receive(packet);
                int[] intmessage = new int[8000];
                for (int i = 0; i < message.length; i++) {
                    intmessage[i] = message[i] & 0xff;
                }
                String text = new String(intmessage, 0, packet.getLength());
                Log.d("Received Data", text);

                if (intmessage[0] == '$' && intmessage[5] == '^') {
                    if (intmessage[1] == 'f' && intmessage[2] == 'f' && intmessage[3] == '1' && intmessage[4] == '0') {
                        mc.trailer_number = intmessage[7];
                        if (intmessage[8] == 1) {
                            mc.trailers[1].typeoftralier = Trailer.typeoftraliers.PLATFORM;
                        } else if (intmessage[8] == 2) {
                            mc.trailers[1].typeoftralier = Trailer.typeoftraliers.TRAILER;
                        }
                    } else if (intmessage[1] == 'f' && intmessage[2] == 'f' && intmessage[3] == '2' && intmessage[4] == '0') {
                        trailerNo = intmessage[7];
                        if (intmessage[8] == 0) {
                            mc.trailers[trailerNo].error = Trailer.errors.NON;
                        } else if (intmessage[8] == 1) {
                            mc.trailers[trailerNo].error = Trailer.errors.CCU1;
                        } else if (intmessage[8] == 2) {
                            mc.trailers[trailerNo].error = Trailer.errors.CCU2;
                        } else if (intmessage[8] == 3) {
                            mc.trailers[trailerNo].error = Trailer.errors.CCUs;
                        }
                        mc.trailers[trailerNo].numberOfAxles = intmessage[9];
                        mc.trailers[trailerNo].numberOfWheels = intmessage[10];
                    } else if (intmessage[1] == 'f' && intmessage[2] == 'f' && intmessage[3] == '3' && intmessage[4] == '0') {
                        trailerNo = intmessage[7] - 48;
                        for (int i = 0; i < 8; i++) {
                            stat_int = intmessage[(8 + i)] / 64;
                            addr_int = intmessage[(8 + i)] % 64;
                            switch (stat_int) {
                                case 0:
                                    mc.trailers[trailerNo].wheels[addr_int].status = Trailer.Wheel.statuses.BLACK;
                                    break;
                                case 1:
                                    mc.trailers[trailerNo].wheels[addr_int].status = Trailer.Wheel.statuses.GREEN;
                                    break;
                                case 2:
                                    mc.trailers[trailerNo].wheels[addr_int].status = Trailer.Wheel.statuses.ORANGE;
                                    break;
                                case 3:
                                    mc.trailers[trailerNo].wheels[addr_int].status = Trailer.Wheel.statuses.RED;
                                    break;
                            }
                        }
                    } else if (intmessage[1] == 'f' && intmessage[2] == 'f' && intmessage[3] == '4' && intmessage[4] == '0') {

                    }
                }
                mc.show_trailer();

            } catch (IOException e) {
                Log.e("UDP Client has IOE", "error: ", e);
                run = false;
            }
        }
    }
}
