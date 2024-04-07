package com.example.bookclubmultipleactivityapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ManageBooksActivity5 extends AppCompatActivity {

    private RecyclerView booksRecyclerView;
    private BookAdapterActivity5 bookAdapter;
    private DatabaseHelper databaseHelper;
    private FloatingActionButton addBookButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_books);

        databaseHelper = new DatabaseHelper(this);
        booksRecyclerView = findViewById(R.id.manage_books_recycler_view);
        booksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        addBookButton = findViewById(R.id.addBookButton);

        addBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open AddBookActivity to add a new book
                Intent intent = new Intent(ManageBooksActivity5.this, AddBookActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadBooksFromDatabase();
    }

    private void loadBooksFromDatabase() {
        List<BookActivity5> bookList = databaseHelper.getAllBooks();
        if(bookAdapter == null) {
            //bookAdapter = new BookAdapterActivity5(this, bookList);
            bookAdapter = new BookAdapterActivity5(this, bookList, new BookAdapterActivity5.OnBookListener() {
                @Override
                public void onEditClick(int position) {
                    BookActivity5 selectedBook = bookAdapter.getBookAtPosition(position);
                    Intent intent = new Intent(ManageBooksActivity5.this, EditBookActivity.class);
                    intent.putExtra("bookId", selectedBook.getId());
                    startActivity(intent);
                }

                @Override
                public void onDeleteClick(int position) {
                    BookActivity5 selectedBook = bookAdapter.getBookAtPosition(position);
                    databaseHelper.deleteBook(selectedBook.getId());
                    loadBooksFromDatabase(); // Refresh the list
                }
            });
            booksRecyclerView.setAdapter(bookAdapter);
        } else {
            bookAdapter.updateBooks(bookList);
        }
    }
}
