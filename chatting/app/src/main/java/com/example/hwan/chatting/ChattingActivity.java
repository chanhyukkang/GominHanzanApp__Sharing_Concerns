package com.example.hwan.chatting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class ChattingActivity extends AppCompatActivity {

    final int userKey = 1;
    EditText sendChatText;
    Button sendButton;
    TextView receiveMessage;
    TextView myMessage;
    private Socket socket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        sendChatText = (EditText)findViewById(R.id.chat_content);
        sendButton = (Button)findViewById(R.id.send_btn);
        receiveMessage = (TextView)findViewById(R.id.chat_received);
        myMessage = (TextView)findViewById(R.id.mychat_received);

        try {
            socket = IO.socket("http://192.168.0.3:9000"); //로컬호스트 ip주소 수정하기
        }catch (Exception e) {
            Log.i("THREADSERVICE", "Server not connected");
            e.printStackTrace();
        }

        socket.connect();

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject obj = new JSONObject();
                String message = sendChatText.getText().toString(); //전송할 메시지
                try {
                    obj.put("message", message);
                    obj.put("key", userKey);
                    socket.emit("message", obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        Emitter.Listener onMessageReceived = new Emitter.Listener() {
            @Override
            public void call(final Object... args) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        JSONObject received = (JSONObject)args[0];
                        String msg = null;
                        String key = null;
                        try {
                            msg = received.get("message").toString(); //받는 메시지
                            key = received.get("key").toString(); //유저 식별키

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if(key.equals("1")){
                            myMessage.append(msg+"\n");
                        }
                        else
                            receiveMessage.append(msg+"\n");
                    }
                });
            }
        };
        socket.on("receiveMsg", onMessageReceived);

    }
}
