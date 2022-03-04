package com.restaurent.myrestaurent.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.restaurent.myrestaurent.R;
import com.restaurent.myrestaurent.adapter.HomeReservationRecyclerAdapter;
import com.restaurent.myrestaurent.model.HomeReservationModel;

import java.util.ArrayList;

public class AllHomeFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<HomeReservationModel> arrayList;
    int[] images = {R.drawable.small,R.drawable.homeimage,R.drawable.small,R.drawable.homeimage,R.drawable.small,R.drawable.homeimage};
    String[] title = {"Bell Vista","Bell Vista","Bell Vista","Bell Vista","Bell Vista","Bell Vista"};
    String[] loc = {"Khayaban e Shehbaz Karachi","Khayaban e Shehbaz Karachi","Khayaban e Shehbaz Karachi","Khayaban e Shehbaz Karachi","Khayaban e Shehbaz Karachi","Khayaban e Shehbaz Karachi"};
    String[] shopname = {"Burger piza italian all variety","Burger piza italian all variety","Burger piza italian all variety","Burger piza italian all variety","Burger piza italian all variety","Burger piza italian all variety"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_all_home, container, false);

        recyclerView = v.findViewById(R.id.recyclerview_all_home);
        arrayList = new ArrayList<>();

        //creating array list
        for (int i=0;i<images.length;i++){
            HomeReservationModel model = new HomeReservationModel(images[i],title[i],loc[i],shopname[i]);
            arrayList.add(model);
        }

        if (arrayList != null){
            HomeReservationRecyclerAdapter adapter = new HomeReservationRecyclerAdapter(arrayList,getActivity());
            GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }
        return v;
    }
}