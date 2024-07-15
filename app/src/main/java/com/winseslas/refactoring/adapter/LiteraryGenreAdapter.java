package com.winseslas.refactoring.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.winseslas.refactoring.R;
import com.winseslas.refactoring.models.LiteraryGenre;

import java.util.List;

public class LiteraryGenreAdapter extends RecyclerView.Adapter<LiteraryGenreAdapter.LiteraryGenreAdapterViewHolder> {

    private final List<LiteraryGenre> literaryGenres;
    private final Context context;

    public LiteraryGenreAdapter(Context context, List<LiteraryGenre> literaryGenres) {
        this.context = context;
        this.literaryGenres = literaryGenres;
    }

    /**
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     */
    @NonNull
    @Override
    public LiteraryGenreAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_horizontal_literary_genre , parent, false);

        return new LiteraryGenreAdapterViewHolder(view);
    }

    /**
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull final LiteraryGenreAdapterViewHolder holder , int position) {
        int items = literaryGenres.size();
        if (position < items) {
            int current = position;
            LiteraryGenre currentLiteraryGenre = literaryGenres.get(position);
            holder.bind(currentLiteraryGenre);

            // Set an OnClickListener to the item view
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Show an alert dialog with the literary genre name
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle(currentLiteraryGenre.getName())
                            .setMessage(currentLiteraryGenre.getDescription ())
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // User clicked OK button
                                }
                            });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            });
        }
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return literaryGenres.size ();
    }

    public static class LiteraryGenreAdapterViewHolder extends RecyclerView.ViewHolder{
        private final TextView literaryGenreName;
        public LiteraryGenreAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            literaryGenreName = itemView.findViewById(R.id.text_book_title);
        }

        public void bind(LiteraryGenre currentLiteraryGenre ){
            literaryGenreName.setText(currentLiteraryGenre.getName());
        }
    }
}
