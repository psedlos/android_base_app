package com.example.mytestapp;

import android.graphics.Color;
import android.view.View;

public class trailer {
    public class Wheel{
        double temperature=0;
        double pressure=0;
        statuses status = statuses.BLACK;
        errors error = errors.MPCB;

        public double getTemp(){return temperature;}
        public double getPress(){return pressure;}
        public statuses getStat(){return status;}
        public errors getError(){return error;}
        public void setTemp(double temp){this.temperature=temp;}
        public void setPress(double press){this.pressure=press;}
        public void setStat(statuses stat){this.status=stat;}
        public void setError(statuses stat){this.status=stat;}
        public void updateWheel(double temp, double press){this.temperature = temp; this.pressure = press;}
        public void updateWheel(double temp, double press, errors err){this.temperature = temp; this.pressure = press; this.error = err;}
        public Wheel(){}
    }
    public enum typeoftraliers {TRUCK, TRAILER, PLATFORM}
    public typeoftraliers typeoftralier;
    public int numberOfAxles;
    public int numberOfWheels;
    public boolean turnedAround;
    public enum statuses {GREEN, ORANGE, RED, BLACK}
    public statuses status = statuses.GREEN;
    public enum errors {NON, CCU1, CCU2, CCUs, MPCB}
    public errors error = errors.NON;
    Wheel[] wheels = new Wheel[64];

    public trailer(){

    }

}
