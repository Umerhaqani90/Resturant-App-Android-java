package com.restaurent.myrestaurent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.shape.CornerFamily;
import com.restaurent.myrestaurent.fragment.AllHomeFragment;
import com.restaurent.myrestaurent.fragment.HomeFragment;
import com.restaurent.myrestaurent.fragment.ProfileFragment;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{


    NavigationView hotelNavBar;
    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;
    AppBarLayout apbarlayout_homefrag;
    LinearLayout relativeLayout;
    ShapeableImageView shapeableImageView;
    CollapsingToolbarLayout collapsToolbar;
    Toolbar toolBarHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolBarHome = findViewById(R.id.toolBarHome);
        setSupportActionBar(toolBarHome);

        collapsToolbar = findViewById(R.id.collapsToolbar);
        apbarlayout_homefrag = findViewById(R.id.apbarlayout_homefrag);
        drawerLayout = findViewById(R.id.drawerLayout);
        hotelNavBar = findViewById(R.id.drawer_navigationview);
        relativeLayout = findViewById(R.id.spacerspc);
        shapeableImageView = findViewById(R.id.homeFrag_shapeableimageview);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.opendrawer,R.string.closedrawer);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        float radius = getResources().getDimension(R.dimen._20sdp);
        shapeableImageView.setShapeAppearanceModel(shapeableImageView.getShapeAppearanceModel()
                .toBuilder()
                .setBottomRightCorner(CornerFamily.ROUNDED,radius)
                .setBottomLeftCorner(CornerFamily.ROUNDED,radius).
                        build());


        apbarlayout_homefrag.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    isShow = true;
                    relativeLayout.setVisibility(View.VISIBLE);
                    getSupportActionBar().hide();
                } else if (isShow) {
                    isShow = false;
                    relativeLayout.setVisibility(View.GONE);
                     getSupportActionBar().show();
                }
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.item_btm_home:
                setFragment(new AllHomeFragment());
                break;
            case R.id.item_btm_reservation:
                startActivity(new Intent(getApplicationContext(), MainReservationActivity.class));
                break;
            case R.id.item_btm_notification:
                // setFragment(new FragmentHaveRestaurants());
                startActivity(new Intent(getApplicationContext(), AddRestaurantActivity.class));
                break;
            case R.id.item_btm_profile:
                setFragment(new ProfileFragment());
                break;
        }

        return true;
    }

    public void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.bottomNavFrameLayout, fragment).commit();
    }
}