package com.example.mytestapp;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.animation.ImageMatrixProperty;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab;
    static String TAG = "MainActivity";

    public void  update_trailers(MainContainer mc){
        ViewGroup.LayoutParams layoutparams;
        for(int i=1; i< mc.trailers.length; i++){
            layoutparams = (ViewGroup.LayoutParams) mc.btntrailers[i].getLayoutParams();
            if(mc.trailers[i].numberOfAxles==2){
                layoutparams.width = 60;
                if(mc.trailers[i].error == Trailer.errors.CCU1){
                    mc.btntrailers[i].setImageResource(R.mipmap.tralier2ccu_eng);
                } else if (mc.trailers[i].error == Trailer.errors.CCU2){
                    mc.btntrailers[i].setImageResource(R.mipmap.tralier2ccu_eng);
                } else if (mc.trailers[i].error == Trailer.errors.CCUs){
                    mc.btntrailers[i].setImageResource(R.mipmap.tralier2unconnected_eng);
                } else if (mc.trailers[i].error == Trailer.errors.MPCB){
                    mc.btntrailers[i].setImageResource(R.mipmap.tralier2mpcb_eng);
                } else if (mc.trailers[i].error == Trailer.errors.NON){
                    if(mc.trailers[i].status== Trailer.statuses.BLACK){
                        mc.btntrailers[i].setImageResource(R.mipmap.tralier2unconnected_eng);
                    } else if (mc.trailers[i].status== Trailer.statuses.RED){
                        mc.btntrailers[i].setImageResource(R.mipmap.tralier2red_eng);
                    } else if (mc.trailers[i].status== Trailer.statuses.ORANGE){
                        mc.btntrailers[i].setImageResource(R.mipmap.tralier2orange_eng);
                    } else if (mc.trailers[i].status== Trailer.statuses.GREEN) {
                        mc.btntrailers[i].setImageResource(R.mipmap.tralier2green_eng);
                    }
                }
            } else if(mc.trailers[i].numberOfAxles==3) {
                layoutparams.width = 80;
                if(mc.trailers[i].error == Trailer.errors.CCU1){
                    mc.btntrailers[i].setImageResource(R.mipmap.tralier3ccu_eng);
                } else if (mc.trailers[i].error == Trailer.errors.CCU2){
                    mc.btntrailers[i].setImageResource(R.mipmap.tralier3ccu_eng);
                } else if (mc.trailers[i].error == Trailer.errors.CCUs){
                    mc.btntrailers[i].setImageResource(R.mipmap.tralier3unconnected_eng);
                } else if (mc.trailers[i].error == Trailer.errors.MPCB){
                    mc.btntrailers[i].setImageResource(R.mipmap.tralier3mpcb_eng);
                } else if (mc.trailers[i].error == Trailer.errors.NON){
                    if(mc.trailers[i].status== Trailer.statuses.BLACK){
                        mc.btntrailers[i].setImageResource(R.mipmap.tralier3unconnected_eng);
                    } else if (mc.trailers[i].status== Trailer.statuses.RED){
                        mc.btntrailers[i].setImageResource(R.mipmap.tralier3red_eng);
                    } else if (mc.trailers[i].status== Trailer.statuses.ORANGE){
                        mc.btntrailers[i].setImageResource(R.mipmap.tralier3orange_eng);
                    } else if (mc.trailers[i].status== Trailer.statuses.GREEN) {
                        mc.btntrailers[i].setImageResource(R.mipmap.tralier3green_eng);
                    }
                }
            } else if(mc.trailers[i].numberOfAxles==4) {
                layoutparams.width = 100;
                if(mc.trailers[i].error == Trailer.errors.CCU1){
                    mc.btntrailers[i].setImageResource(R.mipmap.tralier4ccu_eng);
                } else if (mc.trailers[i].error == Trailer.errors.CCU2){
                    mc.btntrailers[i].setImageResource(R.mipmap.tralier4ccu_eng);
                } else if (mc.trailers[i].error == Trailer.errors.CCUs){
                    mc.btntrailers[i].setImageResource(R.mipmap.tralier4unconnected_eng);
                } else if (mc.trailers[i].error == Trailer.errors.MPCB){
                    mc.btntrailers[i].setImageResource(R.mipmap.tralier4mpcb_eng);
                } else if (mc.trailers[i].error == Trailer.errors.NON){
                    if(mc.trailers[i].status== Trailer.statuses.BLACK){
                        mc.btntrailers[i].setImageResource(R.mipmap.tralier4unconnected_eng);
                    } else if (mc.trailers[i].status== Trailer.statuses.RED){
                        mc.btntrailers[i].setImageResource(R.mipmap.tralier4red_eng);
                    } else if (mc.trailers[i].status== Trailer.statuses.ORANGE){
                        mc.btntrailers[i].setImageResource(R.mipmap.tralier4orange_eng);
                    } else if (mc.trailers[i].status== Trailer.statuses.GREEN) {
                        mc.btntrailers[i].setImageResource(R.mipmap.tralier4green_eng);
                    }
                }
            } else if(mc.trailers[i].numberOfAxles==5) {
                layoutparams.width = 120;
                if(mc.trailers[i].error == Trailer.errors.CCU1){
                    mc.btntrailers[i].setImageResource(R.mipmap.tralier5ccu_eng);
                } else if (mc.trailers[i].error == Trailer.errors.CCU2){
                    mc.btntrailers[i].setImageResource(R.mipmap.tralier5ccu_eng);
                } else if (mc.trailers[i].error == Trailer.errors.CCUs){
                    mc.btntrailers[i].setImageResource(R.mipmap.tralier5unconnected_eng);
                } else if (mc.trailers[i].error == Trailer.errors.MPCB){
                    mc.btntrailers[i].setImageResource(R.mipmap.tralier5mpcb_eng);
                } else if (mc.trailers[i].error == Trailer.errors.NON){
                    if(mc.trailers[i].status== Trailer.statuses.BLACK){
                        mc.btntrailers[i].setImageResource(R.mipmap.tralier5unconnected_eng);
                    } else if (mc.trailers[i].status== Trailer.statuses.RED){
                        mc.btntrailers[i].setImageResource(R.mipmap.tralier5red_eng);
                    } else if (mc.trailers[i].status== Trailer.statuses.ORANGE){
                        mc.btntrailers[i].setImageResource(R.mipmap.tralier5orange_eng);
                    } else if (mc.trailers[i].status== Trailer.statuses.GREEN) {
                        mc.btntrailers[i].setImageResource(R.mipmap.tralier5green_eng);
                    }
                }
            } else if(mc.trailers[i].numberOfAxles==6) {
                layoutparams.width = 140;
                if(mc.trailers[i].error == Trailer.errors.CCU1){
                    mc.btntrailers[i].setImageResource(R.mipmap.tralier6ccu_eng);
                } else if (mc.trailers[i].error == Trailer.errors.CCU2){
                    mc.btntrailers[i].setImageResource(R.mipmap.tralier6ccu_eng);
                } else if (mc.trailers[i].error == Trailer.errors.CCUs){
                    mc.btntrailers[i].setImageResource(R.mipmap.tralier6unconnected_eng);
                } else if (mc.trailers[i].error == Trailer.errors.MPCB){
                    mc.btntrailers[i].setImageResource(R.mipmap.tralier6mpcb_eng);
                } else if (mc.trailers[i].error == Trailer.errors.NON){
                    if(mc.trailers[i].status== Trailer.statuses.BLACK){
                        mc.btntrailers[i].setImageResource(R.mipmap.tralier6unconnected_eng);
                    } else if (mc.trailers[i].status== Trailer.statuses.RED){
                        mc.btntrailers[i].setImageResource(R.mipmap.tralier6red_eng);
                    } else if (mc.trailers[i].status== Trailer.statuses.ORANGE){
                        mc.btntrailers[i].setImageResource(R.mipmap.tralier6orange_eng);
                    } else if (mc.trailers[i].status== Trailer.statuses.GREEN) {
                        mc.btntrailers[i].setImageResource(R.mipmap.tralier6green_eng);
                    }
                }
            }
        mc.btntrailers[i].setLayoutParams(layoutparams);
        }
    }

    public void show_trailer(MainContainer mc) {
        if (mc.which_trailer_show<0 || mc.which_trailer_show >11) {
            mc.wheels_table.setVisibility(View.INVISIBLE);
        }
        else{
            mc.wheels_table.setVisibility(View.VISIBLE);
            mc.tyre_text.setVisibility(View.INVISIBLE);
            for(int i = 0 ; i<64 ; i++){
                mc.btnwheels[i].setBackgroundColor(getResources().getColor(R.color.buttonNormalBackground));
                if(mc.trailers[mc.which_trailer_show].wheels[i].status == Trailer.statuses.GREEN){
                    mc.btnwheels[i].setImageResource(R.mipmap.green_tyre);}
                else if(mc.trailers[mc.which_trailer_show].wheels[i].status == Trailer.statuses.ORANGE){
                    mc.btnwheels[i].setImageResource(R.mipmap.yellow_tyre);}
                else if(mc.trailers[mc.which_trailer_show].wheels[i].status == Trailer.statuses.RED){
                    mc.btnwheels[i].setImageResource(R.mipmap.red_tyre);}
                else if(mc.trailers[mc.which_trailer_show].wheels[i].status == Trailer.statuses.BLACK){
                    mc.btnwheels[i].setImageResource(R.mipmap.tyre_black);}


            }
        }
    }
    public void show_tyre(int tyre_number, MainContainer mc){
        mc.tyre_text.setVisibility(View.VISIBLE);
        for (int i = 0; i < mc.btnwheels.length; i++) {
            mc.btnwheels[i].setBackgroundColor(getResources().getColor(R.color.buttonNormalBackground));
        }
        mc.btnwheels[tyre_number].setBackgroundColor(getResources().getColor(R.color.buttonSelectedBackground));

        mc.tyre_description = "Pressure: " + mc.trailers[mc.which_trailer_show].wheels[tyre_number].getPress() + "\n" + "Temperature: " + mc.trailers[mc.which_trailer_show].wheels[tyre_number].getTemp();
        mc.tyre_text.setText(mc.tyre_description);
    }
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





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);

        final MainContainer mc = new MainContainer();
        mc.btntrailers = new ImageButton[] {findViewById(R.id.truck),findViewById(R.id.first_platform),findViewById(R.id.second_platform),findViewById(R.id.third_platform),findViewById(R.id.fourth_platform),findViewById(R.id.fifth_platform),findViewById(R.id.sixth_platform),findViewById(R.id.seventh_platform),findViewById(R.id.eight_platform),findViewById(R.id.nineth_platform),findViewById(R.id.tenth_platform)};
        mc.btnwheels = new ImageButton[] {(findViewById(R.id.tyre00)),(findViewById(R.id.tyre01)),(findViewById(R.id.tyre02)),(findViewById(R.id.tyre03)),(findViewById(R.id.tyre04)),(findViewById(R.id.tyre05)),(findViewById(R.id.tyre06)),(findViewById(R.id.tyre07)),(findViewById(R.id.tyre08)),(findViewById(R.id.tyre09)),(findViewById(R.id.tyre10)),(findViewById(R.id.tyre11)),(findViewById(R.id.tyre12)),(findViewById(R.id.tyre13)),(findViewById(R.id.tyre14)),(findViewById(R.id.tyre15)),(findViewById(R.id.tyre16)),(findViewById(R.id.tyre17)),(findViewById(R.id.tyre18)),(findViewById(R.id.tyre19)),(findViewById(R.id.tyre20)),(findViewById(R.id.tyre21)),(findViewById(R.id.tyre22)),(findViewById(R.id.tyre23)),(findViewById(R.id.tyre24)),(findViewById(R.id.tyre25)),(findViewById(R.id.tyre26)),(findViewById(R.id.tyre27)),(findViewById(R.id.tyre28)),(findViewById(R.id.tyre29)),(findViewById(R.id.tyre30)),(findViewById(R.id.tyre31)),(findViewById(R.id.tyre32)),(findViewById(R.id.tyre33)),(findViewById(R.id.tyre34)),(findViewById(R.id.tyre35)),(findViewById(R.id.tyre36)),(findViewById(R.id.tyre37)),(findViewById(R.id.tyre38)),(findViewById(R.id.tyre39)),(findViewById(R.id.tyre40)),(findViewById(R.id.tyre41)),(findViewById(R.id.tyre42)),(findViewById(R.id.tyre43)),(findViewById(R.id.tyre44)),(findViewById(R.id.tyre45)),(findViewById(R.id.tyre46)),(findViewById(R.id.tyre47)),(findViewById(R.id.tyre48)),(findViewById(R.id.tyre49)),(findViewById(R.id.tyre50)),(findViewById(R.id.tyre51)),(findViewById(R.id.tyre52)),(findViewById(R.id.tyre53)),(findViewById(R.id.tyre54)),(findViewById(R.id.tyre55)),(findViewById(R.id.tyre56)),(findViewById(R.id.tyre57)),(findViewById(R.id.tyre58)),(findViewById(R.id.tyre59)),(findViewById(R.id.tyre60)),(findViewById(R.id.tyre61)),(findViewById(R.id.tyre62)),(findViewById(R.id.tyre63))};
        mc.wheels_table = (findViewById(R.id.wheels_table));
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
        update_trailers(mc);
        show_trailer(mc);
        //new ClientSend().run();


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();}
        });

        mc.btnwheels[0].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(0, mc);}});
        mc.btnwheels[1].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(1, mc);}});
        mc.btnwheels[2].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre( 2, mc);}});
        mc.btnwheels[3].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre( 3, mc);}});
        mc.btnwheels[4].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre( 4, mc);}});
        mc.btnwheels[5].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre( 5, mc);}});
        mc.btnwheels[6].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre( 6, mc);}});
        mc.btnwheels[7].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre( 7, mc);}});
        mc.btnwheels[8].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre( 8, mc);}});
        mc.btnwheels[9].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre( 9, mc);}});
        mc.btnwheels[10].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(10, mc);}});
        mc.btnwheels[11].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(11, mc);}});
        mc.btnwheels[12].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(12, mc);}});
        mc.btnwheels[13].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(13, mc);}});
        mc.btnwheels[14].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(14, mc);}});
        mc.btnwheels[15].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(15, mc);}});
        mc.btnwheels[16].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(16, mc);}});
        mc.btnwheels[17].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(17, mc);}});
        mc.btnwheels[18].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(18, mc);}});
        mc.btnwheels[19].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(19, mc);}});
        mc.btnwheels[20].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(20, mc);}});
        mc.btnwheels[21].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(21, mc);}});
        mc.btnwheels[22].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(22, mc);}});
        mc.btnwheels[23].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(23, mc);}});
        mc.btnwheels[24].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(24, mc);}});
        mc.btnwheels[25].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(25, mc);}});
        mc.btnwheels[26].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(26, mc);}});
        mc.btnwheels[27].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(27, mc);}});
        mc.btnwheels[28].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(28, mc);}});
        mc.btnwheels[29].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(29, mc);}});
        mc.btnwheels[30].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(30, mc);}});
        mc.btnwheels[31].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(31, mc);}});
        mc.btnwheels[32].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(32, mc);}});
        mc.btnwheels[33].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(33, mc);}});
        mc.btnwheels[34].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(34, mc);}});
        mc.btnwheels[35].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(35, mc);}});
        mc.btnwheels[36].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(36, mc);}});
        mc.btnwheels[37].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(37, mc);}});
        mc.btnwheels[38].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(38, mc);}});
        mc.btnwheels[39].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(39, mc);}});
        mc.btnwheels[40].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(40, mc);}});
        mc.btnwheels[41].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(41, mc);}});
        mc.btnwheels[42].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(42, mc);}});
        mc.btnwheels[43].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(43, mc);}});
        mc.btnwheels[44].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(44, mc);}});
        mc.btnwheels[45].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(45, mc);}});
        mc.btnwheels[46].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(46, mc);}});
        mc.btnwheels[47].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(47, mc);}});
        mc.btnwheels[48].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(48, mc);}});
        mc.btnwheels[49].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(49, mc);}});
        mc.btnwheels[50].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(50, mc);}});
        mc.btnwheels[51].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(51, mc);}});
        mc.btnwheels[52].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(52, mc);}});
        mc.btnwheels[53].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(53, mc);}});
        mc.btnwheels[54].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(54, mc);}});
        mc.btnwheels[55].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(55, mc);}});
        mc.btnwheels[56].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(56, mc);}});
        mc.btnwheels[57].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(57, mc);}});
        mc.btnwheels[58].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(58, mc);}});
        mc.btnwheels[59].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(59, mc);}});
        mc.btnwheels[60].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(60, mc);}});
        mc.btnwheels[61].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(61, mc);}});
        mc.btnwheels[62].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(62, mc);}});
        mc.btnwheels[63].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){show_tyre(63, mc);}});

        mc.btntrailers[0].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){Log.i(TAG, "Button 0"); mc.which_trailer_show = 0; show_trailer(mc);}});
        mc.btntrailers[1].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){Log.i(TAG, "Button 1"); mc.which_trailer_show = 1; show_trailer(mc);}});
        mc.btntrailers[2].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){Log.i(TAG, "Button 2"); mc.which_trailer_show = 2; show_trailer(mc);}});
        mc.btntrailers[3].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){Log.i(TAG, "Button 3"); mc.which_trailer_show = 3; show_trailer(mc);}});
        mc.btntrailers[4].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){Log.i(TAG, "Button 4"); mc.which_trailer_show = 4; show_trailer(mc);}});
        mc.btntrailers[5].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){Log.i(TAG, "Button 5"); mc.which_trailer_show = 5; show_trailer(mc);}});
        mc.btntrailers[6].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){Log.i(TAG, "Button 6"); mc.which_trailer_show = 6; show_trailer(mc);}});
        mc.btntrailers[7].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){Log.i(TAG, "Button 7"); mc.which_trailer_show = 7; show_trailer(mc);}});
        mc.btntrailers[8].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){Log.i(TAG, "Button 8"); mc.which_trailer_show = 8; show_trailer(mc);}});
        mc.btntrailers[9].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){Log.i(TAG, "Button 9"); mc.which_trailer_show = 9; show_trailer(mc);}});
        mc.btntrailers[10].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View w){Log.i(TAG, "Button 10"); mc.which_trailer_show = 10; show_trailer(mc);}});
        new Thread( new ClientListen()).start();
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
