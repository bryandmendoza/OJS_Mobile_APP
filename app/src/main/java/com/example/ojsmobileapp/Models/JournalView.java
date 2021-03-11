package com.example.ojsmobileapp.Models;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ojsmobileapp.IssuesActivity;
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

    @View(R.id.jiBtnViewMore)
    public Button jiBtnViewMore;

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
        jiBtnViewMore.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent intent = new Intent(context, IssuesActivity.class);
                Bundle b = new Bundle();
                b.putString("", "");
                intent.putExtras(b);
                context.startActivity(intent);
            }
        });
    }
}
