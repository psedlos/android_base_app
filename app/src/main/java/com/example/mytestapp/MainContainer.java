package com.example.mytestapp;

import android.app.Application;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
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
        ImageButton[] btnwheels;
        int which_trailer_show;
        ImageButton[] btntrailers;
        View tyre_info_view;
        String tyre_description;
        TextView tyre_text;
        int trailer_number;
        TableLayout wheels_table;
    }
}
