package com.winseslas.refactoring.myFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.winseslas.refactoring.R;
import com.winseslas.refactoring.adapter.BookAdapter;
import com.winseslas.refactoring.databinding.FragmentBooksBinding;

public class BooksFragment extends Fragment {

    private FragmentBooksBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBooksBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // books recycler view
        RecyclerView horizontalRecyclerView = root.findViewById( R.id.horizontal_recycler_view);
        if (horizontalRecyclerView != null) {
            horizontalRecyclerView.setAdapter(new BookAdapter (R.layout.item_horizontal_book));
        }

        // genre literal view
        RecyclerView genreRecyclerView = root.findViewById(R.id.horizontal_second_recycler_view);
        if (genreRecyclerView != null) {
            genreRecyclerView.setAdapter(new BookAdapter (R.layout.item_vertical_literary_genre));
        }

        // recent books
        RecyclerView recentBooksRecyclerView = root.findViewById(R.id.horizontal_last_recycler_view);
        if (recentBooksRecyclerView != null) {
            recentBooksRecyclerView.setAdapter(new BookAdapter (R.layout.item_horizontal_recent_book));
        }
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
