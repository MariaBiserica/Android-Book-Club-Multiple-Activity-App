package com.example.bookclubmultipleactivityapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView booksRecyclerView;
    private BooksAdapter booksAdapter;

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
    }
}
