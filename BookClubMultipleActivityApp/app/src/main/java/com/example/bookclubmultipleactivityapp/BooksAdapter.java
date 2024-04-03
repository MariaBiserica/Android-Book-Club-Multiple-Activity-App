package com.example.bookclubmultipleactivityapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookViewHolder> {
    private List<Book> booksList;
    private Context context;

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        public ImageView bookIcon;
        public TextView bookTitle, bookSubtitle;

        public BookViewHolder(View itemView) {
            super(itemView);
            bookIcon = itemView.findViewById(R.id.book_icon);
            bookTitle = itemView.findViewById(R.id.book_title);
            bookSubtitle = itemView.findViewById(R.id.book_subtitle);
        }

        public void bind(Book book) {
            bookIcon.setImageResource(book.getIconDrawable());
            bookTitle.setText(book.getTitle());
            bookSubtitle.setText(book.getAuthor() + " - " + book.getGenre());
        }
    }

    public BooksAdapter(Context context, List<Book> booksList) {
        this.booksList = booksList;
        this.context = context;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = booksList.get(position);
        holder.bind(book);

        // Set click listener for each book item
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, BookDetailsActivity2.class);
            intent.putExtra("title", book.getTitle());
            intent.putExtra("author", book.getAuthor());
            intent.putExtra("genre", book.getGenre());
            intent.putExtra("iconDrawable", book.getIconDrawable());
            intent.putExtra("coverDrawable", book.getCoverDrawable());
            intent.putExtra("briefDescription", book.getBriefDescription());
            intent.putExtra("fullDescription", book.getFullDescription());
            intent.putExtra("rating", book.getRating());
            intent.putExtra("numberOfRatings", book.getNumberOfRatings());
            intent.putExtra("numberOfReviews", book.getNumberOfReviews());
            intent.putExtra("numberOfPages", book.getNumberOfPages());
            intent.putExtra("publishingDate", book.getPublishingDate());

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return booksList.size();
    }
}
