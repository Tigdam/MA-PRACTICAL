package com.example.mapractical;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

public class database extends AppCompatActivity implements android.view.View.OnClickListener
{
    SQLiteDatabase db;
    EditText editSearchContact, editName, editEmailAddress, editMessage;
    Button Add, Delete, Modify, View, search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        //Create database,ContactDb database name
        db = openOrCreateDatabase("ContactDb", Context.MODE_PRIVATE, null);
        //create table Contact
        db.execSQL("CREATE TABLE IF NOT EXISTS Contact(cId INTEGER PRIMARY KEY AUTOINCREMENT,Name VARCHAR,Mail VARCHAR,CMessage VARCHAR);");
        editSearchContact = (EditText) findViewById(R.id.editTextSearch);
        editName = (EditText) findViewById(R.id.editTextName);
        editEmailAddress = (EditText) findViewById(R.id.editTextEmailAddress);
        editMessage = (EditText) findViewById(R.id.editTextMessage);
        Add = (Button) findViewById(R.id.btnsave);
        Delete = (Button) findViewById(R.id.btndel);
        Modify = (Button) findViewById(R.id.btnupdate);
        View = (Button) findViewById(R.id.btnselect);
        search = (Button) findViewById(R.id.btnselectperticular);
        Add.setOnClickListener(this);
        Delete.setOnClickListener(this);
        Modify.setOnClickListener(this);
        View.setOnClickListener(this);
        search.setOnClickListener(this);
    }

    public void msg(Context context, String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(android.view.View v) {
        if (v.getId() == R.id.btnsave) {
            // code for save data
            if (editName.getText().toString().trim().length() == 0 ||
                    editEmailAddress.getText().toString().trim().length() == 0 ||
                    editMessage.getText().toString().trim().length() == 0) {
                msg(this, "Please enter all values");
                return;
            }
            db.execSQL("INSERT INTO Contact(Name,Mail,CMessage)VALUES('" + editName.getText() + "','" + editEmailAddress.getText() + "','" + editMessage.getText() + "');");
            editName.getText().clear();
            editEmailAddress.getText().clear();
            editMessage.getText().clear();
            msg(this, "Data Inserted.");
        } else if (v.getId() == R.id.btnupdate) {
            //code for update data
            if (editSearchContact.getText().toString().trim().length() == 0) {
                msg(this, "Enter  Name");
                return;
            }
            Cursor c = db.rawQuery("SELECT * FROM Contact WHERE Name='" + editSearchContact.getText() + "'", null);
            if (c.moveToFirst()) {
                db.execSQL("UPDATE Contact  SET Name ='" + editName.getText() + "', Mail='" + editEmailAddress.getText() + "',CMessage='" + editMessage.getText() + "' WHERE Name ='" + editSearchContact.getText() + "'");
                editName.getText().clear();
                editEmailAddress.getText().clear();
                editMessage.getText().clear();
                editSearchContact.getText().clear();
                msg(this, "Data Updated.");
            } else {
                msg(this, "Invalid Name");
            }
        } else if (v.getId() == R.id.btndel) {
            //code for delete data
            if (editSearchContact.getText().toString().trim().length() == 0) {
                msg(this, " Please enter Name ");
                return;
            }
            Cursor c = db.rawQuery("SELECT * FROM Contact WHERE Name ='" + editSearchContact.getText() + "'", null);
            if (c.moveToFirst()) {
                db.execSQL("DELETE FROM Contact WHERE Name ='" + editSearchContact.getText() + "'");
                editName.getText().clear();
                editEmailAddress.getText().clear();
                editMessage.getText().clear();
                msg(this, "Data Deleted.");
            } else {
                msg(this, "Invalid Name ");
            }
        } else if (v.getId() == R.id.btnselect) {
            //code for select all data
            Cursor c = db.rawQuery("SELECT * FROM Contact", null);
            if (c.getCount() == 0) {
                msg(this, "No records found");
                return;
            }
            StringBuffer buffer = new StringBuffer();
            while (c.moveToNext()) {
                buffer.append("Name: " + c.getString(1) + "\n");
                buffer.append("Mail: " + c.getString(2) + "\n\n");
                buffer.append("Message: " + c.getString(3) + "\n\n");
            }
            msg(this, buffer.toString());
        } else if (v.getId() == R.id.btnselectperticular) {
            //code for select particular data
            if (editSearchContact.getText().toString().trim().length() == 0) {
                msg(this, "Enter Name");
                return;
            }
            Cursor c = db.rawQuery("SELECT * FROM Contact WHERE Name='" + editSearchContact.getText() + "'", null);
            if (c.moveToFirst()) {
                editName.setText(c.getString(1));
                editEmailAddress.setText(c.getString(2));
                editMessage.setText(c.getString(3));
            } else {
                msg(this, "Invalid Name");
            }
        }
    }
}
