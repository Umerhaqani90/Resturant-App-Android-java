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
import com.restaurent.myrestaurent.adapter.OverviewAdapter;
import com.restaurent.myrestaurent.adapter.ReviewAdapter;
import com.restaurent.myrestaurent.model.OverviewsModel;
import com.restaurent.myrestaurent.model.ReviewModel;

import java.util.ArrayList;

public class ReviewFragment extends Fragment {

    RecyclerView recyclerviewReview;
    ArrayList<ReviewModel> reviewModelArrayList;
    int[] imgReviewPerson= {R.drawable.ic_kebabjee,R.drawable.ic_launcher_background};
    String[] reviewerName= {"Muhammad Wajih Uddin","Tosha"};
    String[] reviewerTableDetail= {"Table Reserved 24-Jan 2020" , "Table Reserved 24-Feb 2020"};
    String[] reviewerAddress= {"North Nazimabad karachi", "Defence Karachi"};
    String[] txtReview= {"Have a best fine quality dinner" , "Have a best fine quality dinner"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_review,container,false);
        recyclerviewReview = v.findViewById(R.id.recyclerviewReview);

        reviewModelArrayList = new ArrayList<>();

        //creating array list
        for (int i=0;i<imgReviewPerson.length;i++){
            ReviewModel reviewModel = new ReviewModel(imgReviewPerson[i],reviewerName[i],reviewerTableDetail[i],reviewerAddress[i],txtReview[i]);
            reviewModelArrayList.add(reviewModel);
        }

        if (reviewModelArrayList != null){
            ReviewAdapter adapter = new ReviewAdapter(reviewModelArrayList,getActivity());
            GridLayoutManager layoutManager = new GridLayoutManager(getContext(),1);
            recyclerviewReview.setLayoutManager(layoutManager);
            recyclerviewReview.setAdapter(adapter);
        }


        return v;
    }
}
