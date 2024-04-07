package com.example.bookclubmultipleactivityapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView booksRecyclerView;
    private BooksAdapter booksAdapter;
    private TextView welcomeMessageTextView;
    private ImageView expandMoreImageView;
    private boolean isWelcomeMessageExpanded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the RecyclerView
        booksRecyclerView = findViewById(R.id.books_recycler_view);
        booksRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Parse the book data from XML
        List<Book> bookList = XmlDataParser.parseBooksXml(this);

        // Initialize the adapter with the list of books and set it to the RecyclerView
        booksAdapter = new BooksAdapter(this, bookList);
        booksRecyclerView.setAdapter(booksAdapter);

        // Initialize title, welcome message and expand button
        TextView titleTextView = findViewById(R.id.titleTextView);
        welcomeMessageTextView = findViewById(R.id.welcomeMessageTextView);
        expandMoreImageView = findViewById(R.id.expandMoreImageView);

        // Expand more button click listener
        expandMoreImageView.setOnClickListener(view -> toggleWelcomeMessage());

        // Floating button for Activity 5
        FloatingActionButton manageBooksFab = findViewById(R.id.manage_books_fab);
        manageBooksFab.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ManageBooksActivity5.class);
            startActivity(intent);
        });

    }

    private void toggleWelcomeMessage() {
        // Toggle the expanded state
        isWelcomeMessageExpanded = !isWelcomeMessageExpanded;

        // Set the visibility of the welcome message accordingly
        welcomeMessageTextView.setVisibility(isWelcomeMessageExpanded ? View.VISIBLE : View.GONE);

        // Change the icon direction accordingly
        expandMoreImageView.setImageResource(isWelcomeMessageExpanded ? R.drawable.ic_expand_less : R.drawable.ic_expand_more);
    }
}
