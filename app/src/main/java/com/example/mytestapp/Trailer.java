package com.example.mytestapp;

import android.graphics.Color;
import android.view.View;

public class Trailer {
    public class Wheel extends Trailer{
        double temperature=0;
        double pressure=0;
        statuses status = statuses.GREEN;
        errors error =errors.NON;

        public double getTemp(){return temperature;}
        public double getPress(){return pressure;}
        public statuses getStat(){return status;}
        public errors getError(){return error;}
//        public void setTemp(double temp){this.temperature=temp;}
//        public void setPress(double press){this.pressure=press;}
//        public void setStat(statuses stat){this.status=stat;}
//        public void setError(statuses stat){this.status=stat;}
        //public void updateWheel(double temp, double press){this.temperature = temp; this.pressure = press;}
        void updateWheel(double temp, double press, errors err){this.temperature = temp; this.pressure = press; this.error = err;}
        void updateWheel(double temp, double press, errors err, statuses status){this.temperature = temp; this.pressure = press; this.error = err; this.status = status;}

        /*public Wheel(double temperature, double pressure, statuses status, errors error) {
            super();
            this.temperature = temperature;
            this.pressure=pressure;
            this.status = status;
            this.error = error;
        }*/
        Wheel() {
//            this.temperature = 0;
//            this.pressure=0;
//            this.status = statuses.BLACK;
//            this.error = errors.MPCB;
        }
    }

    public enum typeoftraliers {TRUCK, TRAILER, PLATFORM}
    typeoftraliers typeoftralier;
    int numberOfAxles;
    int numberOfWheels;
    boolean turnedAround;
    public enum statuses {GREEN, ORANGE, RED, BLACK}
    statuses status;
    public enum errors {NON, CCU1, CCU2, CCUs, MPCB}
    errors error;
    Wheel[] wheels;
    Trailer() {
        typeoftralier = typeoftraliers.TRAILER;
        numberOfAxles=6;
        numberOfWheels=64;
        turnedAround=true;
        status = statuses.GREEN;
        error = errors.NON;
        wheels = new Wheel[64];
    }
    Trailer(int axels_ ) {
        numberOfAxles=axels_;
        numberOfWheels=8*axels_;
        turnedAround=true;
        status = statuses.GREEN;
        error = errors.NON;
        wheels = new Wheel[64];
    }
}
