package com.restaurent.myrestaurent.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.restaurent.myrestaurent.R;
import com.restaurent.myrestaurent.adapter.HomeReservationRecyclerAdapter;
import com.restaurent.myrestaurent.adapter.OverviewAdapter;
import com.restaurent.myrestaurent.model.HomeReservationModel;
import com.restaurent.myrestaurent.model.OverviewsModel;

import java.util.ArrayList;

public class FragmentOverview extends Fragment {

    RecyclerView overviewRecyclerview;
    ArrayList<OverviewsModel> arrayList;
    String[] overviewDescription = {"We provide better quality in our restaurants so that we can achieve success in market" , "We provide better quality in our restaurants so that we can achieve success in market"};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_overview,container, false);
        overviewRecyclerview = v.findViewById(R.id.overviewRecyclerview);

        overviewRecyclerview = v.findViewById(R.id.overviewRecyclerview);
        arrayList = new ArrayList<>();

        //creating array list
        for (int i=0;i<overviewDescription.length;i++){
            OverviewsModel overviewsModel = new OverviewsModel(overviewDescription[i]);
            arrayList.add(overviewsModel);
        }

        if (arrayList != null){
            OverviewAdapter adapter = new OverviewAdapter(arrayList,getActivity());
            GridLayoutManager layoutManager = new GridLayoutManager(getContext(),1);
            overviewRecyclerview.setLayoutManager(layoutManager);
            overviewRecyclerview.setAdapter(adapter);
        }


        return v;
    }
}
