package com.example.mytestapp;


import android.app.Activity;
import android.content.Context;
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


public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener{
    FloatingActionButton fab;
    static String TAG = "MainActivity";

    Looper looper;

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


    MyRecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    MainContainer mc= new MainContainer(adapter, recyclerView);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);

        String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64"};
        RecyclerView recyclerView = findViewById(R.id.rvNumbers);
        int numberOfColumn = 8;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumn));
        adapter = new MyRecyclerViewAdapter(this, data);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        mc= new MainContainer(adapter, recyclerView);
        //final MainContainer mc = new MainContainer(adapter);


        mc.btntrailers = new ImageButton[] {findViewById(R.id.truck),findViewById(R.id.first_platform),findViewById(R.id.second_platform),findViewById(R.id.third_platform),findViewById(R.id.fourth_platform),findViewById(R.id.fifth_platform),findViewById(R.id.sixth_platform),findViewById(R.id.seventh_platform),findViewById(R.id.eight_platform),findViewById(R.id.nineth_platform),findViewById(R.id.tenth_platform)};
        //mc.btnwheels = new ImageButton[] {(findViewById(R.id.tyre00)),(findViewById(R.id.tyre01)),(findViewById(R.id.tyre02)),(findViewById(R.id.tyre03)),(findViewById(R.id.tyre04)),(findViewById(R.id.tyre05)),(findViewById(R.id.tyre06)),(findViewById(R.id.tyre07)),(findViewById(R.id.tyre08)),(findViewById(R.id.tyre09)),(findViewById(R.id.tyre10)),(findViewById(R.id.tyre11)),(findViewById(R.id.tyre12)),(findViewById(R.id.tyre13)),(findViewById(R.id.tyre14)),(findViewById(R.id.tyre15)),(findViewById(R.id.tyre16)),(findViewById(R.id.tyre17)),(findViewById(R.id.tyre18)),(findViewById(R.id.tyre19)),(findViewById(R.id.tyre20)),(findViewById(R.id.tyre21)),(findViewById(R.id.tyre22)),(findViewById(R.id.tyre23)),(findViewById(R.id.tyre24)),(findViewById(R.id.tyre25)),(findViewById(R.id.tyre26)),(findViewById(R.id.tyre27)),(findViewById(R.id.tyre28)),(findViewById(R.id.tyre29)),(findViewById(R.id.tyre30)),(findViewById(R.id.tyre31)),(findViewById(R.id.tyre32)),(findViewById(R.id.tyre33)),(findViewById(R.id.tyre34)),(findViewById(R.id.tyre35)),(findViewById(R.id.tyre36)),(findViewById(R.id.tyre37)),(findViewById(R.id.tyre38)),(findViewById(R.id.tyre39)),(findViewById(R.id.tyre40)),(findViewById(R.id.tyre41)),(findViewById(R.id.tyre42)),(findViewById(R.id.tyre43)),(findViewById(R.id.tyre44)),(findViewById(R.id.tyre45)),(findViewById(R.id.tyre46)),(findViewById(R.id.tyre47)),(findViewById(R.id.tyre48)),(findViewById(R.id.tyre49)),(findViewById(R.id.tyre50)),(findViewById(R.id.tyre51)),(findViewById(R.id.tyre52)),(findViewById(R.id.tyre53)),(findViewById(R.id.tyre54)),(findViewById(R.id.tyre55)),(findViewById(R.id.tyre56)),(findViewById(R.id.tyre57)),(findViewById(R.id.tyre58)),(findViewById(R.id.tyre59)),(findViewById(R.id.tyre60)),(findViewById(R.id.tyre61)),(findViewById(R.id.tyre62)),(findViewById(R.id.tyre63))};

        //mc.wheels_table = (findViewById(R.id.wheels_table));
        mc.tyre_text =findViewById(R.id.tyretext);
        mc.trailers = new Trailer[11];
        for (int i = 0; i<mc.trailers.length; i++){
            mc.trailers[i]=new Trailer();
            for(int j = 0 ; j<mc.trailers[i].wheels.length; j++) {
                mc.trailers[i].wheels[j] = mc.trailers[i].new Wheel();
            }
        }
        Log.i(TAG, "It is alive!");
        mc.tyre_text.setVisibility(View.INVISIBLE);
        mc.which_trailer_show= -1;
        populate_data(mc);
        //mc.update_trailers();
        //mc.show_trailer();


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();}
        });
       // for(int i=0 ;i<64; i++){mc.btnwheels[0] = adapter.}

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
        
        //mc.btnwheels = adapter.getmImageViews();
//        looper.prepare();

        Runnable clientListen = new ClientListen(mc/*,screenUpdate*/);

        //runOnUiThread(clientListen);
        Thread UDPList = new Thread( clientListen );
        //Thread SCRupd = new Thread ( screenUpdate);
//        runOnUiThread(UDPList);
        //mc.update_trailers();
        //mc.show_trailer();
        //SCRupd.start();

        UDPList.start();

        mc.update_trailers();
        mc.show_trailer();
 //       mc.setListener(mc.listener);

       // ((ScreenUpdate) screenUpdate).call();
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.i("TAG", "You clicked number " + adapter.getItem(position) + ", which is at cell position " + position);
        mc.show_tyre(position);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
