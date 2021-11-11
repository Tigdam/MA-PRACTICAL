package com.example.mapractical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Practical3 extends AppCompatActivity {
    EditText num1,num2,result;
    Button add,sub,div,mul;
    TextView tv1,tv2,tv3;
    float result_num;
    int x,y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical3);

        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        num1=findViewById(R.id.num1);
        num2=findViewById(R.id.num2);
        result=findViewById(R.id.result);
        add=findViewById(R.id.add);
        sub=findViewById(R.id.sub);
        mul=findViewById(R.id.Mul);
        div=findViewById(R.id.Div);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x = Integer.parseInt(num1.getText().toString());
                y = Integer.parseInt(num2.getText().toString());
                result_num = x + y;
                result.setText(String.valueOf(result_num));
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x = Integer.parseInt(num1.getText().toString());
                y = Integer.parseInt(num2.getText().toString());
                result_num = x - y;
                result.setText(String.valueOf(result_num));
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x = Integer.parseInt(num1.getText().toString());
                y = Integer.parseInt(num2.getText().toString());
                result_num = x / y;
                result.setText(String.valueOf(result_num));
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x = Integer.parseInt(num1.getText().toString());
                y = Integer.parseInt(num2.getText().toString());
                result_num = x * y;
                result.setText(String.valueOf(result_num));
            }
        });

    }
}