package com.example.ojsmobileapp.Models;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ojsmobileapp.R;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@Layout(R.layout.journals_item)
public class JournalView {
    @View(R.id.jiTxtTitle)
    public TextView jiTxtTitle;

    @View(R.id.jiTxtDescription)
    public TextView jiTxtDescription;

    @View(R.id.jiImageView)
    public ImageView jiImageView;

    public JournalInfo info;
    public Context context;

    public JournalView(Context context, JournalInfo info) {
        this.info = info;
        this.context = context;
    }

    @Resolve
    public void onResolved() {
        jiTxtTitle.setText(info.getName());
        jiTxtDescription.setText(info.getDescription());
        Glide.with(context).load(info.getPortada()).into(jiImageView);
    }
}
