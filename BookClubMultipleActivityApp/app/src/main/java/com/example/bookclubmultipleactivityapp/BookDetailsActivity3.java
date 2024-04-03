package com.example.bookclubmultipleactivityapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class BookDetailsActivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details_extended);

        Intent intent = getIntent();

        // Use the retrieved data
        ImageView coverImageView = findViewById(R.id.extended_bookCoverImageView);
        RatingBar ratingBar = findViewById(R.id.bookRatingBar);
        TextView ratingValueView = findViewById(R.id.bookRatingValue);
        TextView numberOfRatingsView = findViewById(R.id.number_of_ratings);
        TextView numberOfReviewsView = findViewById(R.id.number_of_reviews);
        TextView fullDescriptionView = findViewById(R.id.full_book_description);
        TextView numberOfPagesView = findViewById(R.id.book_pages);
        TextView publishingDateView = findViewById(R.id.publishing_date);

        Log.d("Activity3", "Received from Activity2 - CoverDrawable: " + intent.getIntExtra("coverDrawable", 0));
        Log.d("Activity3", "Received from Activity2 - FullDescription: " + intent.getStringExtra("fullDescription"));
        Log.d("Activity3", "Received from Activity2 - Rating: " + intent.getFloatExtra("rating", 0f));
        Log.d("Activity3", "Received from Activity2 - NumberOfRatings: " + intent.getIntExtra("numberOfRatings", 0));
        Log.d("Activity3", "Received from Activity2 - NumberOfReviews: " + intent.getIntExtra("numberOfReviews", 0));
        Log.d("Activity3", "Received from Activity2 - NumberOfPages: " + intent.getIntExtra("numberOfPages", 0));
        Log.d("Activity3", "Received from Activity2 - PublishingDate: " + intent.getStringExtra("publishingDate"));

        coverImageView.setImageResource(intent.getIntExtra("coverDrawable", 0));
        ratingBar.setRating(intent.getFloatExtra("rating", 0));
        // Update TextView to display rating value in bold
        ratingValueView.setText(String.format(Locale.getDefault(), "%.1f", intent.getFloatExtra("rating", 0f)));

        // Format and set text for number of ratings, including the word "ratings"
        int numberOfRatings = intent.getIntExtra("numberOfRatings", 0);
        numberOfRatingsView.setText(String.format(Locale.getDefault(), "%,d ratings", numberOfRatings));

        // Format and set text for number of reviews, including the word "reviews"
        int numberOfReviews = intent.getIntExtra("numberOfReviews", 0);
        numberOfReviewsView.setText(String.format(Locale.getDefault(), "%,d reviews", numberOfReviews));

        fullDescriptionView.setText(intent.getStringExtra("fullDescription"));
        numberOfPagesView.setText(getString(R.string.number_of_pages, intent.getIntExtra("numberOfPages", 0)));
        publishingDateView.setText(getString(R.string.publishing_date, intent.getStringExtra("publishingDate")));

        // Back button to return to the main list
        findViewById(R.id.showLessButton).setOnClickListener(view -> finish());
    }
}
