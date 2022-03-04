package com.restaurent.myrestaurent.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.restaurent.myrestaurent.R;
import com.restaurent.myrestaurent.model.CartModel;
import java.util.ArrayList;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyCartViewHolder>{

    ArrayList<CartModel> cartModelArrayList;
    Activity activity;
    LayoutInflater inflater;

    public CartAdapter(ArrayList<CartModel> cartModelArrayList, Activity activity) {
        this.cartModelArrayList = cartModelArrayList;
        this.activity = activity;
        this.inflater = activity.getLayoutInflater();
    }

    @NonNull
    @Override
    public MyCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.cart_listitems,null);
        return new CartAdapter.MyCartViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCartViewHolder holder, int position) {
        CartModel model = cartModelArrayList.get(position);
        holder.dishName.setText(model.getDishName());
        holder.dishPrice.setText(model.getDishPrice());
        holder.imgDish.setImageResource(model.getImgDish());
    }

    @Override
    public int getItemCount() {
        return cartModelArrayList.size();
    }

    public class MyCartViewHolder extends RecyclerView.ViewHolder{

        TextView dishName, dishPrice;
        ImageView imgDish;

        public MyCartViewHolder(@NonNull View itemView) {
            super(itemView);
            dishName = itemView.findViewById(R.id.dishName);
            dishPrice = itemView.findViewById(R.id.dishPrice);
            imgDish = itemView.findViewById(R.id.imgDish);

        }
    }

}
