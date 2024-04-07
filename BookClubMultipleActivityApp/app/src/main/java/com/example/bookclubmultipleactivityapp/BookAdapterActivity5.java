package com.example.bookclubmultipleactivityapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookAdapterActivity5 extends RecyclerView.Adapter<BookAdapterActivity5.BookViewHolder> {

    public interface OnBookListener {
        void onEditClick(int position);
        void onDeleteClick(int position);
    }

    private final Context context;
    private List<BookActivity5> bookList;
    private OnBookListener onBookListener;


    public BookAdapterActivity5(Context context, List<BookActivity5> bookList, OnBookListener onBookListener) {
        this.context = context;
        this.bookList = bookList;
        this.onBookListener = onBookListener;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_book_activity5, parent, false);
        return new BookViewHolder(view, onBookListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        BookActivity5 book = bookList.get(position);
        holder.titleTextView.setText(book.getTitle());
        holder.authorTextView.setText(book.getAuthor());
        holder.genreTextView.setText(book.getGenre());
        holder.pagesTextView.setText(String.valueOf(book.getNumberOfPages()));
        // Implement onClickListener for edit and delete actions here if needed
    }

    @Override
    public int getItemCount() {
        return bookList != null ? bookList.size() : 0;
    }

    // Method to update the list of books and notify the adapter
    public void updateBooks(List<BookActivity5> newBooks) {
        this.bookList.clear();
        this.bookList.addAll(newBooks);
        notifyDataSetChanged();
    }

    public BookActivity5 getBookAtPosition(int position) {
        return bookList.get(position);
    }

    static class BookViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, authorTextView, genreTextView, pagesTextView;
        ImageView editButton, deleteButton;

        public BookViewHolder(@NonNull View itemView, final OnBookListener onBookListener) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            authorTextView = itemView.findViewById(R.id.authorTextView);
            genreTextView = itemView.findViewById(R.id.genreTextView);
            pagesTextView = itemView.findViewById(R.id.pagesTextView);
            editButton = itemView.findViewById(R.id.editButton);
            deleteButton = itemView.findViewById(R.id.deleteButton);

            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onBookListener != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION) {
                            onBookListener.onEditClick(position);
                        }
                    }
                }
            });

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onBookListener != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION) {
                            onBookListener.onDeleteClick(position);
                        }
                    }
                }
            });
        }
    }

}
