package com.example.heynotification;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Message extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.msg);

        TextView textmsg=findViewById(R.id.textmsg);
//        String msg=getIntent().getStringExtra("message");
//        textmsg.setText(msg);
    }
}
