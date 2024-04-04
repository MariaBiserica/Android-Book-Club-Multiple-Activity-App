package com.example.bookclubmultipleactivityapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class WebInfoActivity4 extends AppCompatActivity {

    private ProgressBar progressBar;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_info);

        // Initialize WebView and ProgressBar
        webView = findViewById(R.id.webview);
        progressBar = findViewById(R.id.progressBar);
        progressBar.bringToFront(); // Make sure ProgressBar is on top

        // Set WebViewClient to WebView
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE); // Show the ProgressBar when page loading starts
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE); // Hide the ProgressBar when page loading finishes
            }

            // Override onReceivedError to handle errors during loading
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                progressBar.setVisibility(View.GONE);
            }
        });

        // Get the URL from the intent
        Intent intent = getIntent();
        String reviewUrl = intent.getStringExtra("reviewUrl");
        Log.d("WebReviewActivity", "Loading URL: " + reviewUrl);

        // Load the URL into the WebView
        webView.loadUrl(reviewUrl);

        // Button handling to go back
        Button goBackButton = findViewById(R.id.goBackButton);
        goBackButton.setOnClickListener(view -> finish()); // Finish and return to previous Activity
    }
}
