package com.example.bookclubmultipleactivityapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class EditBookActivity extends AppCompatActivity {

    private EditText editTextTitle, editTextAuthor, editTextGenre, editTextNumberOfPages;
    private Button buttonUpdate;
    private DatabaseHelper databaseHelper;
    private long bookId; // ID of the book to edit

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_book);

        editTextTitle = findViewById(R.id.titleEditText);
        editTextAuthor = findViewById(R.id.authorEditText);
        editTextGenre = findViewById(R.id.genreEditText);
        editTextNumberOfPages = findViewById(R.id.pagesEditText);
        buttonUpdate = findViewById(R.id.buttonUpdate);

        databaseHelper = new DatabaseHelper(this);

        // Get the book ID from the Intent
        bookId = getIntent().getLongExtra("bookId", -1);
        if(bookId != -1) {
            loadBookDetails(bookId);
        }

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateBook();
            }
        });
    }

    private void loadBookDetails(long id) {
        // Fetch the book details from the database using the ID
        BookActivity5 book = databaseHelper.getBook(id);
        if(book != null) {
            editTextTitle.setText(book.getTitle());
            editTextAuthor.setText(book.getAuthor());
            editTextGenre.setText(book.getGenre());
            editTextNumberOfPages.setText(String.valueOf(book.getNumberOfPages()));
        }
    }

    private void updateBook() {
        // Collect the updated fields
        String title = editTextTitle.getText().toString();
        String author = editTextAuthor.getText().toString();
        String genre = editTextGenre.getText().toString();
        int numberOfPages = Integer.parseInt(editTextNumberOfPages.getText().toString());

        // Create a BookActivity5 object with the updated fields
        BookActivity5 updatedBook = new BookActivity5(title, author, genre, numberOfPages);
        updatedBook.setId(bookId); // Set the book ID

        // Update the book in the database
        databaseHelper.updateBook(updatedBook);

        // Optionally, return to the previous activity or display a success message
        finish();
    }
}
