package com.example.ojsmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private RequestQueue request;
    private StringRequest stringRq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void getJournalsData(View view) {
        request = Volley.newRequestQueue(MainActivity.this);
        String URL = "https://revistas.uteq.edu.ec/ws/journals.php";
        stringRq = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONArray journalsData = null;
                try {
                    journalsData = new JSONArray(response);
                    if (journalsData.length() == 0) {
                        Toast.makeText(MainActivity.this, "No se ha encontrado revistas científicas.", Toast.LENGTH_LONG).show();
                        return;
                    }
                    else {
                        JSONObject journal = journalsData.getJSONObject(0);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Sucedió un error en la consulta. Intente nuevamente. \n Detalle del error: "+error.getMessage() , Toast.LENGTH_LONG).show();
            }
        });
        request.add(stringRq);
    }
}