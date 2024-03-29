package com.example.bookclubmultipleactivityapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookclubmultipleactivityapp.Book;
import com.example.bookclubmultipleactivityapp.BooksAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView booksRecyclerView;
    private BooksAdapter booksAdapter;
    private List<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookList = new ArrayList<>();
        // Sample data
        bookList.add(new Book("Book 1", "Author A", "Genre X"));
        bookList.add(new Book("Book 2", "Author B", "Genre Y"));
        // Add more books...

        booksRecyclerView = findViewById(R.id.books_recycler_view);
        booksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        booksAdapter = new BooksAdapter(this, bookList);
        booksRecyclerView.setAdapter(booksAdapter);
    }
}
