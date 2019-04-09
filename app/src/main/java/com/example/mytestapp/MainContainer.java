package com.example.mytestapp;

import android.app.Application;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainContainer extends Application {

    ImageButton[] trbtn;
    ImageButton[] btnwheels;
    int which_trailer_show;
    ImageButton[] btntrailers;
    View tyre_info_view;
    String tyre_description;
    Trailer[] trailers;
    TextView tyre_text;
    int trailer_number;
    TableLayout wheels_table;

    public MainContainer() {
        Trailer[] trailers = new Trailer[11];
        for (int i = 0; i < trailers.length; i++) {
            trailers[i] = new Trailer();
            for (int j = 0; j < trailers[i].wheels.length; j++) {
                trailers[i].wheels[j] = trailers[i].new Wheel();
            }
        }
        trailers[0].typeoftralier = Trailer.typeoftraliers.TRUCK;
        ImageButton[] btnwheels;
        int which_trailer_show;
        ImageButton[] btntrailers;
        View tyre_info_view;
        String tyre_description;
        TextView tyre_text;
        int trailer_number;
        TableLayout wheels_table;
    }
    public void  update_trailers(){
        ViewGroup.LayoutParams layoutparams;
        for(int i=1; i< this.trailers.length; i++){
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
        }
    }
    public void show_trailer() {
        if (this.which_trailer_show<0 || this.which_trailer_show >11) {
            this.wheels_table.setVisibility(View.INVISIBLE);
        }
        else{
            this.wheels_table.setVisibility(View.VISIBLE);
            this.tyre_text.setVisibility(View.INVISIBLE);
            for(int i = 0 ; i<64 ; i++){
                this.btnwheels[i].setBackgroundColor(getResources().getColor(R.color.buttonNormalBackground));
                if(this.trailers[this.which_trailer_show].wheels[i].status == Trailer.statuses.GREEN){
                    this.btnwheels[i].setImageResource(R.mipmap.green_tyre);}
                else if(this.trailers[this.which_trailer_show].wheels[i].status == Trailer.statuses.ORANGE){
                    this.btnwheels[i].setImageResource(R.mipmap.yellow_tyre);}
                else if(this.trailers[this.which_trailer_show].wheels[i].status == Trailer.statuses.RED){
                    this.btnwheels[i].setImageResource(R.mipmap.red_tyre);}
                else if(this.trailers[this.which_trailer_show].wheels[i].status == Trailer.statuses.BLACK){
                    this.btnwheels[i].setImageResource(R.mipmap.tyre_black);}


            }
        }
    }
}
