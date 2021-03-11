package com.example.ojsmobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.os.Bundle;

import com.example.ojsmobileapp.Helpers.Utils;
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
        List<JournalInfo> list = Utils.getJournalsData(this.getApplicationContext());
        for (int i = 0; i < list.size(); i++) {
            journalsList.addView(new JournalView(this.getApplicationContext(), list.get(i)));
        }
        //journalsList.setLoadMoreResolver(new LoadMore(journalsList, list));
    }
}