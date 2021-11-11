package com.example.mapractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Practical5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical5);

        Button btn1=(Button)findViewById(R.id.btnimp);
        Button btn2=(Button)findViewById(R.id.btnexp);
        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com"));
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Intent intent1 = new Intent(getApplicationContext(),ExplicitActivity.class);
                Intent intent1  = new Intent(getApplicationContext(),Practical5_ExplicitActivity.class);
                startActivity(intent1);
            }
        });

    }
}