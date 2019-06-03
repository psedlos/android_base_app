package com.example.mytestapp;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.ContactsContract;
import android.support.annotation.UiThread;
import android.support.design.animation.ImageMatrixProperty;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import java.io.IOException;
import java.util.concurrent.Callable;


public class MainActivity extends BaseActivity implements MyRecyclerViewAdapter.ItemClickListener{
    static String TAG = "MainActivity";
    ClientSend clientSend = new ClientSend();
    void populate_data(MainContainer mc){
        mc.trailers[1].wheels[10].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.ORANGE);
        mc.trailers[1].wheels[12].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.ORANGE);
        mc.trailers[1].wheels[19].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.BLACK);
        mc.trailers[1].wheels[30].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.RED);
        mc.trailers[1].wheels[1].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.GREEN);
        mc.trailers[1].numberOfAxles = 5;
        mc.trailers[2].wheels[4].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.ORANGE);
        mc.trailers[2].wheels[12].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.ORANGE);
        mc.trailers[2].wheels[19].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.BLACK);
        mc.trailers[2].wheels[30].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.RED);
        mc.trailers[2].wheels[1].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.GREEN);
        mc.trailers[2].wheels[16].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.ORANGE);
        mc.trailers[2].wheels[10].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.ORANGE);
        mc.trailers[2].numberOfAxles = 4;
        mc.trailers[3].wheels[19].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.BLACK);
        mc.trailers[3].wheels[30].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.RED);
        mc.trailers[3].wheels[1].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.GREEN);
        mc.trailers[3].wheels[40].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.ORANGE);
        mc.trailers[3].wheels[10].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.ORANGE);
        mc.trailers[3].numberOfAxles = 4;
        mc.trailers[4].wheels[19].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.BLACK);
        mc.trailers[4].wheels[30].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.RED);
        mc.trailers[4].wheels[1].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.GREEN);
        mc.trailers[4].wheels[10].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.ORANGE);
        mc.trailers[4].numberOfAxles = 3;
        mc.trailers[5].wheels[10].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.ORANGE);
        mc.trailers[5].wheels[19].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.BLACK);
        mc.trailers[5].wheels[30].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.RED);
        mc.trailers[5].wheels[1].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.GREEN);
        mc.trailers[6].wheels[33].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.ORANGE);
        mc.trailers[6].wheels[10].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.ORANGE);
        mc.trailers[7].wheels[19].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.BLACK);
        mc.trailers[8].wheels[30].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.RED);
        mc.trailers[9].wheels[1].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.GREEN);
    }
    String textToSend = "text";

    MyRecyclerViewAdapter adapter;
    //MainContainer mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(this.mc == null)
        {mc = new MainContainer();}

        String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64"};
        RecyclerView recyclerView = findViewById(R.id.rvNumbers);
        int numberOfColumn = 8;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumn));
        adapter = new MyRecyclerViewAdapter(this, data);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        mc.mainContainerFeed(adapter, recyclerView);

        mc.btntrailers = new ImageButton[] {findViewById(R.id.truck),findViewById(R.id.first_platform),findViewById(R.id.second_platform),findViewById(R.id.third_platform),findViewById(R.id.fourth_platform),findViewById(R.id.fifth_platform),findViewById(R.id.sixth_platform),findViewById(R.id.seventh_platform),findViewById(R.id.eight_platform),findViewById(R.id.nineth_platform),findViewById(R.id.tenth_platform)};
        mc.tyre_text =findViewById(R.id.tyretext);

        Log.i(TAG, "It is alive!");
        mc.tyre_text.setVisibility(View.INVISIBLE);
        mc.which_trailer_show= -1;

        mc.btntrailers[0].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){Log.i(TAG, "Button 0"); mc.which_trailer_show = 0; mc.show_trailer();}});
        mc.btntrailers[1].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){Log.i(TAG, "Button 1"); mc.which_trailer_show = 1; mc.show_trailer();}});
        mc.btntrailers[2].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){Log.i(TAG, "Button 2"); mc.which_trailer_show = 2; mc.show_trailer();}});
        mc.btntrailers[3].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){Log.i(TAG, "Button 3"); mc.which_trailer_show = 3; mc.show_trailer();}});
        mc.btntrailers[4].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){Log.i(TAG, "Button 4"); mc.which_trailer_show = 4; mc.show_trailer();}});
        mc.btntrailers[5].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){Log.i(TAG, "Button 5"); mc.which_trailer_show = 5; mc.show_trailer();}});
        mc.btntrailers[6].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){Log.i(TAG, "Button 6"); mc.which_trailer_show = 6; mc.show_trailer();}});
        mc.btntrailers[7].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){Log.i(TAG, "Button 7"); mc.which_trailer_show = 7; mc.show_trailer();}});
        mc.btntrailers[8].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){Log.i(TAG, "Button 8"); mc.which_trailer_show = 8; mc.show_trailer();}});
        mc.btntrailers[9].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){Log.i(TAG, "Button 9"); mc.which_trailer_show = 9; mc.show_trailer();}});
        mc.btntrailers[10].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){Log.i(TAG, "Button 10"); mc.which_trailer_show = 10; mc.show_trailer();}});

//        Runnable clientListen = new ClientListen(mc);
//        Thread UDPList = new Thread( clientListen );
//        UDPList.start();



        mc.update_trailers();
        mc.show_trailer();
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.i("TAG", "You clicked number " + adapter.getItem(position) + ", which is at cell position " + position);
        mc.show_tyre(position);
    }
}
