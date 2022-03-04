package com.restaurent.myrestaurent.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.restaurent.myrestaurent.R;
import com.restaurent.myrestaurent.model.HomeReservationModel;

import java.util.ArrayList;

public class HomeReservationRecyclerAdapter extends RecyclerView.Adapter<HomeReservationRecyclerAdapter.MyViewHolder> {

    ArrayList<HomeReservationModel> arrayList;
    Activity activity;
    LayoutInflater inflater;

    public HomeReservationRecyclerAdapter(ArrayList<HomeReservationModel> arrayList, Activity activity) {
        this.arrayList = arrayList;
        this.activity = activity;
        inflater = activity.getLayoutInflater();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.homeresturantlistitem,null);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        HomeReservationModel model = arrayList.get(position);
        holder.imageView.setImageResource(model.getImage());
        holder.title.setText(model.getTitle());
        holder.loc.setText(model.getLoc());
        holder.shopn.setText(model.getShopname());
        holder.btn_reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Btn View pos: "+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView title,loc,shopn;
        Button btn_reservation;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView_HRV);
            title = itemView.findViewById(R.id.tv_title);
            loc = itemView.findViewById(R.id.tv_loc_one);
            shopn = itemView.findViewById(R.id.tv_shopn);
            btn_reservation = itemView.findViewById(R.id.btn_reservationavailable);
        }
    }
}
