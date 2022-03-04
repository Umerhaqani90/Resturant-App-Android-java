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
import com.restaurent.myrestaurent.adapter.OrderAdapter;
import com.restaurent.myrestaurent.adapter.ReviewAdapter;
import com.restaurent.myrestaurent.model.OrderModel;
import com.restaurent.myrestaurent.model.ReviewModel;

import java.util.ArrayList;

public class FragmentOrder extends Fragment {

    RecyclerView rvOrder;
    ArrayList<OrderModel> orderModelArrayList;
    int[] imgOrder= {R.drawable.ic_kebabjee,R.drawable.ic_launcher_background};
    String[] txtProductOrderName= {"Nuggests","Pop Corns"};
    String[] txtProductOrderPrice= {"$ 110" , "$ 220"};
    String[] txtProOrderQuantity= {"2", "3"};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_order,container,false);
        rvOrder = v.findViewById(R.id.rvOrder);

        orderModelArrayList = new ArrayList<>();

        //creating array list
        for (int i=0;i<imgOrder.length;i++){
            OrderModel orderModel = new OrderModel(imgOrder[i],txtProductOrderName[i],txtProductOrderPrice[i],txtProOrderQuantity[i]);
            orderModelArrayList.add(orderModel);
        }

        if (orderModelArrayList != null){
            LinearLayoutManager llm = new LinearLayoutManager(getActivity());
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            rvOrder.setLayoutManager(llm);
            OrderAdapter adapter = new OrderAdapter(orderModelArrayList,getActivity());
            rvOrder.setAdapter(adapter);
        }



        return v;
    }
}
