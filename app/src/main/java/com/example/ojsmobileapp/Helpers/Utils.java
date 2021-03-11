package com.example.ojsmobileapp.Helpers;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ojsmobileapp.Models.JournalInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    private static RequestQueue request;
    private static StringRequest stringRq;
    private static List<JournalInfo> list;

    public static List<JournalInfo> getJournalsData(Context context) {
        list = null;
        request = Volley.newRequestQueue(context);
        String URL = "https://revistas.uteq.edu.ec/ws/journals.php";
        stringRq = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONArray journalsData = null;
                try {
                    GsonBuilder builder = new GsonBuilder();
                    Gson gson = builder.create();
                    journalsData = new JSONArray(response);
                    list = new ArrayList<>();
                    for(int i=0;i<journalsData.length();i++){
                        JournalInfo journal = gson.fromJson(journalsData.getString(i), JournalInfo.class);
                        list.add(journal);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Sucedió un error en la consulta. Intente nuevamente. \n Detalle del error: "+error.getMessage() , Toast.LENGTH_LONG).show();
            }
        });
        request.add(stringRq);
        return list;
    }
}
