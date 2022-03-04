package com.restaurent.myrestaurent.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.restaurent.myrestaurent.R;
import com.restaurent.myrestaurent.adapter.CartAdapter;
import com.restaurent.myrestaurent.adapter.ReviewAdapter;
import com.restaurent.myrestaurent.model.CartModel;
import com.restaurent.myrestaurent.model.ReviewModel;

import java.util.ArrayList;

public class FragmentCart extends Fragment {

    RecyclerView rvCart;
    ArrayList<CartModel> cartModelArrayList;
    int[] imgDish= {R.drawable.ic_kebabjee,R.drawable.ic_launcher_background};
    String[] dishName= {"Lorem Ipsium","Lorem Ipsium"};
    String[] dishPrice= {"$ 34","$ 20"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cart,container,false);

        rvCart = v.findViewById(R.id.rvCart);

        cartModelArrayList = new ArrayList<>();

        //creating array list
        for (int i=0;i<imgDish.length;i++){
            CartModel cartModel = new CartModel(imgDish[i],dishName[i],dishPrice[i]);
            cartModelArrayList.add(cartModel);
        }

        if (cartModelArrayList != null){

            LinearLayoutManager llm = new LinearLayoutManager(getActivity());
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            rvCart.setLayoutManager(llm);
            CartAdapter adapter = new CartAdapter(cartModelArrayList,getActivity());
            rvCart.setAdapter(adapter);
        }


        return v;
    }
}