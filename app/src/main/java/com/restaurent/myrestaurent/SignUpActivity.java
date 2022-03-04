package com.restaurent.myrestaurent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class SignUpActivity extends AppCompatActivity {

    ImageView imageView_googleplus,imageView_facebook;
    EditText editText_name,editText_email,editText_password;
    ImageButton btn_submit;
    Button btn_signin,btn_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        imageView_googleplus = findViewById(R.id.imageView_googleplus);
        imageView_facebook = findViewById(R.id.imageView_facebook);
        editText_name = findViewById(R.id.Ed_su_name);
        editText_email = findViewById(R.id.Ed_su_email);
        editText_password = findViewById(R.id.Ed_su_password);
        btn_submit = findViewById(R.id.imagebtn_su_submit);
        btn_signin = findViewById(R.id.btn_su_signin);
        btn_signup = findViewById(R.id.btn_su_signup);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,LogInActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}