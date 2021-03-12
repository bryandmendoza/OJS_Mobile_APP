package com.example.ojsmobileapp.Helpers;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ojsmobileapp.Models.IssueInfo;
import com.example.ojsmobileapp.Models.JournalInfo;
import com.example.ojsmobileapp.Models.PubInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    private static RequestQueue request;
    private static StringRequest stringRq;

    public static void getJournalsData(Context context, final VolleyCallback callback) {
        request = Volley.newRequestQueue(context);
        String URL = "https://revistas.uteq.edu.ec/ws/journals.php";
        stringRq = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONArray journalsData = null;
                List<JournalInfo> list;
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
                    list = null;
                    e.printStackTrace();
                }
                callback.onSuccess(list);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Sucedió un error en la consulta. Intente nuevamente. \n Detalle del error: "+error.getMessage() , Toast.LENGTH_LONG).show();
            }
        });
        request.add(stringRq);
    }

    public static void getIssuesData(Context context, final VolleyCallbackIssue callback, String journalID) {
        request = Volley.newRequestQueue(context);
        String URL = "https://revistas.uteq.edu.ec/ws/issues.php?j_id="+journalID;
        stringRq = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONArray issuesData = null;
                List<IssueInfo> list;
                try {
                    GsonBuilder builder = new GsonBuilder();
                    Gson gson = builder.create();
                    issuesData = new JSONArray(response);
                    list = new ArrayList<>();
                    for(int i=0;i<issuesData.length();i++){
                        IssueInfo issue = gson.fromJson(issuesData.getString(i), IssueInfo.class);
                        list.add(issue);
                    }
                } catch (JSONException e) {
                    list = null;
                    e.printStackTrace();
                }
                callback.onSuccess(list);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Sucedió un error en la consulta. Intente nuevamente. \n Detalle del error: "+error.getMessage() , Toast.LENGTH_LONG).show();
            }
        });
        request.add(stringRq);
    }

    public static void getPubsData(Context context, final VolleyCallbackPub callback, String issueID) {
        request = Volley.newRequestQueue(context);
        String URL = "https://revistas.uteq.edu.ec/ws/pubs.php?i_id="+issueID;
        stringRq = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONArray pubsData = null;
                List<PubInfo> list;
                try {
                    GsonBuilder builder = new GsonBuilder();
                    Gson gson = builder.create();
                    pubsData = new JSONArray(response);
                    list = new ArrayList<>();
                    for(int i=0;i<pubsData.length();i++){
                        if (pubsData.get(i) instanceof JSONArray) {

                        } else {
                            PubInfo pub = gson.fromJson(pubsData.getString(i), PubInfo.class);
                            list.add(pub);
                        }
                    }
                } catch (JSONException e) {
                    list = null;
                    e.printStackTrace();
                }
                callback.onSuccess(list);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Sucedió un error en la consulta. Intente nuevamente. \n Detalle del error: "+error.getMessage() , Toast.LENGTH_LONG).show();
            }
        });
        request.add(stringRq);
    }
}
