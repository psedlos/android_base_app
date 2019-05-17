package com.example.mytestapp;

import android.app.Application;
import android.hardware.camera2.params.BlackLevelPattern;
import android.net.sip.SipSession;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TableLayout;
import android.widget.TextView;


public class MainContainer extends Application {

    ImageButton[] trbtn;
    ImageView[] btnwheels;
    int which_trailer_show;
    ImageButton[] btntrailers;
    View tyre_info_view;
    String tyre_description;
    Trailer[] trailers;
    TextView tyre_text;
    int trailer_number;
    TableLayout wheels_table;
    int screen_update=0;
    MyRecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    NumberPicker.OnValueChangeListener listener;
    NumberPicker picker;

/*    public class Screen_update implements Runnable {
        @Override
        public void run() {
            show_trailer();
        }
    }
    public void setListener(NumberPicker.OnValueChangeListener listener){
        this.listener = listener;
    }
    public void setScreen_update(int screen_update){
        this.screen_update = screen_update;
        if(listener != null) listener.onValueChange( picker,0, 1);
    }
    public NumberPicker.OnValueChangeListener getListener(){
        return listener;
    }
    public int isScreen_update (){
        return screen_update;
    }
    public interface OnValueChangeListener{
        void onChange();
    }*/

    public MainContainer(MyRecyclerViewAdapter adapter, RecyclerView recyclerView) {
        Trailer[] trailers = new Trailer[11];
        for (int i = 0; i < trailers.length; i++) {
            trailers[i] = new Trailer();
            for (int j = 0; j < trailers[i].wheels.length; j++) {
                trailers[i].wheels[j] = trailers[i].new Wheel();
            }
        }
        trailers[0].typeoftralier = Trailer.typeoftraliers.TRUCK;
        ImageView[] btnwheels;
        int which_trailer_show;
        ImageButton[] btntrailers;
        View tyre_info_view;
        String tyre_description;
        TextView tyre_text;
        int trailer_number;
        TableLayout wheels_table;
        Boolean screen_update = false;
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
/*            recyclerView.setAlpha(1);
            this.tyre_text.setVisibility(View.INVISIBLE);
            for(int i = 0 ; i<64 ; i++){
                adapter.imageView(i).invalidate();
                if(this.trailers[this.which_trailer_show].wheels[i].status == Trailer.statuses.GREEN){
                    adapter.imageView(i).setImageResource(R.mipmap.green_tyre);}
                else if(this.trailers[this.which_trailer_show].wheels[i].status == Trailer.statuses.ORANGE){
                    adapter.imageView(i).setImageResource(R.mipmap.yellow_tyre);}
                else if(this.trailers[this.which_trailer_show].wheels[i].status == Trailer.statuses.RED){
                    adapter.imageView(i).setImageResource(R.mipmap.red_tyre);}
                else if(this.trailers[this.which_trailer_show].wheels[i].status == Trailer.statuses.BLACK){
                    adapter.imageView(i).setImageResource(R.mipmap.tyre_black);}
                adapter.imageView(i).postInvalidate();
            }*/
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
}
