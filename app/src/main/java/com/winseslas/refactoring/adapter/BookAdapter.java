package com.winseslas.refactoring.adapter;

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

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private final List<Book> booksList;
    private final int layoutId;
    private final boolean element;

    public BookAdapter(int layout, List<Book> booksList, boolean element ) {
        this.booksList = booksList;
        this.layoutId = layout;
        this.element = element;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(layoutId, parent, false);
        return new BookAdapter.BookViewHolder ( view, this.element );
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        int items = booksList.size();
        if (position < items) {
            Book currentBook = booksList.get(position);
            holder.bind(currentBook);
        }
    }

    @Override
    public int getItemCount() {
        return booksList != null ? booksList.size() : 0;
    }


    public static class BookViewHolder extends RecyclerView.ViewHolder {

        private final ImageView bookImage;
        private final TextView bookTitle;
        private ImageView bookIsLiked;
        private TextView bookNumberOfLikes;
        private final boolean element;

        public BookViewHolder(View itemView, boolean element) {
            super(itemView);
            this.element = element;

            bookImage = itemView.findViewById(R.id.image_view_item_books);
            bookTitle = itemView.findViewById(R.id.text_book_title);

            if(this.element){
                bookIsLiked = itemView.findViewById(R.id.image_start);
                bookNumberOfLikes = itemView.findViewById(R.id.text_liked);
            }
        }

        public void bind(Book currentBook) {
            // Load the book image using Glide
            if (currentBook.getImageUrl() != null){
                Glide.with(itemView.getContext())
                        .load(currentBook.getImageUrl())
                        .into(bookImage);
            }
            bookTitle.setText(currentBook.getName());

            if(this.element){
                bookNumberOfLikes.setText( String.format ( "%s k" , String.valueOf ( currentBook.getNumberOfLikes ( ) ) ) );
                // Set the liked icon according to the book's liked status
                if (currentBook.isLiked()) {
                    bookIsLiked.setImageResource(R.drawable.ic_baseline_star_rate_24);
                } else {
                    bookIsLiked.setImageResource(R.drawable.ic_baseline_star_outline_24);
                }
                bookIsLiked.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        currentBook.setLiked ( !currentBook.isLiked () );
                    }
                });


            }
        }
    }
}
