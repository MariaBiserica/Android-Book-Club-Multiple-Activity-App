package com.example.bookclubmultipleactivityapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BookDetailsActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        // Retrieve data from the intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String author = intent.getStringExtra("author");
        String genre = intent.getStringExtra("genre");
        String description = intent.getStringExtra("briefDescription");
        int iconDrawable = intent.getIntExtra("iconDrawable", 0);
        int coverDrawable = intent.getIntExtra("coverDrawable", 0);

        // Use the retrieved data
        setTitle(title); // Optionally, set the title of the activity to the book's title
        ImageView coverImageView = findViewById(R.id.bookCoverImageView);
        TextView descriptionTextView = findViewById(R.id.bookDescriptionTextView);

        coverImageView.setImageResource(coverDrawable);
        descriptionTextView.setText(description);

        // Find the button by ID and set an OnClickListener
        findViewById(R.id.backButton).setOnClickListener(view -> {
            // Finish BookDetailsActivity to go back to MainActivity
            finish();
        });
    }
}
