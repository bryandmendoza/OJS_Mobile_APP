package com.example.ojsmobileapp.Helpers;

import com.example.ojsmobileapp.Models.IssueInfo;
import com.example.ojsmobileapp.Models.JournalInfo;

import java.util.List;

public interface VolleyCallbackIssue {
    void onSuccess(List<IssueInfo> result);
}
