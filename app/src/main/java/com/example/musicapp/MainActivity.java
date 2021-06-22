package com.example.musicapp;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageButton play, stop;
    Intent intent;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (ImageButton)findViewById(R.id.play);
        stop = (ImageButton)findViewById(R.id.stop);
        text = (TextView)findViewById(R.id.textView3);

        play.setOnClickListener(this);
        stop.setOnClickListener(this);

        intent = new Intent(this, MusicService.class);

    }

    @Override
    public void onClick(View view) {
        if(view == play) {
            String p = "Playing...";
            text.setText(p);
            startService(intent);
        }
        else if(view == stop) {
            String s = "Stopped.";
            text.setText(s);
            stopService(intent);
        }
    }
}


