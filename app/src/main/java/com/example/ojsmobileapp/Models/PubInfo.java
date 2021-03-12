package com.example.ojsmobileapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PubInfo {
    @SerializedName("section")
    @Expose
    private String section;

    @SerializedName("publication_id")
    @Expose
    private String publication_id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("doi")
    @Expose
    private String doi;

    @SerializedName("abstract")
    @Expose
    private String _abstract;

    @SerializedName("date_published")
    @Expose
    private String date_published;

    @SerializedName("submission_id")
    @Expose
    private String submission_id;

    @SerializedName("section_id")
    @Expose
    private String section_id;

    @SerializedName("seq")
    @Expose
    private String seq;

    @SerializedName("galeys")
    @Expose
    private List<PubAuthorInfo> galeys;

    @SerializedName("keywords")
    @Expose
    private List<PubAuthorInfo> keywords;

    @SerializedName("authors")
    @Expose
    private List<PubAuthorInfo> authors;

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getPublication_id() {
        return publication_id;
    }

    public void setPublication_id(String publication_id) {
        this.publication_id = publication_id;
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

    public String getDate_published() {
        return date_published;
    }

    public void setDate_published(String date_published) {
        this.date_published = date_published;
    }

    public String getSubmission_id() {
        return submission_id;
    }

    public void setSubmission_id(String submission_id) {
        this.submission_id = submission_id;
    }

    public String get_abstract() {
        return _abstract;
    }

    public void set_abstract(String _abstract) {
        this._abstract = _abstract;
    }

    public String getSection_id() {
        return section_id;
    }

    public void setSection_id(String section_id) {
        this.section_id = section_id;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public List<PubAuthorInfo> getGaleys() {
        return galeys;
    }

    public void setGaleys(List<PubAuthorInfo> galeys) {
        this.galeys = galeys;
    }
}
