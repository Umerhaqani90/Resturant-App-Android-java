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

public class HaveDesertFragment extends Fragment {

    Button btnYesDesert;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dialog_have_desert,container,false);

        btnYesDesert = v.findViewById(R.id.btnYesDesert);
        btnYesDesert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDesertFragment nextFrag= new AddDesertFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragments_container, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        return v;
    }
}
