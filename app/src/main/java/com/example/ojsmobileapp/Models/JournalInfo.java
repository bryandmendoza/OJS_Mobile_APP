package com.example.ojsmobileapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JournalInfo {
    @SerializedName("journal_id")
    @Expose
    private String journal_id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("portada")
    @Expose
    private String portada;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("abbreviation")
    @Expose
    private String abbreviation;

    @SerializedName("journalThumbnail")
    @Expose
    private String journalThumbnail;

    public String getJournal_id() {
        return journal_id;
    }

    public void setJournal_id(String journal_id) {
        this.journal_id = journal_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getJournalThumbnail() {
        return journalThumbnail;
    }

    public void setJournalThumbnail(String journalThumbnail) {
        this.journalThumbnail = journalThumbnail;
    }
}
