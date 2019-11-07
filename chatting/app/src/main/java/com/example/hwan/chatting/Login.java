package com.example.hwan.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {
    private static final String BASE = "http://192.168.0.18:3000";

    EditText position;
    Button getButton;
    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText id = (EditText) findViewById(R.id.edittext_id);
        final EditText password = (EditText) findViewById(R.id.edittext_password);
        getButton = (Button) findViewById(R.id.button_login);
        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                GetService service = retrofit.create(GetService.class);
                String id1 = String.valueOf(id.getText().toString());
                String password1 = String.valueOf(password.getText().toString());
                Call<List<Dummy>> call = service.listDummies(id1, password1);
                call.enqueue(dummies);
            }
        });
    }

    Callback dummies = new Callback<List<Dummy>>() {

        @Override
        public void onResponse(Call<List<Dummy>> call, Response<List<Dummy>> response) {
            if (response.isSuccessful()) {
                List<Dummy> dummies = response.body();
                StringBuilder builder = new StringBuilder();
                for (Dummy dummy : dummies) {
                    builder.append(dummy.toString());
                }
                if(builder.toString().equals("1")){
                    Toast.makeText(getApplicationContext(), "Login", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),ChattingActivity.class);
                    startActivityForResult(intent,100);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Not Login", Toast.LENGTH_SHORT).show();
                }
            } else {
                info.setText("Fail, " + String.valueOf(response.code()));
            }
        }

        @Override
        public void onFailure(Call<List<Dummy>> call, Throwable t) {
            info.setText("Fail");
        }
    };
}
