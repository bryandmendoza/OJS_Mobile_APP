package com.example.ojsmobileapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IssueInfo {
    @SerializedName("issue_id")
    @Expose
    private String issue_id;

    @SerializedName("volume")
    @Expose
    private String volume;

    @SerializedName("number")
    @Expose
    private String number;

    @SerializedName("year")
    @Expose
    private String year;

    @SerializedName("date_published")
    @Expose
    private String date_published;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("doi")
    @Expose
    private String doi;

    @SerializedName("cover")
    @Expose
    private String cover;

    public String getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(String issue_id) {
        this.issue_id = issue_id;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDate_published() {
        return date_published;
    }

    public void setDate_published(String date_published) {
        this.date_published = date_published;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
