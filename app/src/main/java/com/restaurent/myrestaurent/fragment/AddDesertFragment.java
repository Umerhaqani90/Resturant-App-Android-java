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

public class AddDesertFragment extends Fragment {

    ShapeableImageView imageAddDesert;
    Button btnAddDesert;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_desert,container,false);

        imageAddDesert = v.findViewById(R.id.imageAddDesert);
        float radius = getResources().getDimension(R.dimen._20sdp);
        imageAddDesert.setShapeAppearanceModel(imageAddDesert.getShapeAppearanceModel()
                .toBuilder()
                .setBottomRightCorner(CornerFamily.ROUNDED,radius)
                .setBottomLeftCorner(CornerFamily.ROUNDED,radius).
                        build());

        btnAddDesert = v.findViewById(R.id.btnAddDesert);
        btnAddDesert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentHaveSecondDish nextFrag= new FragmentHaveSecondDish();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragments_container, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        return v;
    }
}
