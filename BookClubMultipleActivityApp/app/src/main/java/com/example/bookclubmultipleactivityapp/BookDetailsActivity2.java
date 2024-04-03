package com.example.bookclubmultipleactivityapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
        // Additional fields for Activity3
        String fullDescription = intent.getStringExtra("fullDescription");
        float rating = intent.getFloatExtra("rating", 0f);
        int numberOfRatings = intent.getIntExtra("numberOfRatings", 0);
        int numberOfReviews = intent.getIntExtra("numberOfReviews", 0);
        int numberOfPages = intent.getIntExtra("numberOfPages", 0);
        String publishingDate = intent.getStringExtra("publishingDate");

        // Use the retrieved data
        setTitle(title); // Optionally, set the title of the activity to the book's title
        ImageView coverImageView = findViewById(R.id.bookCoverImageView);
        TextView descriptionTextView = findViewById(R.id.bookDescriptionTextView);

        coverImageView.setImageResource(coverDrawable);
        descriptionTextView.setText(description);

        // Back button to return to the main list
        findViewById(R.id.backButton).setOnClickListener(view -> finish());

        // More Details button setup
        findViewById(R.id.moreDetailsButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailIntent = new Intent(BookDetailsActivity2.this, BookDetailsActivity3.class);

                // Passing along all necessary details to Activity3
                detailIntent.putExtra("title", title); // Though title is not mentioned for Activity3, you might still need it
                detailIntent.putExtra("coverDrawable", coverDrawable);
                detailIntent.putExtra("fullDescription", fullDescription);
                detailIntent.putExtra("rating", rating);
                detailIntent.putExtra("numberOfRatings", numberOfRatings);
                detailIntent.putExtra("numberOfReviews", numberOfReviews);
                detailIntent.putExtra("numberOfPages", numberOfPages);
                detailIntent.putExtra("publishingDate", publishingDate);

                Log.d("Activity2", "Passing to Activity3 - Title: " + title);
                Log.d("Activity2", "Passing to Activity3 - CoverDrawable: " + coverDrawable);
                Log.d("Activity2", "Passing to Activity3 - FullDescription: " + fullDescription);
                Log.d("Activity2", "Passing to Activity3 - Rating: " + rating);
                Log.d("Activity2", "Passing to Activity3 - NumberOfRatings: " + numberOfRatings);
                Log.d("Activity2", "Passing to Activity3 - NumberOfReviews: " + numberOfReviews);
                Log.d("Activity2", "Passing to Activity3 - NumberOfPages: " + numberOfPages);
                Log.d("Activity2", "Passing to Activity3 - PublishingDate: " + publishingDate);

                startActivity(detailIntent);
            }
        });
    }
}
