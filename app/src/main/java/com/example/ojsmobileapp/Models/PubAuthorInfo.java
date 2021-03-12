package com.example.ojsmobileapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PubAuthorInfo {
    @SerializedName("galley_id")
    @Expose
    private String galley_id;

    @SerializedName("label")
    @Expose
    private String label;

    @SerializedName("file_id")
    @Expose
    private String file_id;

    @SerializedName("UrlViewGallery")
    @Expose
    private String UrlViewGallery;

    public String getGalley_id() {
        return galley_id;
    }

    public void setGalley_id(String galley_id) {
        this.galley_id = galley_id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getFile_id() {
        return file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public String getUrlViewGallery() {
        return UrlViewGallery;
    }

    public void setUrlViewGallery(String urlViewGallery) {
        UrlViewGallery = urlViewGallery;
    }
}
