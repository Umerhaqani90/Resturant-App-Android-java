package com.restaurent.myrestaurent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.google.android.material.navigation.NavigationView;
import com.restaurent.myrestaurent.fragment.BottomNavFragment;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //declaration
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // initilization
        navigationView = findViewById(R.id.drawer_navigationview);
        toolbar = findViewById(R.id.toolbar_home);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        drawerLayout = findViewById(R.id.drawerlayout);

        if (savedInstanceState == null){
            setFragment(new BottomNavFragment());
//            navigationView.getMenu().getItem(0).setChecked(true);
        }

        //now getting drawer header from navigation view
        View headerview = navigationView.getHeaderView(0);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.opendrawer,R.string.closedrawer);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch(id){
            case R.id.item_home:
                setFragment(new BottomNavFragment());
                break;
            default:

                break;
        }

        //onclick setting iten checked/highlited
        navigationView.setCheckedItem(item.getItemId());
        //on click close nav view
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    public void setFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_home,fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.homeoptionsmenu,menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.item_options_home){
            setFragment(new BottomNavFragment());
        }

        return super.onOptionsItemSelected(item);
    }
}