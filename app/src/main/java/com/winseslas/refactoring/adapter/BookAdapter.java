package com.winseslas.refactoring.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.winseslas.refactoring.R;
import com.winseslas.refactoring.models.Book;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private final int layoutResourceId;
    private final List<Book> booksList;

    public BookAdapter(int layoutResourceId, List<Book> booksList) {
        this.layoutResourceId = layoutResourceId;
        this.booksList = booksList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView bookImage;
        private final TextView bookTitle;
        private final ImageView bookIsLiked;
        private final TextView bookNumberOfLikes;

        public ViewHolder(View itemView) {
            super(itemView);
            bookImage = itemView.findViewById(R.id.image_view_item_books);
            bookTitle = itemView.findViewById(R.id.text_book_title);
            bookIsLiked = itemView.findViewById(R.id.image_start);
            bookNumberOfLikes = itemView.findViewById(R.id.text_liked);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutResourceId, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (booksList != null && position < booksList.size()) {
            Book currentBook = booksList.get(position);

            Log.e ( "Book ", String.valueOf ( currentBook.getImageUrl () ) );

            // Load the book image using Glide
            if (currentBook.getImageUrl() != null){
                Glide.with(holder.itemView.getContext())
                        .load(currentBook.getImageUrl())
                        .into(holder.bookImage);
            }

            holder.bookTitle.setText(currentBook.getName());
            holder.bookNumberOfLikes.setText(String.valueOf(currentBook.getNumberOfLikes()));

            // Set the liked icon according to the book's liked status
            if (currentBook.isLiked()) {
                holder.bookIsLiked.setImageResource(R.drawable.ic_baseline_star_rate_24);
            } else {
                holder.bookIsLiked.setImageResource(R.drawable.ic_baseline_star_outline_24);
            }
        }
    }

    @Override
    public int getItemCount() {
        return booksList != null ? booksList.size() : 0;
    }
}
