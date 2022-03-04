package com.restaurent.myrestaurent.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.restaurent.myrestaurent.R;

public class FragmentHaveMainDish extends Fragment {
    Button btnYesDish;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dialog_have_main_dish,container,false);

        btnYesDish = v.findViewById(R.id.btnYesDish);
        btnYesDish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddMainDishFragment nextFrag= new AddMainDishFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragments_container, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });
        return v;
    }
}