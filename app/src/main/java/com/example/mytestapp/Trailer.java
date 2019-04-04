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
        void updateWheel(double temp, double press, errors err){this.temperature = temp; this.pressure = press; this.error = err;}
        void updateWheel(double temp, double press, errors err, statuses status){this.temperature = temp; this.pressure = press; this.error = err; this.status = status;}

        Wheel() {}
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
    void update_trailers(int ccu_status, int axles_count, int wheels_count, int wheels_count_not_eaqual){
        this.numberOfAxles = axles_count;
        this.numberOfWheels = wheels_count;
        if (wheels_count_not_eaqual != 0) {this.error = errors.MPCB;}
        else if(ccu_status == 1) {this.error = errors.CCU1;}
        else if(ccu_status == 2) {this.error = errors.CCU2;}
        else if(ccu_status == 3) {this.error = errors.CCUs;}
        else if(ccu_status == 0) {this.error = errors.NON;}
    }
    void check_trailer_status(){
        this.status = statuses.GREEN;
        for( int i =0 ; i< this.wheels.length ; i++){
            switch (this.wheels[i].status) {
                case BLACK:
                    this.status = statuses.BLACK;
                case RED:
                    if (this.status != statuses.BLACK) {
                        this.status = statuses.RED;
                    }
                case ORANGE:
                    if (this.status != statuses.BLACK && this.status != statuses.RED) {
                        this.status = statuses.ORANGE;
                    }
                case GREEN:
            }
        }
    }
}
