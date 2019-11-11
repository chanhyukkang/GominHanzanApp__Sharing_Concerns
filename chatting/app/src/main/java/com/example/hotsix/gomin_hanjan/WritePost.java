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

public class WritePost extends AppCompatActivity {
    private static final String BASE = "http://192.168.0.18:3000";

    Button b1;
    Button b2;
    EditText e1;
    EditText e2;
    Intent intent,intent2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writepost);

        b1 =  (Button)findViewById(R.id.b1);
        b2 =  (Button)findViewById(R.id.b2);
        e1 =  (EditText)findViewById(R.id.e1);
        e2 =  (EditText)findViewById(R.id.e2);

        Intent intent1 = getIntent();
        final String[] userInfo = intent1.getStringArrayExtra("strings");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                String title = e1.getText().toString();
                String maintext = e2.getText().toString();
                PostInterface postInterface = retrofit.create(PostInterface.class);
                Call<List<Dummy>> call = postInterface.listDummies(title, maintext);
                call.enqueue(dummies);

                Toast.makeText(WritePost.this, "글쓰기를 완료하였습니다", Toast.LENGTH_SHORT).show();
                intent = new Intent(WritePost.this, ChattingRoomMake.class);
                String[] information = new String[] {userInfo[0], userInfo[1]};
                intent.putExtra("strings", information);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent2 = new Intent(WritePost.this, ChattingRoom.class);
                String[] information = new String[] {userInfo[0], userInfo[1]};
                intent2.putExtra("strings", information);
                startActivity(intent2);
            }
        });
    }

    Callback dummies = new Callback<List<Dummy>>() {

        @Override
        public void onResponse(Call<List<Dummy>> call, Response<List<Dummy>> response) {
            if (response.isSuccessful()) {
            }
        }

        @Override
        public void onFailure(Call<List<Dummy>> call, Throwable t) {

        }
    };
}