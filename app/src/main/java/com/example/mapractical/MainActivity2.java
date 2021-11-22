package com.example.mapractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView tv1=(TextView)findViewById(R.id.tv_name);
        TextView tv2=(TextView)findViewById(R.id.tv_gender);
        TextView tv3=(TextView)findViewById(R.id.tv_Course);
        TextView tv4=(TextView)findViewById(R.id.tv_rating);
        Intent intent=getIntent( );
        // intent.getSerializableExtra("Name");
        String name = intent.getStringExtra("NAME");
        String gender = intent.getStringExtra("GENDER");
        String course = intent.getStringExtra("COURSE");
        String rating = intent.getStringExtra("RATING");
        tv1.setText("Name : "+name);
        tv2.setText("Gender : "+gender);
        tv3.setText("Course : "+course);
        tv4.setText("Rating : "+rating);

    }
}