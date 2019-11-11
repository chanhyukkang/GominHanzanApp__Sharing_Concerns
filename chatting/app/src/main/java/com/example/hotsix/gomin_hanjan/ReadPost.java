package com.example.hotsix.gomin_hanjan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hwan.chatting.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReadPost extends AppCompatActivity {
    private static final String BASE = "http://192.168.0.18:3000";

    Button enterbt, exitbut;
    TextView title,maintext;
    Intent intent1,intent2;
    String chattingroom_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readpost);

        enterbt =  (Button)findViewById(R.id.button_enter);
        exitbut =  (Button)findViewById(R.id.button_notenter);
        title =  (TextView)findViewById(R.id.textview_title);
        maintext =  (TextView)findViewById(R.id.textview_maintext);
        Intent intent3 = getIntent();
        final String[] userInfo = intent3.getStringArrayExtra("strings");

        title.setText(userInfo[2]);
        maintext.setText(userInfo[3]);

        enterbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ReadPost.this, "방에 입장합니다", Toast.LENGTH_SHORT).show();
                intent1 = new Intent(ReadPost.this, ChattingActivity.class);
                String[] information = new String[] {userInfo[0], userInfo[1]};
                intent1.putExtra("strings", information);
                startActivity(intent1);
            }
        });

        exitbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent2 = new Intent(ReadPost.this, ChattingRoom.class);
                String[] information = new String[] {userInfo[0], userInfo[1]};
                intent2.putExtra("strings", information);
                startActivity(intent2);
            }
        });
    }

    Callback dummies = new Callback<List<Dummy1>>() {

        @Override
        public void onResponse(Call<List<Dummy1>> call, Response<List<Dummy1>> response) {
            if (response.isSuccessful()) {
                List<Dummy1> dummies = response.body();
                StringBuilder builder = new StringBuilder();
                for (Dummy1 dummy : dummies) {
                    builder.append(dummy.toString());
                }
                title.setText(builder.toString());
            }
        }

        @Override
        public void onFailure(Call<List<Dummy1>> call, Throwable t) {

        }
    };
}