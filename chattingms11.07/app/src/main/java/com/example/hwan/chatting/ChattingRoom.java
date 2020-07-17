package com.example.hwan.chatting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;



public class ChattingRoom extends AppCompatActivity{

    Intent intent,intent2;
    ArrayAdapter adapter;


    protected void onCreate(Bundle savedInstanceState) {
        // RestaurantDBHelper.Restaurantlist.clone();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chattingroom);

        final ListView listview = (ListView) findViewById(R.id.listview1) ;
        listview.setAdapter(adapter);

        final Button button = (Button)findViewById(R.id.button_makeroom);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ChattingRoom.this, ChattingActivity.class);
                startActivity(intent);
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent2 =  new Intent(ChattingRoom.this,ChattingActivity.class);
                startActivity(intent2);
            }

        });
    }
}
