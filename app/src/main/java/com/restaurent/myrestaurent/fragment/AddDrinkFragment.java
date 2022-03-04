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

public class AddDrinkFragment extends Fragment {

    ShapeableImageView imageAddDrink;
    Button btnDoneDrink;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_drink,container,false);

        imageAddDrink = v.findViewById(R.id.imageAddDrink);
        float radius = getResources().getDimension(R.dimen._20sdp);
        imageAddDrink.setShapeAppearanceModel(imageAddDrink.getShapeAppearanceModel()
                .toBuilder()
                .setBottomRightCorner(CornerFamily.ROUNDED,radius)
                .setBottomLeftCorner(CornerFamily.ROUNDED,radius).
                        build());


        btnDoneDrink = v.findViewById(R.id.btnDoneDrink);
        btnDoneDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentHaveMainDish nextFrag= new FragmentHaveMainDish();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragments_container, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        return v;
    }
}
