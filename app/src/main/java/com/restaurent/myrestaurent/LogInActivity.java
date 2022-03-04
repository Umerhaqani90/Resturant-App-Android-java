package com.restaurent.myrestaurent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.regex.Pattern;

public class LogInActivity extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("\"[a-zA-Z0-9\\\\+\\\\.\\\\_\\\\%\\\\-\\\\+]{1,256}\" +\n" +
                    "          \"\\\\@\" +\n" +
                    "            \"[a-zA-Z0-9][a-zA-Z0-9\\\\-]{0,64}\" +\n" +
                    "            \"(\" +\n" +
                    "                \"\\\\.\" +\n" +
                    "                \"[a-zA-Z0-9][a-zA-Z0-9\\\\-]{0,25}\" +\n" +
                    "            \")+\"");
    //declaration
    EditText editText_email, editText_password;
    ImageButton imagebtn_submit;
    Button btn_signin, btn_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        //initilization
        editText_email = findViewById(R.id.Ed_email_cell);
        editText_password = findViewById(R.id.Ed_password);
        imagebtn_submit = findViewById(R.id.imagebtn_submit);
        btn_signin = findViewById(R.id.btn_signin);
        btn_signup = findViewById(R.id.btn_signup);

        //setting click listner to signup button
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogInActivity.this, DialogHaveRestaurantActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private boolean validateEmail() {
        String emailInput = editText_email.getEditableText().toString().trim();
        {
            if (emailInput.isEmpty()) {
                editText_email.setError("Please enter email id");
                return false;
            } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
                editText_email.setError("Please enter a valid email  id");
                return false;
            } else
                {
                editText_email.setError(null);
                return true;
               }
        }
    }
    private boolean validatePassword() {
        String passwordInput = editText_password.getEditableText().toString().trim();
        {
            if (passwordInput.isEmpty()) {
                editText_email.setError("Please enter password");
                return false;
            } else if (!Patterns.EMAIL_ADDRESS.matcher(passwordInput).matches()) {
                editText_password.setError("enter a correct password");
                return false;
            } else
            {
                editText_email.setError(null);
                return true;
            }
        }
    }
}
