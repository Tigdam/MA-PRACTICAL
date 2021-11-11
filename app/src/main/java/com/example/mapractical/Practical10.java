package com.example.mapractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Practical10 extends AppCompatActivity {
    EditText et_Text;
    Button b_read,b_write,b_delete;
    TextView tv_Text;
    String file_name="file.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical10);

        et_Text=(EditText)findViewById(R.id.txtcontent);
        b_read=(Button)findViewById(R.id.btnread);
        b_write=(Button)findViewById(R.id.btnwrite);
        tv_Text=(TextView)findViewById(R.id.textView);
        b_delete=(Button) findViewById(R.id.btn_delete);


        b_read.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public  void onClick(View view)
            {
                tv_Text.setText(readFile(file_name));
            }
        });
        b_write.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public  void onClick(View view)
            {
                saveFile(file_name,et_Text.getText().toString());
                Toast.makeText(Practical10.this,"saved text",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void saveFile(String file_name,String text)
    {
        try{

            FileOutputStream fos=openFileOutput(file_name, Context.MODE_PRIVATE);
            fos.write(text.getBytes());
            fos.close();
            Toast.makeText(Practical10.this,"",Toast.LENGTH_SHORT).show();
        }
        catch(Exception e){
            e.printStackTrace();
            Toast.makeText(Practical10.this,"Error saving file",Toast.LENGTH_SHORT).show();

        }
    }
    public  String readFile(String file_name)
    {
        String text="";
        try{
            FileInputStream fis=openFileInput(file_name);
            int size=fis.available();
            byte[] buffer=new byte[size];
            fis.read(buffer);
            fis.close();
            text=new String(buffer);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(Practical10.this,"Error Read file",Toast.LENGTH_SHORT).show();

        }
        return  text;
    }
    public void clearFile(View view){
        et_Text.getText().clear();
    }
    public void deleteFile(View view)
    {
        File file=new File(getFilesDir(),file_name);
        if(file.exists())
        {
            file.delete();
            // deleteFile(filename);
            Toast.makeText(Practical10.this,"file Deleted",Toast.LENGTH_SHORT).show();

        }
        else
        {
            Toast.makeText(Practical10.this,"file not found",Toast.LENGTH_SHORT).show();

        }


    }
}