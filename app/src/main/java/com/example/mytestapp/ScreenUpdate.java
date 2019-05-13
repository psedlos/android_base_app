package com.example.mytestapp;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.concurrent.Callable;

public class ScreenUpdate implements Callable {
    MainContainer mc;
    ScreenUpdate(MainContainer mc){
        this.mc = mc;
    }
    @Override
    public Callable call() {
        //boolean run = true;
        //while(run){
            try {
                mc.show_trailer();
                mc.update_trailers();
                //Thread.sleep(1000);
                //wait(1000);
                Log.i("Screen Runable", "I am alive");
            }catch (Exception e){
            Log.e("Screen Client has IOE", "error: ", e);
            ///run = false;
            }
        //}
        return null;
    }
}

