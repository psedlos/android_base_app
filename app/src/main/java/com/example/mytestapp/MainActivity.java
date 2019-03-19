package com.example.mytestapp;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TableLayout;


public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab;
    ImageButton btn0st;
    ImageButton btn1st;
    ImageButton btn2nd;
    ImageButton btn3rd;
    ImageButton btn4th;
    ImageButton btn5th;
    ImageButton[] btnwheels;
    public TableLayout wheels_table;
    public Trailer[] trailers;
    int which_trailer_show;

    static String TAG = "MainActivity";

    public void show_trailer(int trailer_number, TableLayout wheels_table, Trailer[] trailers, ImageButton[] btnwheels) {
        if (trailer_number<0 || trailer_number >6) {
            wheels_table.setVisibility(View.INVISIBLE);
        }
        else{
            wheels_table.setVisibility(View.VISIBLE);
            /*for(int i = 0 ; i<64 ; i++){
                if(trailers[trailer_number].wheels[i].status == trailer.statuses.GREEN){
                    btnwheels[i].setBackgroundColor(Color.green(1));}
                else if(trailers[trailer_number].wheels[i].status == trailer.statuses.ORANGE){
                    btnwheels[i].setBackgroundColor(Color.red(10));}
                else if(trailers[trailer_number].wheels[i].status == trailer.statuses.RED){
                    btnwheels[i].setBackgroundColor(Color.red(1));}


            }*/
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        ImageButton btn0st = (findViewById(R.id.truck));
        final ImageButton btn1st = (findViewById(R.id.first_platform));
        ImageButton btn2nd = (findViewById(R.id.second_platform));
        ImageButton btn3rd = (findViewById(R.id.third_platform));
        ImageButton btn4th = (findViewById(R.id.fourth_platform));
        ImageButton btn5th = (findViewById(R.id.fifth_platform));
        final ImageButton[] btnwheels = {(findViewById(R.id.tyre00)),(findViewById(R.id.tyre01)),(findViewById(R.id.tyre02)),(findViewById(R.id.tyre03)),(findViewById(R.id.tyre04)),(findViewById(R.id.tyre05)),(findViewById(R.id.tyre06)),(findViewById(R.id.tyre07)),(findViewById(R.id.tyre08)),(findViewById(R.id.tyre09)),(findViewById(R.id.tyre10)),(findViewById(R.id.tyre11)),(findViewById(R.id.tyre12)),(findViewById(R.id.tyre13)),(findViewById(R.id.tyre14)),(findViewById(R.id.tyre15)),(findViewById(R.id.tyre16)),(findViewById(R.id.tyre17)),(findViewById(R.id.tyre18)),(findViewById(R.id.tyre19)),(findViewById(R.id.tyre20)),(findViewById(R.id.tyre21)),(findViewById(R.id.tyre22)),(findViewById(R.id.tyre23)),(findViewById(R.id.tyre24)),(findViewById(R.id.tyre25)),(findViewById(R.id.tyre26)),(findViewById(R.id.tyre27)),(findViewById(R.id.tyre28)),(findViewById(R.id.tyre29)),(findViewById(R.id.tyre30)),(findViewById(R.id.tyre31)),(findViewById(R.id.tyre32)),(findViewById(R.id.tyre33)),(findViewById(R.id.tyre34)),(findViewById(R.id.tyre35)),(findViewById(R.id.tyre36)),(findViewById(R.id.tyre37)),(findViewById(R.id.tyre38)),(findViewById(R.id.tyre39)),(findViewById(R.id.tyre40)),(findViewById(R.id.tyre41)),(findViewById(R.id.tyre42)),(findViewById(R.id.tyre43)),(findViewById(R.id.tyre44)),(findViewById(R.id.tyre45)),(findViewById(R.id.tyre46)),(findViewById(R.id.tyre47)),(findViewById(R.id.tyre48)),(findViewById(R.id.tyre49)),(findViewById(R.id.tyre50)),(findViewById(R.id.tyre51)),(findViewById(R.id.tyre52)),(findViewById(R.id.tyre53)),(findViewById(R.id.tyre54)),(findViewById(R.id.tyre55)),(findViewById(R.id.tyre56)),(findViewById(R.id.tyre57)),(findViewById(R.id.tyre58)),(findViewById(R.id.tyre59)),(findViewById(R.id.tyre60)),(findViewById(R.id.tyre61)),(findViewById(R.id.tyre62)),(findViewById(R.id.tyre63))};
        final TableLayout wheels_table = (findViewById(R.id.wheels_table));

        Log.i(TAG, "It is alive!");
        final Trailer[] trailers = new Trailer[6];
        for (int i = 0; i<trailers.length; i++){
            trailers[i]=new Trailer();
            for(int j = 0 ; j<trailers[i].wheels.length; j++) {
                trailers[i].wheels[j] = trailers[i].new Wheel();
        }}
        which_trailer_show  = -1;
        show_trailer(which_trailer_show, wheels_table, trailers, btnwheels);
        trailers[1].wheels[10].updateWheel(40,10, Trailer.errors.NON);
        trailers[2].wheels[10].updateWheel(40,10, Trailer.errors.NON);
        trailers[1].wheels[19].updateWheel(40,10, Trailer.errors.NON);
        trailers[1].wheels[30].updateWheel(40,10, Trailer.errors.NON);
        trailers[1].wheels[1].updateWheel(40,10, Trailer.errors.NON);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btn0st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w){
                Log.i(TAG, "Button 0");
                which_trailer_show = 0;
                show_trailer(which_trailer_show , wheels_table, trailers, btnwheels);
            }
        });

        btn1st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w){
                Log.i(TAG, "Button 1");
                which_trailer_show = 1;
                show_trailer(which_trailer_show , wheels_table, trailers, btnwheels);            }
        });

        btn2nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w){
                Log.i(TAG, "Button 2");
                which_trailer_show = 2;
                show_trailer(which_trailer_show , wheels_table, trailers, btnwheels);
            }
        });

        btn3rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w){
                Log.i(TAG, "Button 3");
                which_trailer_show = 3;
                show_trailer(which_trailer_show , wheels_table, trailers, btnwheels);
            }
        });

        btn4th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w){
                Log.i(TAG, "Button 4");
                which_trailer_show = 4;
                show_trailer(which_trailer_show , wheels_table, trailers, btnwheels);
            }
        });

        btn5th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w){
                Log.i(TAG, "Button 5");
                which_trailer_show = 5;
                show_trailer(which_trailer_show , wheels_table, trailers, btnwheels);
            }
        });
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
