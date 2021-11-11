package com.example.mapractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Practical7 extends AppCompatActivity {
    private WifiManager wifiManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical7);

        wifiManager=(WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
    }

    public void isWifi_on(View view)
    {
        wifiManager.setWifiEnabled(true);
        Toast.makeText(this,"Wifi is turn ON",Toast.LENGTH_SHORT).show();
    }

    public void isWifi_off(View view)
    {
        wifiManager.setWifiEnabled(false);

        Toast.makeText(this,"Wifi is turn off",Toast.LENGTH_SHORT).show();
    }


}