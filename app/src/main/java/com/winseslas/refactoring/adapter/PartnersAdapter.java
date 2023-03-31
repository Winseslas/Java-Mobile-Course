package com.winseslas.refactoring.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.winseslas.refactoring.R;

public class PartnersAdapter extends RecyclerView.Adapter<PartnersAdapter.ViewHolder> {

    private final int layoutId;

    public PartnersAdapter(int layoutId) {
        this.layoutId = layoutId;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView partners;

        public ViewHolder(View itemView) {
            super(itemView);
            partners = itemView.findViewById(R.id.image_partners);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return new ViewHolder(view);
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
