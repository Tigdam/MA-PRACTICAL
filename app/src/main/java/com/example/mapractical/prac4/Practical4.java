package com.example.mapractical.prac4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.mapractical.R;

public class Practical4 extends AppCompatActivity {
    RadioButton rb;
    RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical4);
        rg=findViewById(R.id.rgp);
    }
    public void check_radio(View view) {
        int radio_id=rg.getCheckedRadioButtonId();
        rb=findViewById(radio_id);
        Toast.makeText(Practical4.this,"Selected Radio Button is "+rb.getText(),Toast.LENGTH_SHORT).show();
    }
}