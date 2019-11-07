package com.example.hwan.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText id, password;
    Button login, signup;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id = (EditText) findViewById(R.id.edittext_id);
        password = (EditText) findViewById(R.id.edittext_password);
        login = findViewById(R.id.button_login);
        signup = findViewById(R.id.button_signup);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String i = id.getText().toString();
                String pw = password.getText().toString();

                // if(i.equals("user") && pw.equals("1234")) { // id:user, pw:1234일 때 (유저모드로그인성공)
                intent = new Intent(Login.this, ChattingRoom.class);
                intent.putExtra("i", i);
                intent.putExtra("p", pw);
                startActivity(intent);

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String i = id.getText().toString();
                String pw = password.getText().toString();

                intent = new Intent(Login.this, SignUp.class);
                intent.putExtra("i", i);
                intent.putExtra("p", pw);
                startActivity(intent);

            }
        });

    }
}
