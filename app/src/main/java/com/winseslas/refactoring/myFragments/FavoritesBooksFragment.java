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
import com.winseslas.refactoring.databinding.FragmentFavoriteBinding;
import com.winseslas.refactoring.models.Book;

import java.util.ArrayList;

public class FavoritesBooksFragment extends Fragment {

    private FragmentFavoriteBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        binding = FragmentFavoriteBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Creation of a list that will store the books
        ArrayList<Book> books = new ArrayList<>();
        books.add ( new Book(1, "To Kill a Mockingbird", "The story takes place during three years of the Great Depression in the fictional Maycomb, Alabama.", "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQ2qkJLjkVrYGC7JvdfFVZQU-LIVBDggNsIHxmb8SOjLV3HsVnu", 120, false) );
        books.add ( new Book(2, "The Catcher in the Rye", "The novel's protagonist Holden Caulfield has become an icon for teenage rebellion.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUlmoyLENLiItn6lyvyKHJFSz7ByiSkh8yYyjXfU5efzbnOaUB", 80, true) );

        RecyclerView favoriteRecyclerView = root.findViewById( R.id.horizontal_recycler_view_favorites);
        if (favoriteRecyclerView != null) {
            favoriteRecyclerView.setAdapter(new BookAdapter (R.layout.iten_horizontal_favorite_book, books, 2 ));
        }
        return root;
    }

    public void onDestroyView(){
        super.onDestroyView();
        binding = null;
    }
}
