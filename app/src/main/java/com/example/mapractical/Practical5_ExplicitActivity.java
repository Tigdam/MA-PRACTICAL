package com.example.mapractical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Practical5_ExplicitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical5_explicit);

        Toast.makeText(getApplicationContext()," welcome to Explicit Activity.!  ",Toast.LENGTH_LONG).show();

    }
}