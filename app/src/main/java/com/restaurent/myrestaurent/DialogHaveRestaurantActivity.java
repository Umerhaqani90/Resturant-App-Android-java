package com.restaurent.myrestaurent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DialogHaveRestaurantActivity extends AppCompatActivity {

    Button btn_res_yes,btn_res_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_have_restaurant);
        btn_res_yes = findViewById(R.id.btn_res_yes);
        btn_res_no = findViewById(R.id.btn_res_no);

        btn_res_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DialogHaveRestaurantActivity.this,Home.class);
                startActivity(intent);
            }
        });

        btn_res_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DialogHaveRestaurantActivity.this,AddRestaurantActivity.class);
                startActivity(intent);
            }
        });
    }
}