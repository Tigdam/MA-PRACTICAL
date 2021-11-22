package com.example.mapractical;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonVolley extends AppCompatActivity {
    private TextView txtview;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_volley);
        txtview=(TextView)findViewById(R.id.textview1);
        Button b1=(Button)findViewById(R.id.button1);
        requestQueue = Volley.newRequestQueue(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });

    }

    private void jsonParse(){
        String url="https://api.jsonserve.com/-6H_4P";
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("employees");
                            for(int i=0; i<jsonArray.length(); i++){

                                JSONObject emp = jsonArray.getJSONObject(i);
                                String firstname=emp.getString("firstname");
                                int age=emp.getInt("age");
                                String country=emp.getString("country");
                                txtview.append("FirstName : "+firstname+ ",\nage : " + String.valueOf(age)+ ",\ncountry : " +country+ "\n\n" );
                            }
                        } catch ( JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }

}