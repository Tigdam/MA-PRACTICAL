package com.example.mapractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;

public class Practical13 extends AppCompatActivity {
    EditText e1;
    RadioButton r1,r2;
    CheckBox c1,c2,c3;
    Button b1;
    RatingBar rb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical13);

        e1=(EditText)findViewById(R.id.et1);
        r1=(RadioButton)findViewById(R.id.rb1);
        r2=(RadioButton)findViewById(R.id.rb2);
        c1=(CheckBox)findViewById(R.id.cb1);
        c2=(CheckBox)findViewById(R.id.cb2);
        // c3=(CheckBox)findViewById(R.id.cb3);
        b1=(Button)findViewById(R.id.b1);
        rb1= (RatingBar) findViewById(R.id.ratingbar1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gender;
                String name = e1.getText().toString();
                String course = " ";
                String rating = String.valueOf(rb1.getRating());
                if (r1.isChecked()) {
                    gender = r1.getText().toString();
                } else {
                    gender = r2.getText().toString();
                }
                if (c1.isChecked()) {
                    course = c1.getText().toString();
                }
                if (c2.isChecked()) {
                    course = course + " , " + c2.getText().toString();
                }
                Intent intent = new Intent(Practical13.this, MainActivity2.class);
                intent.putExtra("NAME", name);
                intent.putExtra("GENDER", gender);
                intent.putExtra("COURSE", course);
                intent.putExtra("RATING", rating);
                startActivity(intent);
            }
        });

    }
}