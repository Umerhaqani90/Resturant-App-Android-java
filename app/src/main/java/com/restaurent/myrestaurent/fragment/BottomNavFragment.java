package com.restaurent.myrestaurent.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.restaurent.myrestaurent.AddRestaurantActivity;
import com.restaurent.myrestaurent.MainReservationActivity;
import com.restaurent.myrestaurent.R;

public class BottomNavFragment extends Fragment implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_bottom_nav, container, false);

        bottomNavigationView = v.findViewById(R.id.bottomnavigationview);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            setFragment(new HomeFragment());
            bottomNavigationView.getMenu().getItem(0).setChecked(true);
        }


        return v;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.item_btm_home:
                setFragment(new HomeFragment());
                break;
            case R.id.item_btm_reservation:
                startActivity(new Intent(getActivity(), MainReservationActivity.class));
                break;
            case R.id.item_btm_notification:
                // setFragment(new FragmentHaveRestaurants());
                startActivity(new Intent(getActivity(), AddRestaurantActivity.class));
                break;
            case R.id.item_btm_profile:
                setFragment(new ProfileFragment());
                break;
        }

        return true;
    }

    public void setFragment(Fragment fragment) {
        getChildFragmentManager().beginTransaction().replace(R.id.bottonnav_framelayout, fragment).commit();
    }
}