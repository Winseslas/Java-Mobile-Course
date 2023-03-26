package com.winseslas.refactoring.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.winseslas.refactoring.R;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView bookImage;

        public ViewHolder(View itemView) {
            super(itemView);
            bookImage = itemView.findViewById(R.id.image_view_item);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_horizontal_book, parent, false);
        return new ViewHolder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // set data for the ViewHolder
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
