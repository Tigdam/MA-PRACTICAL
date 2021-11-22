package com.example.mapractical;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Practical16 extends AppCompatActivity {
    VideoView v;
    MediaController m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pactical16);

        v=(VideoView)findViewById(R.id.vv);
        m=new MediaController(this);
        v.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.abc);
        m.setAnchorView(v);
        v.setMediaController(m);
        v.start();

    }
}