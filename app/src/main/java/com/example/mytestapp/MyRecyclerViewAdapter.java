package com.example.mytestapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import java.io.IOError;
import java.io.IOException;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    //private String[] mData;
    private Trailer.Wheel[] wheels;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private ImageView[] mImageViews;

    // data is passed into the constructor
    MyRecyclerViewAdapter(Context context, Trailer.Wheel[] wheels) {
        this.mInflater = LayoutInflater.from(context);
        //this.mData = data;
        this.wheels = wheels;
        this.mImageViews = new ImageView[wheels.length]; //data.length];
    }

    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    public void updateNumberOfGrids(Trailer.Wheel[] wheels){
        this.wheels = wheels;
        //this.mImageViews = new ImageView[wheels.length];
    }

    // binds the data to the TextView in each cell
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.myImageView.setContentDescription(mData[position]);
        //holder.myImageView.setImageResource(R.mipmap.grey_tyre);
        mImageViews[position] = holder.myImageView;
        if(wheels[position].status== Trailer.Wheel.statuses.GREEN){
            mImageViews[position].setImageResource(R.mipmap.green_tyre);
        } else if(wheels[position].status== Trailer.Wheel.statuses.ORANGE){
            mImageViews[position].setImageResource(R.mipmap.yellow_tyre);
        } else if(wheels[position].status== Trailer.Wheel.statuses.RED){
            mImageViews[position].setImageResource(R.mipmap.red_tyre);
        } else if(wheels[position].status== Trailer.Wheel.statuses.BLACK){
            mImageViews[position].setImageResource(R.mipmap.tyre_black);
        } else {
            mImageViews[position].setImageResource(R.mipmap.grey_tyre);
        }


    }

    // total number of cells
    @Override
    public int getItemCount() {
        return /*mData*/ wheels.length;
    }

    public ImageView imageView(int position){

        return mImageViews[position];
    }
    public ImageView[] getmImageViews(){
        return mImageViews;
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView myImageView;

        ViewHolder(View itemView) {
            super(itemView);
            myImageView = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            try {
                if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
            } catch (IOError e){
                Log.i("RecView",e.getMessage());
            }
        }
    }


    // convenience method for getting data at click position
    Trailer.Wheel getItem(int id) {
        return wheels[id];//mData[id];
    }



    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
        Log.i("grid","btn");
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}