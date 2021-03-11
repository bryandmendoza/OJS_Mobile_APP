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

@Layout(R.layout.issues_item)
public class IssueView {
    @View(R.id.iiTxtTitle)
    public TextView iiTxtTitle;

    @View(R.id.iiTxtDatePublished)
    public TextView iiTxtDatePublished;

    @View(R.id.iiImageView)
    public ImageView iiImageView;

    @View(R.id.iiBtnViewMore)
    public Button iiBtnViewMore;

    public IssueInfo info;
    public Context context;

    public IssueView(Context context, IssueInfo info) {
        this.info = info;
        this.context = context;
    }

    @Resolve
    public void onResolved() {
        iiTxtTitle.setText(info.getTitle());
        iiTxtDatePublished.setText(info.getDate_published());
        Glide.with(context).load(info.getCover()).into(iiImageView);
        iiBtnViewMore.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent intent = new Intent(context, IssuesActivity.class);
                Bundle b = new Bundle();
                b.putString("issue_id", info.getIssue_id());
                intent.putExtras(b);
                context.startActivity(intent);
            }
        });
    }
}
