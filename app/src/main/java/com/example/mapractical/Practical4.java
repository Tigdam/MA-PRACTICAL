package com.example.mapractical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Practical4 extends AppCompatActivity {
    EditText e1;
    Button b_toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical4);

        e1=(EditText)findViewById(R.id.et1);
        b_toast=(Button)findViewById(R.id.b3);
        b_toast.setOnClickListener(new View.OnClickListener( )
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(Practical4.this,e1.getText(),Toast.LENGTH_LONG).show( );
            }
        });

    }
}