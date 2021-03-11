package com.example.ojsmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.ojsmobileapp.Helpers.Utils;
import com.example.ojsmobileapp.Helpers.VolleyCallback;
import com.example.ojsmobileapp.Helpers.VolleyCallbackIssue;
import com.example.ojsmobileapp.Models.IssueInfo;
import com.example.ojsmobileapp.Models.IssueView;
import com.example.ojsmobileapp.Models.JournalInfo;
import com.example.ojsmobileapp.Models.JournalView;
import com.mindorks.placeholderview.InfinitePlaceHolderView;

import java.util.List;

public class IssuesActivity extends AppCompatActivity {
    private InfinitePlaceHolderView issuesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issues);

        issuesList = findViewById(R.id.issuesList);
        setupIssues();
    }

    private void setupIssues() {
        Utils.getIssuesData(this.getApplicationContext(), new VolleyCallbackIssue() {
            @Override
            public void onSuccess(List<IssueInfo> result) {
                List<IssueInfo> list = result;
                for (int i = 0; i < list.size(); i++) {
                    issuesList.addView(new IssueView(IssuesActivity.this.getApplicationContext(), list.get(i)));
                }
            }
        }, this.getIntent().getExtras().getString("journal_id"));
    }

    public void goBack(View v) {
        finish();
    }
}