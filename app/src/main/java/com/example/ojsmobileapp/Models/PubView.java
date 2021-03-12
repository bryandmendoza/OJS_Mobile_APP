package com.example.ojsmobileapp.Models;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ojsmobileapp.IssuesActivity;
import com.example.ojsmobileapp.R;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@Layout(R.layout.pubs_item)
public class PubView {
    @View(R.id.piTxtTitle)
    public TextView piTxtTitle;

    @View(R.id.piTxtAuthors)
    public TextView piTxtAuthors;

    @View(R.id.piBtnDownloadPDF)
    public Button piBtnDownloadPDF;

    public PubInfo info;
    public Context context;

    public PubView(Context context, PubInfo info) {
        this.info = info;
        this.context = context;
    }

    @Resolve
    public void onResolved() {
        piTxtTitle.setText(info.getTitle());
        String authors = "";
        String url = "";
        for(int i=0;i<info.getAuthors().size();i++) {
            if (i > 0) {
                authors += ", ";
            }
            authors += info.getAuthors().get(i).getNombres();
        }
        for(int i=0;i<info.getGaleys().size();i++) {
            if (info.getGaleys().get(i).getLabel().equals("PDF")) {
                url = info.getGaleys().get(i).getUrlViewGallery();
                break;
            }
        }
        piTxtAuthors.setText(authors);
        piBtnDownloadPDF.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                Toast.makeText(context, "Has elegido descargar el pdf", Toast.LENGTH_LONG).show();
            }
        });
    }
}
