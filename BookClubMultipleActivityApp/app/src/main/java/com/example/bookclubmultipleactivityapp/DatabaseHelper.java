package com.example.bookclubmultipleactivityapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "booksDatabase";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_BOOKS = "books";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_AUTHOR = "author";
    private static final String COLUMN_GENRE = "genre";
    private static final String COLUMN_PAGES = "numberOfPages";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_BOOKS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITLE + " TEXT, " +
                    COLUMN_AUTHOR + " TEXT, " +
                    COLUMN_GENRE + " TEXT, " +
                    COLUMN_PAGES + " INTEGER" +
                    ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKS);
        onCreate(db);
    }

    public long insertBook(BookActivity5 book) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, book.getTitle());
        values.put(COLUMN_AUTHOR, book.getAuthor());
        values.put(COLUMN_GENRE, book.getGenre());
        values.put(COLUMN_PAGES, book.getNumberOfPages());

        long id = db.insert(TABLE_BOOKS, null, values);
        db.close();
        return id;
    }

    public int updateBook(BookActivity5 book) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, book.getTitle());
        values.put(COLUMN_AUTHOR, book.getAuthor());
        values.put(COLUMN_GENRE, book.getGenre());
        values.put(COLUMN_PAGES, book.getNumberOfPages());

        int rowsAffected = db.update(TABLE_BOOKS, values, COLUMN_ID + " = ?", new String[]{String.valueOf(book.getId())});
        db.close();
        return rowsAffected;
    }

    public void deleteBook(long bookId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BOOKS, COLUMN_ID + " = ?", new String[]{String.valueOf(bookId)});
        db.close();
    }

    @SuppressLint("Range")
    public BookActivity5 getBook(long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_BOOKS,
                new String[]{COLUMN_ID, COLUMN_TITLE, COLUMN_AUTHOR, COLUMN_GENRE, COLUMN_PAGES},
                COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        @SuppressLint("Range") BookActivity5 book = new BookActivity5(
                cursor.getString(cursor.getColumnIndex(COLUMN_TITLE)),
                cursor.getString(cursor.getColumnIndex(COLUMN_AUTHOR)),
                cursor.getString(cursor.getColumnIndex(COLUMN_GENRE)),
                cursor.getInt(cursor.getColumnIndex(COLUMN_PAGES))
        );
        book.setId(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));

        cursor.close();
        return book;
    }

    @SuppressLint("Range")
    public List<BookActivity5> getAllBooks() {
        List<BookActivity5> bookList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_BOOKS, new String[]{COLUMN_ID, COLUMN_TITLE, COLUMN_AUTHOR, COLUMN_GENRE, COLUMN_PAGES}, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") BookActivity5 book = new BookActivity5(
                        cursor.getString(cursor.getColumnIndex(COLUMN_TITLE)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_AUTHOR)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_GENRE)),
                        cursor.getInt(cursor.getColumnIndex(COLUMN_PAGES))
                );
                book.setId(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
                bookList.add(book);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return bookList;
    }
}
