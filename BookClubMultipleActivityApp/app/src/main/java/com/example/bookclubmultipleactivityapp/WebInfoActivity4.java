package com.example.bookclubmultipleactivityapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WebInfoActivity4 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_info);

        WebView webView = findViewById(R.id.webview);
        Intent intent = getIntent();

        String reviewUrl = intent.getStringExtra("reviewUrl");
        Log.d("WebReviewActivity", "Loading URL: " + reviewUrl);
        webView.loadUrl(reviewUrl);

        Button goBackButton = findViewById(R.id.goBackButton);
        goBackButton.setOnClickListener(view -> {
            // Finish this activity, returning to the previous one
            finish();
        });
    }
}
