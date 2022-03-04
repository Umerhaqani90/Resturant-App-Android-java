package com.restaurent.myrestaurent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.restaurent.myrestaurent.adapter.OrderAdapter;
import com.restaurent.myrestaurent.model.OrderModel;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    RecyclerView rvOrder;
    ArrayList<OrderModel> orderModelArrayList;
    int[] imgOrder= {R.drawable.ic_kebabjee,R.drawable.ic_launcher_background};
    String[] txtProductOrderName= {"Nuggests","Pop Corns"};
    String[] txtProductOrderPrice= {"$ 110" , "$ 220"};
    String[] txtProOrderQuantity= {"2", "3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        rvOrder = findViewById(R.id.rvOrder);

        orderModelArrayList = new ArrayList<>();

        //creating array list
        for (int i=0;i<imgOrder.length;i++){
            OrderModel orderModel = new OrderModel(imgOrder[i],txtProductOrderName[i],txtProductOrderPrice[i],txtProOrderQuantity[i]);
            orderModelArrayList.add(orderModel);
        }

        if (orderModelArrayList != null){
            LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            rvOrder.setLayoutManager(llm);
            OrderAdapter adapter = new OrderAdapter(orderModelArrayList, OrderActivity.this);
            rvOrder.setAdapter(adapter);
        }


    }
}