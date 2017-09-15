package com.example.android.retriever;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static com.example.android.retriever.R.id.list_item;
import static com.example.android.retriever.R.id.profilePix;
import static com.example.android.retriever.R.id.profileUrl;
import static com.example.android.retriever.R.id.username;

public class profile_detailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_detail);

    }
    //sharing profile detail via users chosen app
    public void shareIt(View view){

        TextView usernameTextView = (TextView) findViewById(R.id.username);
        String usernameContent = usernameTextView.getText().toString();

        TextView profileUrlTextView = (TextView) findViewById(R.id.profileUrl);
        String profileUrlContent = profileUrlTextView.getText().toString();

        String messageBody = shareBody(usernameContent, profileUrlContent);

        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT,messageBody );
        startActivity(Intent.createChooser(sharingIntent, "Share Via"));

    }
        // this method build message to be shared
    private String shareBody(String user, String Url){
        String body = "Check this @ \n< " + user +" > \n< " + Url +" >";
        return body;
    }
}
