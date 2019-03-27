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
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab;
    ImageButton btn0st;
    ImageButton btn1st;
    ImageButton btn2nd;
    ImageButton btn3rd;
    ImageButton btn4th;
    ImageButton btn5th;
    ImageButton[] btnwheels;
    //public TableLayout wheels_table;
    //public Trailer[] trailers;
    int which_trailer_show;
    View tyre_info_view;
    TextView tyre_text;
    static String TAG = "MainActivity";
    String tyre_description;
    final public Trailer[] trailers = new Trailer[6];


    public void show_trailer(int trailer_number, TableLayout wheels_table, Trailer[] trailers, ImageButton[] btnwheels, View tyre_info_view) {
        if (trailer_number<0 || trailer_number >6) {
            wheels_table.setVisibility(View.INVISIBLE);
        }
        else{
            wheels_table.setVisibility(View.VISIBLE);
            tyre_info_view.setVisibility(View.INVISIBLE);
            for(int i = 0 ; i<64 ; i++){
                if(trailers[trailer_number].wheels[i].status == Trailer.statuses.GREEN){
                    btnwheels[i].setImageResource(R.mipmap.green_tyre);}
                else if(trailers[trailer_number].wheels[i].status == Trailer.statuses.ORANGE){
                    btnwheels[i].setImageResource(R.mipmap.yellow_tyre);}
                else if(trailers[trailer_number].wheels[i].status == Trailer.statuses.RED){
                    btnwheels[i].setImageResource(R.mipmap.red_tyre);}
                else if(trailers[trailer_number].wheels[i].status == Trailer.statuses.BLACK){
                    btnwheels[i].setImageResource(R.mipmap.tyre_black);}


            }
        }
    }
    public void show_tyre(int trailer_number, int tyre_number, View tyre_info_view, Trailer[] trailers, TextView tyre_text){
        tyre_info_view.setVisibility(View.VISIBLE);
            tyre_description = "Pressure: " + trailers[trailer_number].wheels[tyre_number].getPress() + "\n" + "Temperature: " + trailers[trailer_number].wheels[tyre_number].getTemp();
            tyre_text.setText(tyre_description);
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
        final View tyre_info_view = findViewById(R.id.tyreinfoview);
        final TextView tyre_text = findViewById(R.id.tyretext);

        for (int i = 0; i<trailers.length; i++){
            trailers[i]=new Trailer();
            for(int j = 0 ; j<trailers[i].wheels.length; j++) {
                trailers[i].wheels[j] = trailers[i].new Wheel();
            }}


        Log.i(TAG, "It is alive!");
        tyre_info_view.setVisibility(View.INVISIBLE);
        which_trailer_show  = -1;
        show_trailer(which_trailer_show, wheels_table, trailers, btnwheels, tyre_info_view);
        trailers[1].wheels[10].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.ORANGE);
        trailers[2].wheels[10].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.ORANGE);
        trailers[1].wheels[19].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.BLACK);
        trailers[1].wheels[30].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.RED);
        trailers[1].wheels[1].updateWheel(40,10, Trailer.errors.NON, Trailer.statuses.GREEN);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btnwheels[0].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 0, tyre_info_view, trailers, tyre_text);}});
        btnwheels[1].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 1, tyre_info_view, trailers, tyre_text);}});
        btnwheels[2].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 2, tyre_info_view, trailers, tyre_text);}});
        btnwheels[3].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 3, tyre_info_view, trailers, tyre_text);}});
        btnwheels[4].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 4, tyre_info_view, trailers, tyre_text);}});
        btnwheels[5].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 5, tyre_info_view, trailers, tyre_text);}});
        btnwheels[6].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 6, tyre_info_view, trailers, tyre_text);}});
        btnwheels[7].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 7, tyre_info_view, trailers, tyre_text);}});
        btnwheels[8].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 8, tyre_info_view, trailers, tyre_text);}});
        btnwheels[9].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 9, tyre_info_view, trailers, tyre_text);}});
        btnwheels[10].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 10, tyre_info_view, trailers, tyre_text);}});
        btnwheels[11].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 11, tyre_info_view, trailers, tyre_text);}});
        btnwheels[12].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 12, tyre_info_view, trailers, tyre_text);}});
        btnwheels[13].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 13, tyre_info_view, trailers, tyre_text);}});
        btnwheels[14].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 14, tyre_info_view, trailers, tyre_text);}});
        btnwheels[15].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 15, tyre_info_view, trailers, tyre_text);}});
        btnwheels[16].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 16, tyre_info_view, trailers, tyre_text);}});
        btnwheels[17].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 17, tyre_info_view, trailers, tyre_text);}});
        btnwheels[18].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 18, tyre_info_view, trailers, tyre_text);}});
        btnwheels[19].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 19, tyre_info_view, trailers, tyre_text);}});
        btnwheels[20].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 20, tyre_info_view, trailers, tyre_text);}});
        btnwheels[21].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 21, tyre_info_view, trailers, tyre_text);}});
        btnwheels[22].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 22, tyre_info_view, trailers, tyre_text);}});
        btnwheels[23].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 23, tyre_info_view, trailers, tyre_text);}});
        btnwheels[24].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 24, tyre_info_view, trailers, tyre_text);}});
        btnwheels[25].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 25, tyre_info_view, trailers, tyre_text);}});
        btnwheels[26].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 26, tyre_info_view, trailers, tyre_text);}});
        btnwheels[27].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 27, tyre_info_view, trailers, tyre_text);}});
        btnwheels[28].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 28, tyre_info_view, trailers, tyre_text);}});
        btnwheels[29].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 29, tyre_info_view, trailers, tyre_text);}});
        btnwheels[30].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 30, tyre_info_view, trailers, tyre_text);}});
        btnwheels[31].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 31, tyre_info_view, trailers, tyre_text);}});
        btnwheels[32].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 32, tyre_info_view, trailers, tyre_text);}});
        btnwheels[33].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 33, tyre_info_view, trailers, tyre_text);}});
        btnwheels[34].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 34, tyre_info_view, trailers, tyre_text);}});
        btnwheels[35].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 35, tyre_info_view, trailers, tyre_text);}});
        btnwheels[36].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 36, tyre_info_view, trailers, tyre_text);}});
        btnwheels[37].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 37, tyre_info_view, trailers, tyre_text);}});
        btnwheels[38].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 38, tyre_info_view, trailers, tyre_text);}});
        btnwheels[39].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 39, tyre_info_view, trailers, tyre_text);}});
        btnwheels[40].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 40, tyre_info_view, trailers, tyre_text);}});
        btnwheels[41].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 41, tyre_info_view, trailers, tyre_text);}});
        btnwheels[42].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 42, tyre_info_view, trailers, tyre_text);}});
        btnwheels[43].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 43, tyre_info_view, trailers, tyre_text);}});
        btnwheels[44].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 44, tyre_info_view, trailers, tyre_text);}});
        btnwheels[45].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 45, tyre_info_view, trailers, tyre_text);}});
        btnwheels[46].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 46, tyre_info_view, trailers, tyre_text);}});
        btnwheels[47].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 47, tyre_info_view, trailers, tyre_text);}});
        btnwheels[48].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 48, tyre_info_view, trailers, tyre_text);}});
        btnwheels[49].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 49, tyre_info_view, trailers, tyre_text);}});
        btnwheels[50].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 50, tyre_info_view, trailers, tyre_text);}});
        btnwheels[51].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 51, tyre_info_view, trailers, tyre_text);}});
        btnwheels[52].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 52, tyre_info_view, trailers, tyre_text);}});
        btnwheels[53].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 53, tyre_info_view, trailers, tyre_text);}});
        btnwheels[54].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 54, tyre_info_view, trailers, tyre_text);}});
        btnwheels[55].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 55, tyre_info_view, trailers, tyre_text);}});
        btnwheels[56].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 56, tyre_info_view, trailers, tyre_text);}});
        btnwheels[57].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 57, tyre_info_view, trailers, tyre_text);}});
        btnwheels[58].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 58, tyre_info_view, trailers, tyre_text);}});
        btnwheels[59].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 59, tyre_info_view, trailers, tyre_text);}});
        btnwheels[60].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 60, tyre_info_view, trailers, tyre_text);}});
        btnwheels[61].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 61, tyre_info_view, trailers, tyre_text);}});
        btnwheels[62].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 62, tyre_info_view, trailers, tyre_text);}});
        btnwheels[63].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(which_trailer_show, 63, tyre_info_view, trailers, tyre_text);}});


        btn0st.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){
                Log.i(TAG, "Button 0");
                which_trailer_show = 0;
                show_trailer(which_trailer_show , wheels_table, trailers, btnwheels, tyre_info_view);
            }});

        btn1st.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){
                Log.i(TAG, "Button 1");
                which_trailer_show = 1;
                show_trailer(which_trailer_show , wheels_table, trailers, btnwheels, tyre_info_view);
            }});

        btn2nd.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){
                Log.i(TAG, "Button 2");
                which_trailer_show = 2;
                show_trailer(which_trailer_show , wheels_table, trailers, btnwheels, tyre_info_view);
            }});

        btn3rd.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){
                Log.i(TAG, "Button 3");
                which_trailer_show = 3;
                show_trailer(which_trailer_show , wheels_table, trailers, btnwheels, tyre_info_view);
            }});

        btn4th.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){
                Log.i(TAG, "Button 4");
                which_trailer_show = 4;
                show_trailer(which_trailer_show , wheels_table, trailers, btnwheels, tyre_info_view);
            }});

        btn5th.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){
                Log.i(TAG, "Button 5");
                which_trailer_show = 5;
                show_trailer(which_trailer_show , wheels_table, trailers, btnwheels, tyre_info_view);
            }});
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
