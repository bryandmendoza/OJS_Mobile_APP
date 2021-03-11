package com.example.ojsmobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.os.Bundle;

import com.example.ojsmobileapp.Helpers.Utils;
import com.example.ojsmobileapp.Helpers.VolleyCallback;
import com.example.ojsmobileapp.Models.JournalInfo;
import com.example.ojsmobileapp.Models.JournalView;
import com.mindorks.placeholderview.InfinitePlaceHolderView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private InfinitePlaceHolderView journalsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        journalsList = findViewById(R.id.journalsList);
        setupJournals();
    }

    private void setupJournals() {
        Utils.getJournalsData(this.getApplicationContext(), new VolleyCallback() {
            @Override
            public void onSuccess(List<JournalInfo> result) {
                List<JournalInfo> list = result;
                for (int i = 0; i < list.size(); i++) {
                    journalsList.addView(new JournalView(MainActivity.this.getApplicationContext(), list.get(i)));
                }
            }
        });
    }
}