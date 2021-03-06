package com.example.mytestapp;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.hardware.camera2.params.BlackLevelPattern;
import android.net.sip.SipSession;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityManagerCompat;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TableLayout;
import android.widget.TextView;

import java.io.StringBufferInputStream;

import static com.example.mytestapp.BaseActivity.mc;
//import android.support.design.R;


public class MainContainer extends Application {


    int which_trailer_show;
    int which_tyre_show;
    int tyre_number;
    ImageButton[] btntrailers;
    String tyre_description;
    Trailer[] trailers;
    TextView tyre_text;
    int trailers_number;
    MyRecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    Context mainActivityContext;
    MyRecyclerViewAdapter.ItemClickListener mainActivityItemClickListener;
    ClientSend send;


    public void mainContainerFeed(MyRecyclerViewAdapter adapter, RecyclerView recyclerView, Context mainActivityContext, MyRecyclerViewAdapter.ItemClickListener mainActivityItemClickListener) {
        if(this.trailers == null){
            this.trailers = new Trailer[11];
            for (int i = 0; i < trailers.length; i++) {
                this.trailers[i] = new Trailer();
                for (int j = 0; j < trailers[i].wheels.length; j++) {
                    this.trailers[i].wheels[j] = trailers[i].new Wheel();
                }
            }
            this.trailers[0].typeoftralier = Trailer.typeoftraliers.TRUCK;
        }
        this.adapter = adapter;
        this.recyclerView =recyclerView;
        this.mainActivityContext = mainActivityContext ;
        this.mainActivityItemClickListener = mainActivityItemClickListener;
    }
    public MainContainer() {
        this.trailers = new Trailer[11];
        for (int i = 0; i < trailers.length; i++) {
            this.trailers[i] = new Trailer();
            for (int j = 0; j < trailers[i].wheels.length; j++) {
                this.trailers[i].wheels[j] = trailers[i].new Wheel();
            }
        }
        this.trailers[0].typeoftralier = Trailer.typeoftraliers.TRUCK;
        this.trailers_number=10;
    }
    public void  update_trailers(){
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
        ViewGroup.LayoutParams layoutparams;
        for(int i=1; i< trailers.length; i++) {
            btntrailers[i].invalidate();
            layoutparams = (ViewGroup.LayoutParams) btntrailers[i].getLayoutParams();
            if (i > trailers_number) {
                btntrailers[i].setVisibility(View.INVISIBLE);
            } else if (trailers[i].numberOfAxles == 2) {
                layoutparams.width = 60;
                if (trailers[i].error == Trailer.errors.CCU1) {
                    btntrailers[i].setImageResource(R.mipmap.tralier2ccu_eng);
                } else if (trailers[i].error == Trailer.errors.CCU2) {
                    btntrailers[i].setImageResource(R.mipmap.tralier2ccu_eng);
                } else if (trailers[i].error == Trailer.errors.CCUs) {
                    btntrailers[i].setImageResource(R.mipmap.tralier2unconnected_eng);
                } else if (trailers[i].error == Trailer.errors.MPCB) {
                    btntrailers[i].setImageResource(R.mipmap.tralier2mpcb_eng);
                } else if (trailers[i].error == Trailer.errors.NON) {
                    if (trailers[i].status == Trailer.statuses.BLACK) {
                        btntrailers[i].setImageResource(R.mipmap.tralier2unconnected_eng);
                    } else if (trailers[i].status == Trailer.statuses.RED) {
                        btntrailers[i].setImageResource(R.mipmap.tralier2red_eng);
                    } else if (trailers[i].status == Trailer.statuses.ORANGE) {
                        btntrailers[i].setImageResource(R.mipmap.tralier2orange_eng);
                    } else if (trailers[i].status == Trailer.statuses.GREEN) {
                        btntrailers[i].setImageResource(R.mipmap.tralier2green_eng);
                    }
                }
            } else if (trailers[i].numberOfAxles == 3) {
                layoutparams.width = 80;
                if (trailers[i].error == Trailer.errors.CCU1) {
                    btntrailers[i].setImageResource(R.mipmap.tralier3ccu_eng);
                } else if (trailers[i].error == Trailer.errors.CCU2) {
                    btntrailers[i].setImageResource(R.mipmap.tralier3ccu_eng);
                } else if (trailers[i].error == Trailer.errors.CCUs) {
                    btntrailers[i].setImageResource(R.mipmap.tralier3unconnected_eng);
                } else if (trailers[i].error == Trailer.errors.MPCB) {
                    btntrailers[i].setImageResource(R.mipmap.tralier3mpcb_eng);
                } else if (trailers[i].error == Trailer.errors.NON) {
                    if (trailers[i].status == Trailer.statuses.BLACK) {
                        btntrailers[i].setImageResource(R.mipmap.tralier3unconnected_eng);
                    } else if (trailers[i].status == Trailer.statuses.RED) {
                        btntrailers[i].setImageResource(R.mipmap.tralier3red_eng);
                    } else if (trailers[i].status == Trailer.statuses.ORANGE) {
                        btntrailers[i].setImageResource(R.mipmap.tralier3orange_eng);
                    } else if (trailers[i].status == Trailer.statuses.GREEN) {
                        btntrailers[i].setImageResource(R.mipmap.tralier3green_eng);
                    }
                }
            } else if (trailers[i].numberOfAxles == 4) {
                layoutparams.width = 100;
                if (trailers[i].error == Trailer.errors.CCU1) {
                    btntrailers[i].setImageResource(R.mipmap.tralier4ccu_eng);
                } else if (trailers[i].error == Trailer.errors.CCU2) {
                    btntrailers[i].setImageResource(R.mipmap.tralier4ccu_eng);
                } else if (trailers[i].error == Trailer.errors.CCUs) {
                    btntrailers[i].setImageResource(R.mipmap.tralier4unconnected_eng);
                } else if (trailers[i].error == Trailer.errors.MPCB) {
                    btntrailers[i].setImageResource(R.mipmap.tralier4mpcb_eng);
                } else if (trailers[i].error == Trailer.errors.NON) {
                    if (trailers[i].status == Trailer.statuses.BLACK) {
                        btntrailers[i].setImageResource(R.mipmap.tralier4unconnected_eng);
                    } else if (trailers[i].status == Trailer.statuses.RED) {
                        btntrailers[i].setImageResource(R.mipmap.tralier4red_eng);
                    } else if (trailers[i].status == Trailer.statuses.ORANGE) {
                        btntrailers[i].setImageResource(R.mipmap.tralier4orange_eng);
                    } else if (trailers[i].status == Trailer.statuses.GREEN) {
                        btntrailers[i].setImageResource(R.mipmap.tralier4green_eng);
                    }
                }
            } else if (trailers[i].numberOfAxles == 5) {
                layoutparams.width = 120;
                if (trailers[i].error == Trailer.errors.CCU1) {
                    btntrailers[i].setImageResource(R.mipmap.tralier5ccu_eng);
                } else if (trailers[i].error == Trailer.errors.CCU2) {
                    btntrailers[i].setImageResource(R.mipmap.tralier5ccu_eng);
                } else if (trailers[i].error == Trailer.errors.CCUs) {
                    btntrailers[i].setImageResource(R.mipmap.tralier5unconnected_eng);
                } else if (trailers[i].error == Trailer.errors.MPCB) {
                    btntrailers[i].setImageResource(R.mipmap.tralier5mpcb_eng);
                } else if (trailers[i].error == Trailer.errors.NON) {
                    if (trailers[i].status == Trailer.statuses.BLACK) {
                        btntrailers[i].setImageResource(R.mipmap.tralier5unconnected_eng);
                    } else if (trailers[i].status == Trailer.statuses.RED) {
                        btntrailers[i].setImageResource(R.mipmap.tralier5red_eng);
                    } else if (trailers[i].status == Trailer.statuses.ORANGE) {
                        btntrailers[i].setImageResource(R.mipmap.tralier5orange_eng);
                    } else if (trailers[i].status == Trailer.statuses.GREEN) {
                        btntrailers[i].setImageResource(R.mipmap.tralier5green_eng);
                    }
                }
            } else if (trailers[i].numberOfAxles == 6) {
                layoutparams.width = 140;
                if (trailers[i].error == Trailer.errors.CCU1) {
                    btntrailers[i].setImageResource(R.mipmap.tralier6ccu_eng);
                } else if (trailers[i].error == Trailer.errors.CCU2) {
                    btntrailers[i].setImageResource(R.mipmap.tralier6ccu_eng);
                } else if (trailers[i].error == Trailer.errors.CCUs) {
                    btntrailers[i].setImageResource(R.mipmap.tralier6unconnected_eng);
                } else if (trailers[i].error == Trailer.errors.MPCB) {
                    btntrailers[i].setImageResource(R.mipmap.tralier6mpcb_eng);
                } else if (trailers[i].error == Trailer.errors.NON) {
                    if (trailers[i].status == Trailer.statuses.BLACK) {
                        btntrailers[i].setImageResource(R.mipmap.tralier6unconnected_eng);
                    } else if (trailers[i].status == Trailer.statuses.RED) {
                        btntrailers[i].setImageResource(R.mipmap.tralier6red_eng);
                    } else if (trailers[i].status == Trailer.statuses.ORANGE) {
                        btntrailers[i].setImageResource(R.mipmap.tralier6orange_eng);
                    } else if (trailers[i].status == Trailer.statuses.GREEN) {
                        btntrailers[i].setImageResource(R.mipmap.tralier6green_eng);
                    }
                }
            }
            btntrailers[i].setLayoutParams(layoutparams);
            btntrailers[i].postInvalidate();

        }
            }});
    }
    public void show_trailer() {
        recyclerView.invalidateItemDecorations();
        if (this.which_trailer_show<0 || this.which_trailer_show >11) {
            recyclerView.setVisibility(View.INVISIBLE);
        }
        else{
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    for (int i =0 ; i<trailers[which_trailer_show].wheels.length ; i++){
                        trailers[which_trailer_show].wheels[i].selected=false;
                    }
                    recyclerView.setVisibility(View.VISIBLE);
                    tyre_text.setVisibility(View.INVISIBLE);
                    adapter.updateNumberOfGrids(trailers[which_trailer_show].wheels);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    which_tyre_show = -1;
                }
            });
        }
    }
    public void show_trailer(final int tyre_number) {
        recyclerView.invalidateItemDecorations();
        if (this.which_trailer_show<0 || this.which_trailer_show >11) {
            recyclerView.setVisibility(View.INVISIBLE);
        }
        else{
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    recyclerView.setVisibility(View.VISIBLE);
                    adapter.updateNumberOfGrids(trailers[which_trailer_show].wheels);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    tyre_text.setVisibility(View.VISIBLE);
                    trailers[which_trailer_show].wheels[tyre_number].selected=true;
                    tyre_description = "Pressure: " + trailers[which_trailer_show].wheels[mc.tyre_number].getPress() + "\n" + "Temperature: " + trailers[which_trailer_show].wheels[mc.tyre_number].getTemp();
                    tyre_text.setText(tyre_description);
                }
            });
        }
    }
    public void show_tyre(final int tyre_number){
        this.tyre_number = tyre_number;
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                tyre_text.setVisibility(View.VISIBLE);
                for (int i =0 ; i<trailers[which_trailer_show].wheels.length ; i++){
                    trailers[which_trailer_show].wheels[i].selected=false;
                }
                trailers[which_trailer_show].wheels[tyre_number].selected=true;
                which_tyre_show = tyre_number;
                adapter.notifyDataSetChanged();
                tyre_description = "Pressure: " + trailers[which_trailer_show].wheels[mc.tyre_number].getPress() + "\n" + "Temperature: " + trailers[which_trailer_show].wheels[mc.tyre_number].getTemp();
                tyre_text.setText(tyre_description);
            }
        });
        new ClientSend().sendText("1234");
    }
    public void distribuate_data(int[] intmessage){
        int trailerNo;
        int stat_int;
        int addr_int;
        if (intmessage[0] == '$' && intmessage[5] == '^') {
            //FF10
            if (intmessage[1] == 'f' && intmessage[2] == 'f' && intmessage[3] == '1' && intmessage[4] == '0') {
                this.trailers_number = intmessage[7];
                if (intmessage[8] == 1) {
                    this.trailers[1].typeoftralier = Trailer.typeoftraliers.PLATFORM;
                } else if (intmessage[8] == 2) {
                    this.trailers[1].typeoftralier = Trailer.typeoftraliers.TRAILER;
                }
                this.update_trailers();
            } //FF20
            else if (intmessage[1] == 'f' && intmessage[2] == 'f' && intmessage[3] == '2' && intmessage[4] == '0') {
                trailerNo = intmessage[7]-48;//these -48 has to be discussed with server developer
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
                if (this.trailers[trailerNo].numberOfWheels !=this.trailers[trailerNo].wheels.length) {
                    this.trailers[trailerNo].wheels = new Trailer.Wheel[this.trailers[trailerNo].numberOfWheels];
                    for (int j = 0; j < trailers[trailerNo].wheels.length; j++) {
                        this.trailers[trailerNo].wheels[j] = trailers[trailerNo].new Wheel();
                    }
                }
                if(intmessage[11]==0){this.trailers[trailerNo].configurationError = false;}
                else {this.trailers[trailerNo].configurationError = true;}
                this.update_trailers();
            } //FF30
            else if (intmessage[1] == 'f' && intmessage[2] == 'f' && intmessage[3] == '3' && intmessage[4] == '0') {
                trailerNo = intmessage[7] - 48;//these -48 has to be discussed with server developer
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
                if(trailerNo == which_trailer_show){
                    if(which_tyre_show !=-1){
                        show_trailer(which_tyre_show);
                    } else {
                        show_trailer();
                    }
                }
            } //FF40
            else if (intmessage[1] == 'f' && intmessage[2] == 'f' && intmessage[3] == '4' && intmessage[4] == '0') {

            }
        }
        //this.show_trailer();
        //this.update_trailers();

    }
}
