package com.restaurent.myrestaurent.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.restaurent.myrestaurent.R;
import com.restaurent.myrestaurent.model.OverviewsModel;

import java.util.ArrayList;

public class OverviewAdapter extends RecyclerView.Adapter<OverviewAdapter.MyOverviewViewHolder> {

    ArrayList<OverviewsModel> overviewsModelArrayList;
    Activity activity;
    LayoutInflater inflater;

    public OverviewAdapter(ArrayList<OverviewsModel> overviewsModelArrayList, Activity activity) {
        this.overviewsModelArrayList = overviewsModelArrayList;
        this.activity = activity;
        this.inflater = activity.getLayoutInflater();
    }

    @NonNull
    @Override
    public MyOverviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.overview_listitems,null);
        return new OverviewAdapter.MyOverviewViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOverviewViewHolder holder, int position) {
        OverviewsModel model = overviewsModelArrayList.get(position);
        holder.txtOverview.setText(model.getOverviews());

    }

    @Override
    public int getItemCount() {
        return overviewsModelArrayList.size();
    }

    public class MyOverviewViewHolder extends RecyclerView.ViewHolder{

        TextView txtOverview;

        public MyOverviewViewHolder(@NonNull View itemView) {
            super(itemView);
            txtOverview = itemView.findViewById(R.id.txtOverview);

        }
    }

}
