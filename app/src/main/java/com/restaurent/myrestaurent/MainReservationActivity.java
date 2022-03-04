package com.restaurent.myrestaurent;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.restaurent.myrestaurent.ViewPagerAdapter.ViewPagerAdapter;
import com.restaurent.myrestaurent.fragment.FragmentAddStarter;
import com.restaurent.myrestaurent.fragment.FragmentCart;
import com.restaurent.myrestaurent.fragment.FragmentOrder;
import com.restaurent.myrestaurent.fragment.FragmentOverview;
import com.restaurent.myrestaurent.fragment.ReviewFragment;
import com.restaurent.myrestaurent.fragment.TableReservationFragment;

public class MainReservationActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    NavigationView hotelNavBar;
    DrawerLayout drawerLayout;
    Toolbar toolBar;
    LinearLayout kitchenOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_reserveration_activity);

        kitchenOrder = findViewById(R.id.kitchenOrder);
        drawerLayout = findViewById(R.id.drawerLayout);
        hotelNavBar = findViewById(R.id.drawer_navigationview);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.opendrawer,R.string.closedrawer);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        kitchenOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), OrderActivity.class));
            }
        });


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addTabs(new FragmentOverview(), "OverView");
        viewPagerAdapter.addTabs(new FragmentAddStarter(), "Gallery");
        viewPagerAdapter.addTabs(new FragmentCart(), "Menu of the day");
        viewPagerAdapter.addTabs(new FragmentOrder(), "Menu");
        viewPagerAdapter.addTabs(new TableReservationFragment(), "Reservation");
        viewPagerAdapter.addTabs(new ReviewFragment(), "Review");
        View root = tabLayout.getChildAt(0);
        if (root instanceof LinearLayout) {
            ((LinearLayout) root).setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
            GradientDrawable drawable = new GradientDrawable();
            drawable.setColor(getResources().getColor(R.color.gray));
            drawable.setSize(2, 3);
            ((LinearLayout) root).setDividerPadding(24);
            ((LinearLayout) root).setDividerDrawable(drawable);
        }

        viewPager.setAdapter(viewPagerAdapter);
        viewPagerAdapter.notifyDataSetChanged();
        tabLayout.setupWithViewPager(viewPager);


    }
    public void setFragmengt(Fragment fragmengt){
        getSupportFragmentManager().beginTransaction().replace(R.id.HomeFrag_fraimLayout,fragmengt).commit();
    }
}