package com.example.ojsmobileapp.Models;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.webkit.WebView;
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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
        String urlString = "";
        for(int i=0;i<info.getAuthors().size();i++) {
            if (i > 0) {
                authors += ", ";
            }
            authors += info.getAuthors().get(i).getNombres();
        }
        for(int i=0;i<info.getGaleys().size();i++) {
            if (info.getGaleys().get(i).getLabel().equals("pdf")) {
                urlString = info.getGaleys().get(i).getUrlViewGalley();
                break;
            }
        }
        piTxtAuthors.setText(authors);
        String finalUrlString = urlString;
        piBtnDownloadPDF.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                try {
                    URL url = new URL(finalUrlString);
                    Toast.makeText(context, finalUrlString, Toast.LENGTH_LONG).show();

                    DownloadManager dm = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(finalUrlString));
                    request.allowScanningByMediaScanner();
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    request.setDestinationInExternalFilesDir(context, Environment.DIRECTORY_DOWNLOADS, "articulo.pdf");
                    dm.enqueue(request);

                    /*HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setDoOutput(true);
                    urlConnection.connect();

                    InputStream inputStream = urlConnection.getInputStream();
                    FileOutputStream fileOutputStream = new FileOutputStream("articulo.pdf");
                    int totalSize = urlConnection.getContentLength();

                    byte[] buffer = new byte[1024 * 1024];
                    int bufferLength = 0;
                    while((bufferLength = inputStream.read(buffer))>0 ){
                        fileOutputStream.write(buffer, 0, bufferLength);
                    }
                    fileOutputStream.close();*/
                } catch (IOException e) {
                    Toast.makeText(context, "No se ha podido descargar el PDF", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
    }
}
