package com.example.mapractical;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;

public class Practical9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical9);

        onButtonClickListener();

    }
    public void onButtonClickListener()
    {
        Button button_sbm = (Button) findViewById(R.id.Button);
        button_sbm.setOnClickListener (
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        AlertDialog.Builder a_builder=new AlertDialog.Builder(Practical9.this);
                        a_builder.setMessage("Do you Want to close this app")
                                .setCancelable(false)
                                .setPositiveButton("YES",new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialog,int which)
                                    {
                                        finish();
                                    }
                                })
                                .setNegativeButton("No",new DialogInterface.OnClickListener()
                                {
                                    public void onClick(DialogInterface dialog,int which)
                                    {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert=a_builder.create();
                        alert.setTitle("Alert!!");
                        alert.show();
                    }
                }
        );
    }

}