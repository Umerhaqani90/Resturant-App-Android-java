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

public class FragmentAddStarter extends Fragment {

    ShapeableImageView imageAddStarter;
    Button btnAddStarter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_starter,container,false);

        imageAddStarter = v.findViewById(R.id.imageAddStarter);
        btnAddStarter = v.findViewById(R.id.btnAddStarter);

        float radius = getResources().getDimension(R.dimen._20sdp);
        imageAddStarter.setShapeAppearanceModel(imageAddStarter.getShapeAppearanceModel()
                .toBuilder()
                .setBottomRightCorner(CornerFamily.ROUNDED,radius)
                .setBottomLeftCorner(CornerFamily.ROUNDED,radius).
                        build());


        btnAddStarter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HaveDrinksFragment nextFrag= new HaveDrinksFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragments_container, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        return v;
    }
}
