package com.example.bookclubmultipleactivityapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddBookActivity extends AppCompatActivity {

    // Define EditTexts for book details input
    private EditText titleEditText, authorEditText, genreEditText, pagesEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book); // Make sure you have this layout defined

        titleEditText = findViewById(R.id.titleEditText);
        authorEditText = findViewById(R.id.authorEditText);
        genreEditText = findViewById(R.id.genreEditText);
        pagesEditText = findViewById(R.id.pagesEditText);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveBook();
            }
        });
    }

    private void saveBook() {
        // Logic to save book to database
        String title = titleEditText.getText().toString();
        String author = authorEditText.getText().toString();
        String genre = genreEditText.getText().toString();
        int pages = Integer.parseInt(pagesEditText.getText().toString());

        BookActivity5 book = new BookActivity5(title, author, genre, pages);
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        long id = databaseHelper.insertBook(book);

        // Handle result
        if(id > 0) {
            // Successfully saved
        } else {
            // Error handling
        }

        finish(); // Close activity after saving
    }
}
