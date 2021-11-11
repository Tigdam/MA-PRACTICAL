package com.example.mapractical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Practical2 extends AppCompatActivity {
    Button ok;
    EditText edt;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical2);

        ok = (Button) findViewById(R.id.button);
        edt = (EditText) findViewById(R.id.editText3);
        tv = (TextView) findViewById(R.id.textView4);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = edt.getText().toString();
                tv.setText(msg);
            }
        });

    }
}