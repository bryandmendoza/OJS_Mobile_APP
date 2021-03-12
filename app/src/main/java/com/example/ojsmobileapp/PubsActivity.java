package com.example.ojsmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.ojsmobileapp.Helpers.Utils;
import com.example.ojsmobileapp.Helpers.VolleyCallbackIssue;
import com.example.ojsmobileapp.Helpers.VolleyCallbackPub;
import com.example.ojsmobileapp.Models.IssueInfo;
import com.example.ojsmobileapp.Models.IssueView;
import com.example.ojsmobileapp.Models.PubInfo;
import com.example.ojsmobileapp.Models.PubView;
import com.mindorks.placeholderview.InfinitePlaceHolderView;

import java.util.List;

public class PubsActivity extends AppCompatActivity {
    private InfinitePlaceHolderView pubsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pubs);

        pubsList = findViewById(R.id.pubsList);
        setupPubs();
    }

    private void setupPubs() {
        Utils.getPubsData(this.getApplicationContext(), new VolleyCallbackPub() {
            @Override
            public void onSuccess(List<PubInfo> result) {
                List<PubInfo> list = result;
                for (int i = 0; i < list.size(); i++) {
                    pubsList.addView(new PubView(PubsActivity.this.getApplicationContext(), list.get(i)));
                }
            }
        }, this.getIntent().getExtras().getString("issue_id"));
    }

    public void goBack(View v) {
        finish();
    }
}