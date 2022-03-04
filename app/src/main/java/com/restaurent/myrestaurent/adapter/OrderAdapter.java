package com.restaurent.myrestaurent.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.restaurent.myrestaurent.R;
import com.restaurent.myrestaurent.model.OrderModel;
import com.restaurent.myrestaurent.model.ReviewModel;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyOrderViewHolder>{

    ArrayList<OrderModel> orderModelArrayList;
    Activity activity;
    LayoutInflater inflater;

    public OrderAdapter(ArrayList<OrderModel> orderModelArrayList, Context activity) {
        this.orderModelArrayList = orderModelArrayList;
        this.inflater = LayoutInflater.from(activity);
    }

    @NonNull
    @Override
    public MyOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.order_listitems,null);
        return new OrderAdapter.MyOrderViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrderViewHolder holder, int position) {

        OrderModel model = orderModelArrayList.get(position);
        holder.imgOrder.setImageResource(model.getImgOrder());
        holder.txtProductOrderName.setText(model.getTxtProductOrderName());
        holder.txtProductOrderPrice.setText(model.getTxtProductOrderPrice());
        holder.txtProOrderQuantity.setText(model.getTxtProOrderQuantity());
    }

    @Override
    public int getItemCount() {
        return orderModelArrayList.size();
    }

    public class MyOrderViewHolder extends RecyclerView.ViewHolder{

        ImageView imgOrder;
        TextView txtProductOrderName,txtProductOrderPrice, txtProOrderQuantity;

        public MyOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            imgOrder = itemView.findViewById(R.id.imgOrder);
            txtProductOrderName = itemView.findViewById(R.id.txtProductOrderName);
            txtProductOrderPrice = itemView.findViewById(R.id.txtProductOrderPrice);
            txtProOrderQuantity = itemView.findViewById(R.id.txtProOrderQuantity);

        }
    }
}
