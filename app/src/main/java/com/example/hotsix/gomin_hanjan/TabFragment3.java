package com.example.hotsix.gomin_hanjan;

/**
 * Created by user on 2016-12-26.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hwan.chatting.R;

public class TabFragment3 extends Fragment {

    TextView name, sinredo;
    Intent intent,intent1;
    ImageView emotion;
    Button pyo;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_3, container, false);
        intent1 = getActivity().getIntent();
        emotion = (ImageView)view.findViewById(R.id.image_emotion);
        final String[] userInfo = intent1.getStringArrayExtra("strings");
        final String[] usertitle = intent1.getStringArrayExtra("usertitle");
        switch(Integer.parseInt(userInfo[5])) {
            case 0:
                emotion.setImageResource(R.drawable.happy);
                break;
            case 1:
                emotion.setImageResource(R.drawable.surprised);
                break;
            case 2:
                emotion.setImageResource(R.drawable.angry);
                break;
            case 3:
                emotion.setImageResource(R.drawable.fear);
                break;
            case 4:
                emotion.setImageResource(R.drawable.disgust);
                break;
            case 5:
                emotion.setImageResource(R.drawable.sad);
                break;
            default: break;
        }
        name =(TextView) view.findViewById(R.id.text_name);
        sinredo =(TextView) view.findViewById(R.id.text_sinredo);
        name.setText(userInfo[3].toString());
        sinredo.setText(userInfo[4].toString());
        pyo =(Button) view.findViewById(R.id.btnpsa);
        pyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), PyojungSelect.class);
                intent.putExtra("strings", userInfo);
                intent.putExtra("usertitle", usertitle);
                startActivity(intent);
            }
        });
        return view;
    }
}