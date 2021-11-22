package com.example.mapractical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Practical14 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pactical14);


    }
    public void move(View view) {
        ImageView image= findViewById(R.id.imageView);
        Animation animate1= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        image.startAnimation(animate1);
    }
    public  void fade(View view)
    {
        ImageView image= findViewById(R.id.imageView);
        Animation animate2=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        image.startAnimation(animate2);
    }
    public void  rotate(View view)
    {
        ImageView image= findViewById(R.id.imageView);
        Animation animate3=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        image.startAnimation(animate3);
    }
    public void blink(View view)
    {
        ImageView image= findViewById(R.id.imageView);
        Animation animate4=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        image.startAnimation(animate4);
    }


}