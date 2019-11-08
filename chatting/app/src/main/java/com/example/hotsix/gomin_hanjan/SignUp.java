package com.example.hotsix.gomin_hanjan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hwan.chatting.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUp extends AppCompatActivity {
    private static final String BASE = "http://192.168.0.18:3000";

    EditText name, age, sex, id, password, password2;
    Button signup, idConfirm, backbutton;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = (EditText)findViewById(R.id.name);
        sex = (EditText)findViewById(R.id.sex);
        age = (EditText)findViewById(R.id.age);
        id = (EditText)findViewById(R.id.id);
        password = (EditText)findViewById(R.id.password);
        password2 = (EditText)findViewById(R.id.password2);
        signup = findViewById(R.id.signup);
        idConfirm = findViewById(R.id.insert);
        backbutton = findViewById(R.id.backbutton);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                SignUpInterface signUpInterface = retrofit.create(SignUpInterface.class);
                String name1 = String.valueOf(name.getText().toString());
                String sex1 = String.valueOf(sex.getText().toString());
                String age1 = String.valueOf(age.getText().toString());
                String id1 = String.valueOf(id.getText().toString());
                String password_1 = String.valueOf(password.getText().toString());
                String password_2 = String.valueOf(password2.getText().toString());
                Call<List<Dummy>> call = signUpInterface.listDummies(name1, sex1, age1, id1, password_1, password_2);
                call.enqueue(dummies);
            }
        });

        idConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                IdInterface idInterface = retrofit.create(IdInterface.class);
                String id1 = String.valueOf(id.getText().toString());
                Call<List<Dummy>> call = idInterface.listDummies(id1);
                call.enqueue(dummies1);
            }
        });

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivityForResult(intent,100);
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
                if(builder.toString().equals("0")){
                    Toast.makeText(getApplicationContext(), "ID가 중복입니다", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_SHORT).show();
                }
            }
        }

        @Override
        public void onFailure(Call<List<Dummy>> call, Throwable t){

        }
    };

    Callback dummies1 = new Callback<List<Dummy>>() {

        @Override
        public void onResponse(Call<List<Dummy>> call, Response<List<Dummy>> response) {
            if (response.isSuccessful()) {
                List<Dummy> dummies = response.body();
                StringBuilder builder = new StringBuilder();
                for (Dummy dummy : dummies) {
                    builder.append(dummy.toString());
                }
                if(builder.toString().equals("0")){
                    Toast.makeText(getApplicationContext(), "사용할 수 있는 ID입니다", Toast.LENGTH_SHORT).show();
                }

                if(builder.toString().equals("1")){
                    Toast.makeText(getApplicationContext(), "ID 중복입니다", Toast.LENGTH_SHORT).show();
                }
            }
        }

        @Override
        public void onFailure(Call<List<Dummy>> call, Throwable t){

        }
    };
}
