package com.example.mapractical;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


public class Practical12 extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    TextView password;
    TextView email;
    CheckBox remember;

    public static final String mypreferences="mypref";
    public static final String Email="emailKey";
    public static final String Password="passwordKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical12);

        email =(TextView)findViewById(R.id.editText_email);
        password =(TextView)findViewById(R.id.editText_password);

        sharedPreferences = getSharedPreferences(mypreferences, Context.MODE_PRIVATE);
        if (sharedPreferences.contains(Email))
        {
            email.setText(sharedPreferences.getString(Email,""));
        }

        if (sharedPreferences.contains(Password))
        {
            password.setText(sharedPreferences.getString(Password," "));
        }


    }

    public void Get(View view)
    {
        email = (TextView)findViewById(R.id.editText_email);
        password = (TextView)findViewById(R.id.editText_password);
        sharedPreferences = getSharedPreferences(mypreferences,Context.MODE_PRIVATE);

        if (sharedPreferences.contains(Email))
        {
            email.setText(sharedPreferences.getString(Email," "));
        }
        if (sharedPreferences.contains(Password))
        {
            password.setText(sharedPreferences.getString(Password," "));

        }
    }

    public void Save(View view)
    {
        if(remember.isChecked( ))
        {
            String e = email.getText( ).toString( );
            String p = password.getText( ).toString( );
            SharedPreferences.Editor editor=sharedPreferences.edit( );
            editor.putString(Email,e);
            editor.putString(Password,p);
            editor.commit( );
            Toast toast = Toast.makeText(getApplicationContext( ),"Value stored in shared preference",
                    Toast.LENGTH_SHORT );
            toast.show( );
        }
    }

    public void clear(View view)
    {
        email = (TextView)findViewById(R.id.editText_email);
        password = (TextView)findViewById(R.id.editText_password);
        email.setText(" ");
        password.setText(" ");
    }

}