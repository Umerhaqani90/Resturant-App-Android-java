package com.restaurent.myrestaurent.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.CornerFamily;
import com.restaurent.myrestaurent.R;

public class FragmentAddRestaurants extends Fragment {

    ShapeableImageView imageViewAddResImage;
    Button btnAddRestaurantsNext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_resturents,container,false);

        imageViewAddResImage = v.findViewById(R.id.imageViewAddResImage);

        float radius = getResources().getDimension(R.dimen._20sdp);
        imageViewAddResImage.setShapeAppearanceModel(imageViewAddResImage.getShapeAppearanceModel()
                .toBuilder()
                .setBottomRightCorner(CornerFamily.ROUNDED,radius)
                .setBottomLeftCorner(CornerFamily.ROUNDED,radius).
                        build());

        btnAddRestaurantsNext = v.findViewById(R.id.btnAddRestaurantsNext);
        btnAddRestaurantsNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HaveStarterFragment nextFrag= new HaveStarterFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragments_container, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        return v;
    }
}
