package com.example.mytestapp;

import android.app.Application;
import android.hardware.camera2.params.BlackLevelPattern;
import android.net.sip.SipSession;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TableLayout;
import android.widget.TextView;


public class MainContainer extends Application {


    int which_trailer_show;
    ImageButton[] btntrailers;
    String tyre_description;
    Trailer[] trailers;
    TextView tyre_text;
    int trailer_number;
    MyRecyclerViewAdapter adapter;
    RecyclerView recyclerView;

    public MainContainer(MyRecyclerViewAdapter adapter, RecyclerView recyclerView) {
        this.trailers = new Trailer[11];
        for (int i = 0; i < trailers.length; i++) {
            this.trailers[i] = new Trailer();
            for (int j = 0; j < trailers[i].wheels.length; j++) {
                this.trailers[i].wheels[j] = trailers[i].new Wheel();
            }
        }
        this.trailers[0].typeoftralier = Trailer.typeoftraliers.TRUCK;
        this.adapter = adapter;
        this.recyclerView =recyclerView;
    }
    public void  update_trailers(){
        ViewGroup.LayoutParams layoutparams;
        for(int i=1; i< this.trailers.length; i++){
            this.btntrailers[i].invalidate();
            layoutparams = (ViewGroup.LayoutParams) this.btntrailers[i].getLayoutParams();
            if(this.trailers[i].numberOfAxles==2){
                layoutparams.width = 60;
                if(this.trailers[i].error == Trailer.errors.CCU1){
                    this.btntrailers[i].setImageResource(R.mipmap.tralier2ccu_eng);
                } else if (this.trailers[i].error == Trailer.errors.CCU2){
                    this.btntrailers[i].setImageResource(R.mipmap.tralier2ccu_eng);
                } else if (this.trailers[i].error == Trailer.errors.CCUs){
                    this.btntrailers[i].setImageResource(R.mipmap.tralier2unconnected_eng);
                } else if (this.trailers[i].error == Trailer.errors.MPCB){
                    this.btntrailers[i].setImageResource(R.mipmap.tralier2mpcb_eng);
                } else if (this.trailers[i].error == Trailer.errors.NON){
                    if(this.trailers[i].status== Trailer.statuses.BLACK){
                        this.btntrailers[i].setImageResource(R.mipmap.tralier2unconnected_eng);
                    } else if (this.trailers[i].status== Trailer.statuses.RED){
                        this.btntrailers[i].setImageResource(R.mipmap.tralier2red_eng);
                    } else if (this.trailers[i].status== Trailer.statuses.ORANGE){
                        this.btntrailers[i].setImageResource(R.mipmap.tralier2orange_eng);
                    } else if (this.trailers[i].status== Trailer.statuses.GREEN) {
                        this.btntrailers[i].setImageResource(R.mipmap.tralier2green_eng);
                    }
                }
            } else if(this.trailers[i].numberOfAxles==3) {
                layoutparams.width = 80;
                if(this.trailers[i].error == Trailer.errors.CCU1){
                    this.btntrailers[i].setImageResource(R.mipmap.tralier3ccu_eng);
                } else if (this.trailers[i].error == Trailer.errors.CCU2){
                    this.btntrailers[i].setImageResource(R.mipmap.tralier3ccu_eng);
                } else if (this.trailers[i].error == Trailer.errors.CCUs){
                    this.btntrailers[i].setImageResource(R.mipmap.tralier3unconnected_eng);
                } else if (this.trailers[i].error == Trailer.errors.MPCB){
                    this.btntrailers[i].setImageResource(R.mipmap.tralier3mpcb_eng);
                } else if (this.trailers[i].error == Trailer.errors.NON){
                    if(this.trailers[i].status== Trailer.statuses.BLACK){
                        this.btntrailers[i].setImageResource(R.mipmap.tralier3unconnected_eng);
                    } else if (this.trailers[i].status== Trailer.statuses.RED){
                        this.btntrailers[i].setImageResource(R.mipmap.tralier3red_eng);
                    } else if (this.trailers[i].status== Trailer.statuses.ORANGE){
                        this.btntrailers[i].setImageResource(R.mipmap.tralier3orange_eng);
                    } else if (this.trailers[i].status== Trailer.statuses.GREEN) {
                        this.btntrailers[i].setImageResource(R.mipmap.tralier3green_eng);
                    }
                }
            } else if(this.trailers[i].numberOfAxles==4) {
                layoutparams.width = 100;
                if(this.trailers[i].error == Trailer.errors.CCU1){
                    this.btntrailers[i].setImageResource(R.mipmap.tralier4ccu_eng);
                } else if (this.trailers[i].error == Trailer.errors.CCU2){
                    this.btntrailers[i].setImageResource(R.mipmap.tralier4ccu_eng);
                } else if (this.trailers[i].error == Trailer.errors.CCUs){
                    this.btntrailers[i].setImageResource(R.mipmap.tralier4unconnected_eng);
                } else if (this.trailers[i].error == Trailer.errors.MPCB){
                    this.btntrailers[i].setImageResource(R.mipmap.tralier4mpcb_eng);
                } else if (this.trailers[i].error == Trailer.errors.NON){
                    if(this.trailers[i].status== Trailer.statuses.BLACK){
                        this.btntrailers[i].setImageResource(R.mipmap.tralier4unconnected_eng);
                    } else if (this.trailers[i].status== Trailer.statuses.RED){
                        this.btntrailers[i].setImageResource(R.mipmap.tralier4red_eng);
                    } else if (this.trailers[i].status== Trailer.statuses.ORANGE){
                        this.btntrailers[i].setImageResource(R.mipmap.tralier4orange_eng);
                    } else if (this.trailers[i].status== Trailer.statuses.GREEN) {
                        this.btntrailers[i].setImageResource(R.mipmap.tralier4green_eng);
                    }
                }
            } else if(this.trailers[i].numberOfAxles==5) {
                layoutparams.width = 120;
                if(this.trailers[i].error == Trailer.errors.CCU1){
                    this.btntrailers[i].setImageResource(R.mipmap.tralier5ccu_eng);
                } else if (this.trailers[i].error == Trailer.errors.CCU2){
                    this.btntrailers[i].setImageResource(R.mipmap.tralier5ccu_eng);
                } else if (this.trailers[i].error == Trailer.errors.CCUs){
                    this.btntrailers[i].setImageResource(R.mipmap.tralier5unconnected_eng);
                } else if (this.trailers[i].error == Trailer.errors.MPCB){
                    this.btntrailers[i].setImageResource(R.mipmap.tralier5mpcb_eng);
                } else if (this.trailers[i].error == Trailer.errors.NON){
                    if(this.trailers[i].status== Trailer.statuses.BLACK){
                        this.btntrailers[i].setImageResource(R.mipmap.tralier5unconnected_eng);
                    } else if (this.trailers[i].status== Trailer.statuses.RED){
                        this.btntrailers[i].setImageResource(R.mipmap.tralier5red_eng);
                    } else if (this.trailers[i].status== Trailer.statuses.ORANGE){
                        this.btntrailers[i].setImageResource(R.mipmap.tralier5orange_eng);
                    } else if (this.trailers[i].status== Trailer.statuses.GREEN) {
                        this.btntrailers[i].setImageResource(R.mipmap.tralier5green_eng);
                    }
                }
            } else if(this.trailers[i].numberOfAxles==6) {
                layoutparams.width = 140;
                if(this.trailers[i].error == Trailer.errors.CCU1){
                    this.btntrailers[i].setImageResource(R.mipmap.tralier6ccu_eng);
                } else if (this.trailers[i].error == Trailer.errors.CCU2){
                    this.btntrailers[i].setImageResource(R.mipmap.tralier6ccu_eng);
                } else if (this.trailers[i].error == Trailer.errors.CCUs){
                    this.btntrailers[i].setImageResource(R.mipmap.tralier6unconnected_eng);
                } else if (this.trailers[i].error == Trailer.errors.MPCB){
                    this.btntrailers[i].setImageResource(R.mipmap.tralier6mpcb_eng);
                } else if (this.trailers[i].error == Trailer.errors.NON){
                    if(this.trailers[i].status== Trailer.statuses.BLACK){
                        this.btntrailers[i].setImageResource(R.mipmap.tralier6unconnected_eng);
                    } else if (this.trailers[i].status== Trailer.statuses.RED){
                        this.btntrailers[i].setImageResource(R.mipmap.tralier6red_eng);
                    } else if (this.trailers[i].status== Trailer.statuses.ORANGE){
                        this.btntrailers[i].setImageResource(R.mipmap.tralier6orange_eng);
                    } else if (this.trailers[i].status== Trailer.statuses.GREEN) {
                        this.btntrailers[i].setImageResource(R.mipmap.tralier6green_eng);
                    }
                }
            }
            this.btntrailers[i].setLayoutParams(layoutparams);
            this.btntrailers[i].postInvalidate();
        }
    }
    public void show_trailer() {
        recyclerView.invalidateItemDecorations();
        if (this.which_trailer_show<0 || this.which_trailer_show >11) {
            recyclerView.setAlpha(0);
        }
        else{
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    recyclerView.setAlpha(1);
                    tyre_text.setVisibility(View.INVISIBLE);
                    for(int i = 0 ; i<64 ; i++){
                        adapter.imageView(i).invalidate();
                        if(trailers[which_trailer_show].wheels[i].status == Trailer.statuses.GREEN){
                            adapter.imageView(i).setImageResource(R.mipmap.green_tyre);}
                        else if(trailers[which_trailer_show].wheels[i].status == Trailer.statuses.ORANGE){
                            adapter.imageView(i).setImageResource(R.mipmap.yellow_tyre);}
                        else if(trailers[which_trailer_show].wheels[i].status == Trailer.statuses.RED){
                            adapter.imageView(i).setImageResource(R.mipmap.red_tyre);}
                        else if(trailers[which_trailer_show].wheels[i].status == Trailer.statuses.BLACK){
                            adapter.imageView(i).setImageResource(R.mipmap.tyre_black);}
                        adapter.imageView(i).postInvalidate();
                    }
                }
            });
        }

    }
    public void show_tyre(int tyre_number){
        tyre_text.setVisibility(View.VISIBLE);
        for (int i = 0; i < adapter.getItemCount(); i++) {
            //adapter.imageView(i).setBackgroundColor(getResources().getColor(R.color.buttonNormalBackground));
 //           adapter.imageView(i).clearColorFilter();
        }
       // adapter.imageView(tyre_number).colo

        tyre_description = "Pressure: " + trailers[which_trailer_show].wheels[tyre_number].getPress() + "\n" + "Temperature: " + trailers[which_trailer_show].wheels[tyre_number].getTemp();
        tyre_text.setText(tyre_description);
    }
    public void distribuate_data(int[] intmessage){
        int trailerNo;
        int stat_int;
        int addr_int;
        if (intmessage[0] == '$' && intmessage[5] == '^') {
            if (intmessage[1] == 'f' && intmessage[2] == 'f' && intmessage[3] == '1' && intmessage[4] == '0') {
                this.trailer_number = intmessage[7];
                if (intmessage[8] == 1) {
                    this.trailers[1].typeoftralier = Trailer.typeoftraliers.PLATFORM;
                } else if (intmessage[8] == 2) {
                    this.trailers[1].typeoftralier = Trailer.typeoftraliers.TRAILER;
                }
            } else if (intmessage[1] == 'f' && intmessage[2] == 'f' && intmessage[3] == '2' && intmessage[4] == '0') {
                trailerNo = intmessage[7];
                if (intmessage[8] == 0) {
                    this.trailers[trailerNo].error = Trailer.errors.NON;
                } else if (intmessage[8] == 1) {
                    this.trailers[trailerNo].error = Trailer.errors.CCU1;
                } else if (intmessage[8] == 2) {
                    this.trailers[trailerNo].error = Trailer.errors.CCU2;
                } else if (intmessage[8] == 3) {
                    this.trailers[trailerNo].error = Trailer.errors.CCUs;
                }
                this.trailers[trailerNo].numberOfAxles = intmessage[9];
                this.trailers[trailerNo].numberOfWheels = intmessage[10];
            } else if (intmessage[1] == 'f' && intmessage[2] == 'f' && intmessage[3] == '3' && intmessage[4] == '0') {
                trailerNo = intmessage[7] - 48;
                for (int i = 0; i < 8; i++) {
                    stat_int = intmessage[(8 + i)] / 64;
                    addr_int = intmessage[(8 + i)] % 64;
                    switch (stat_int) {
                        case 0:
                            this.trailers[trailerNo].wheels[addr_int].status = Trailer.Wheel.statuses.BLACK;
                            break;
                        case 1:
                            this.trailers[trailerNo].wheels[addr_int].status = Trailer.Wheel.statuses.GREEN;
                            break;
                        case 2:
                            this.trailers[trailerNo].wheels[addr_int].status = Trailer.Wheel.statuses.ORANGE;
                            break;
                        case 3:
                            this.trailers[trailerNo].wheels[addr_int].status = Trailer.Wheel.statuses.RED;
                            break;
                    }
                }
            } else if (intmessage[1] == 'f' && intmessage[2] == 'f' && intmessage[3] == '4' && intmessage[4] == '0') {

            }
        }
        this.show_trailer();

    }
}
