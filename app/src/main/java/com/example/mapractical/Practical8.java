package com.example.mapractical;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Practical8 extends AppCompatActivity {
    Button b1,b2;
    BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical8);

        b1=(Button)findViewById(R.id.btnOn);
        b2=(Button)findViewById(R.id.btnOff);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bluetoothAdapter==null)
                {
                    Toast.makeText(getApplicationContext(),"Bluetooth not supported", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(!bluetoothAdapter.isEnabled())
                    {

                        Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        startActivityForResult(enableBtIntent, 0);
                        Toast.makeText(getApplicationContext(),"Bluetooth Turned ON",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bluetoothAdapter.disable();
                Toast.makeText(getApplicationContext(),"Bluetooth Turned Off",Toast.LENGTH_SHORT).show();
            }
        });

    }
}