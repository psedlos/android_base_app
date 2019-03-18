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
    FloatingActionButton fab = findViewById(R.id.fab);
    ImageButton btn0st = (ImageButton)(findViewById(R.id.truck));
    final ImageButton btn1st = (ImageButton)(findViewById(R.id.first_platform));
    ImageButton btn2nd = (ImageButton)(findViewById(R.id.second_platform));
    ImageButton btn3rd = (ImageButton)(findViewById(R.id.third_platform));
    ImageButton btn4th = (ImageButton)(findViewById(R.id.fourth_platform));
    ImageButton btn5th = (ImageButton)(findViewById(R.id.fifth_platform));
    ImageButton[] btnwheels = {(ImageButton)(findViewById(R.id.tyre00)),(ImageButton)(findViewById(R.id.tyre01)),(ImageButton)(findViewById(R.id.tyre02)),(ImageButton)(findViewById(R.id.tyre03)),(ImageButton)(findViewById(R.id.tyre04)),(ImageButton)(findViewById(R.id.tyre05)),(ImageButton)(findViewById(R.id.tyre06)),(ImageButton)(findViewById(R.id.tyre07)),(ImageButton)(findViewById(R.id.tyre08)),(ImageButton)(findViewById(R.id.tyre09)),(ImageButton)(findViewById(R.id.tyre10)),(ImageButton)(findViewById(R.id.tyre11)),(ImageButton)(findViewById(R.id.tyre12)),(ImageButton)(findViewById(R.id.tyre13)),(ImageButton)(findViewById(R.id.tyre14)),(ImageButton)(findViewById(R.id.tyre15)),(ImageButton)(findViewById(R.id.tyre16)),(ImageButton)(findViewById(R.id.tyre17)),(ImageButton)(findViewById(R.id.tyre18)),(ImageButton)(findViewById(R.id.tyre19)),(ImageButton)(findViewById(R.id.tyre20)),(ImageButton)(findViewById(R.id.tyre21)),(ImageButton)(findViewById(R.id.tyre22)),(ImageButton)(findViewById(R.id.tyre23)),(ImageButton)(findViewById(R.id.tyre24)),(ImageButton)(findViewById(R.id.tyre25)),(ImageButton)(findViewById(R.id.tyre26)),(ImageButton)(findViewById(R.id.tyre27)),(ImageButton)(findViewById(R.id.tyre28)),(ImageButton)(findViewById(R.id.tyre29)),(ImageButton)(findViewById(R.id.tyre30)),(ImageButton)(findViewById(R.id.tyre31)),(ImageButton)(findViewById(R.id.tyre32)),(ImageButton)(findViewById(R.id.tyre33)),(ImageButton)(findViewById(R.id.tyre34)),(ImageButton)(findViewById(R.id.tyre35)),(ImageButton)(findViewById(R.id.tyre36)),(ImageButton)(findViewById(R.id.tyre37)),(ImageButton)(findViewById(R.id.tyre38)),(ImageButton)(findViewById(R.id.tyre39)),(ImageButton)(findViewById(R.id.tyre40)),(ImageButton)(findViewById(R.id.tyre41)),(ImageButton)(findViewById(R.id.tyre42)),(ImageButton)(findViewById(R.id.tyre43)),(ImageButton)(findViewById(R.id.tyre44)),(ImageButton)(findViewById(R.id.tyre45)),(ImageButton)(findViewById(R.id.tyre46)),(ImageButton)(findViewById(R.id.tyre47)),(ImageButton)(findViewById(R.id.tyre48)),(ImageButton)(findViewById(R.id.tyre49)),(ImageButton)(findViewById(R.id.tyre50)),(ImageButton)(findViewById(R.id.tyre51)),(ImageButton)(findViewById(R.id.tyre52)),(ImageButton)(findViewById(R.id.tyre53)),(ImageButton)(findViewById(R.id.tyre54)),(ImageButton)(findViewById(R.id.tyre55)),(ImageButton)(findViewById(R.id.tyre56)),(ImageButton)(findViewById(R.id.tyre57)),(ImageButton)(findViewById(R.id.tyre58)),(ImageButton)(findViewById(R.id.tyre59)),(ImageButton)(findViewById(R.id.tyre60)),(ImageButton)(findViewById(R.id.tyre61)),(ImageButton)(findViewById(R.id.tyre62)),(ImageButton)(findViewById(R.id.tyre63))};
    public TableLayout wheels_table = (TableLayout)(findViewById(R.id.wheels_table));
    trailer[] trailers;
    int which_trailer_show;

    public void show_trailer(int trailer_number) {
        if (trailer_number<0 || trailer_number >6) {
            wheels_table.setVisibility(View.INVISIBLE);
        }
        else{
            wheels_table.setVisibility(View.VISIBLE);
            for(int i = 0 ; i<64 ; i++){
                if(trailers[trailer_number].wheels[i].status == trailer.statuses.GREEN){
                    btnwheels[i].setBackgroundColor(Color.green(1));}
                else if(trailers[trailer_number].wheels[i].status == trailer.statuses.ORANGE){
                    btnwheels[i].setBackgroundColor(Color.red(10));}
                else if(trailers[trailer_number].wheels[i].status == trailer.statuses.ORANGE){
                    btnwheels[i].setBackgroundColor(Color.red(1));}


            }
        }
    }
    static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.i(TAG, "It is alive!");
        trailer[] trailers = new trailer[6];
        which_trailer_show  = -1;
        show_trailer(which_trailer_show);

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
                show_trailer(which_trailer_show );
            }
        });

        btn1st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w){
                Log.i(TAG, "Button 1");
                show_trailer(1);
            }
        });

        btn2nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w){
                Log.i(TAG, "Button 2");
            }
        });

        btn3rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w){
                Log.i(TAG, "Button 3");
            }
        });

        btn4th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w){
                Log.i(TAG, "Button 4");
            }
        });

        btn5th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w){
                Log.i(TAG, "Button 5");
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
