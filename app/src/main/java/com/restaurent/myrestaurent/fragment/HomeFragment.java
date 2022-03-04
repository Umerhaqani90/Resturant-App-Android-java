package com.restaurent.myrestaurent.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.CornerFamily;
import com.restaurent.myrestaurent.R;


public class HomeFragment extends Fragment implements View.OnClickListener {

    ShapeableImageView shapeableImageView;
    SearchView searchView;
    ImageButton imageButton_filter;
    Button btn_all,btn_popular,btn_nearby,btn_recent;
    boolean allbtn_active = false,popularbtn_active = false,nearbybtn_active = false,recentbtn_active = false;
    AppBarLayout appBarLayout;
    LinearLayout relativeLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        shapeableImageView = v.findViewById(R.id.homeFrag_shapeableimageview);
        searchView = v.findViewById(R.id.searchView_homeFrag);
        imageButton_filter = v.findViewById(R.id.imagebtn_filter);
        btn_all = v.findViewById(R.id.btn_homefrag_all);
        btn_popular = v.findViewById(R.id.btn_homefrag_popular);
        btn_nearby = v.findViewById(R.id.btn_homefrag_near);
        btn_recent = v.findViewById(R.id.btn_homefrag_recent);
        appBarLayout = v.findViewById(R.id.apbarlayout_homefrag);
        relativeLayout = v.findViewById(R.id.spacerspc);

        //first setting shape able imageview bottom corners rounded
        float radius = getResources().getDimension(R.dimen._20sdp);
        shapeableImageView.setShapeAppearanceModel(shapeableImageView.getShapeAppearanceModel()
                .toBuilder()
                .setBottomRightCorner(CornerFamily.ROUNDED,radius)
                .setBottomLeftCorner(CornerFamily.ROUNDED,radius).
                        build());

        //checking wheather app or colasping imageview is scloling or not
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
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
                    ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
                } else if (isShow) {
                    isShow = false;
                    relativeLayout.setVisibility(View.GONE);
                    ((AppCompatActivity) getActivity()).getSupportActionBar().show();
                }
            }
        });


        //now setting clicklistner to buttons
        btn_all.setOnClickListener(this);
        btn_popular.setOnClickListener(this);
        btn_nearby.setOnClickListener(this);
        btn_recent.setOnClickListener(this);

        allbtn_active = true;
        setFragmengt(new AllHomeFragment());
        btn_all.setBackgroundResource(R.drawable.red_btn_bg);

        return v;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_homefrag_all:
                setFragmengt(new AllHomeFragment());
                allbtn_active = true;
                btn_all.setBackgroundResource(R.drawable.red_btn_bg);
                if (popularbtn_active){
                    popularbtn_active = false;
                    btn_popular.setBackgroundResource(R.drawable.outlined_white_bg);
                } else if (nearbybtn_active){
                    nearbybtn_active = false;
                    btn_nearby.setBackgroundResource(R.drawable.outlined_white_bg);
                } else if (recentbtn_active){
                    recentbtn_active = false;
                    btn_recent.setBackgroundResource(R.drawable.outlined_white_bg);
                }
                break;
            case R.id.btn_homefrag_popular:

                popularbtn_active = true;
                btn_popular.setBackgroundResource(R.drawable.red_btn_bg);
                if (allbtn_active){
                    allbtn_active = false;
                    btn_all.setBackgroundResource(R.drawable.outlined_white_bg);
                } else if (nearbybtn_active){
                    nearbybtn_active = false;
                    btn_nearby.setBackgroundResource(R.drawable.outlined_white_bg);
                } else if (recentbtn_active){
                    recentbtn_active = false;
                    btn_recent.setBackgroundResource(R.drawable.outlined_white_bg);
                }
                break;
            case R.id.btn_homefrag_near:

                nearbybtn_active = true;
                btn_nearby.setBackgroundResource(R.drawable.red_btn_bg);
                if (popularbtn_active){
                    popularbtn_active = false;
                    btn_popular.setBackgroundResource(R.drawable.outlined_white_bg);
                } else if (allbtn_active){
                    allbtn_active = false;
                    btn_all.setBackgroundResource(R.drawable.outlined_white_bg);
                } else if (recentbtn_active){
                    recentbtn_active = false;
                    btn_recent.setBackgroundResource(R.drawable.outlined_white_bg);
                }
                break;
            case R.id.btn_homefrag_recent:

                recentbtn_active = true;
                btn_recent.setBackgroundResource(R.drawable.red_btn_bg);
                if (popularbtn_active){
                    popularbtn_active = false;
                    btn_popular.setBackgroundResource(R.drawable.outlined_white_bg);
                } else if (nearbybtn_active){
                    nearbybtn_active = false;
                    btn_nearby.setBackgroundResource(R.drawable.outlined_white_bg);
                } else if (allbtn_active){
                    allbtn_active = false;
                    btn_all.setBackgroundResource(R.drawable.outlined_white_bg);
                }
                break;
        }
    }

    public void setFragmengt(Fragment fragmengt){
        getChildFragmentManager().beginTransaction().replace(R.id.HomeFrag_fraimLayout,fragmengt).commit();
    }
}