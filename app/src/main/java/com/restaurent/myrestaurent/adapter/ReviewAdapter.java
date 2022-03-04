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
import com.restaurent.myrestaurent.model.OverviewsModel;
import com.restaurent.myrestaurent.model.ReviewModel;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.MyReviewViewHolder>{


    ArrayList<ReviewModel> reviewModelArrayList;
    Activity activity;
    LayoutInflater inflater;

    public ReviewAdapter(ArrayList<ReviewModel> reviewModelArrayList, Activity activity) {
        this.reviewModelArrayList = reviewModelArrayList;
        this.activity = activity;
        this.inflater = activity.getLayoutInflater();
    }

    @NonNull
    @Override
    public MyReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.reviews_listitems,null);
        return new ReviewAdapter.MyReviewViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyReviewViewHolder holder, int position) {

        ReviewModel model = reviewModelArrayList.get(position);
        holder.imgReviewPerson.setImageResource(model.getImgReviewPerson());
        holder.reviewerName.setText(model.getReviewerName());
        holder.reviewerTableDetail.setText(model.getReviewerTableDetail());
        holder.reviewerAddress.setText(model.getReviewerAddress());
        holder.txtReview.setText(model.getTxtReview());
    }

    @Override
    public int getItemCount() {
        return reviewModelArrayList.size();
    }

    public class MyReviewViewHolder extends RecyclerView.ViewHolder{

        ImageView imgReviewPerson;
        TextView reviewerName,reviewerTableDetail, reviewerAddress, txtReview;

        public MyReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgReviewPerson = itemView.findViewById(R.id.imgReviewPerson);
            reviewerName = itemView.findViewById(R.id.reviewerName);
            reviewerTableDetail = itemView.findViewById(R.id.reviewerTableDetail);
            reviewerAddress = itemView.findViewById(R.id.reviewerAddress);
            txtReview = itemView.findViewById(R.id.txtReview);

        }
    }

}
