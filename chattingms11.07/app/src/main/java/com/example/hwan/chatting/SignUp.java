package com.example.hwan.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {
    EditText name, age, sex, id, password, password2;
    Button signup;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = (EditText)findViewById(R.id.name);

        age = (EditText)findViewById(R.id.age);
        id = (EditText)findViewById(R.id.id);
        password = (EditText)findViewById(R.id.password);
        password2 = (EditText)findViewById(R.id.password2);
        signup = findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                intent = new Intent(SignUp.this, Login.class);

                startActivity(intent);
            }
        });
    }
}

