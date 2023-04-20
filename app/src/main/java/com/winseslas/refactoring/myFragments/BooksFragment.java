package com.winseslas.refactoring.myFragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.winseslas.refactoring.R;
import com.winseslas.refactoring.adapter.BookAdapter;
import com.winseslas.refactoring.adapter.LiteraryGenreAdapter;
import com.winseslas.refactoring.databinding.FragmentBooksBinding;
import com.winseslas.refactoring.interfaces.BookRepositoryCallback;
import com.winseslas.refactoring.models.Book;
import com.winseslas.refactoring.models.LiteraryGenre;
import com.winseslas.refactoring.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

public class BooksFragment extends Fragment {

    private FragmentBooksBinding binding;
    private Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBooksBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Creation of a list that will store the books
        BookRepository bookRepository = BookRepository.getInstance();
        bookRepository.findAll(new BookRepositoryCallback () {
            @Override
            public void onBooksLoaded(ArrayList<Book> books) {

                // books recycler view
                RecyclerView horizontalRecyclerView = root.findViewById( R.id.horizontal_recycler_view);
                if (horizontalRecyclerView != null) {
                    horizontalRecyclerView.setAdapter(new BookAdapter (R.layout.item_horizontal_book, books , true));
                }

                // Recent books
                // Get the last three items
                int size = books.size();
                List<Book> lastThreeBooks = books.subList(size - 3, size);

                RecyclerView genreRecyclerView = root.findViewById(R.id.horizontal_last_recycler_view);
                if (genreRecyclerView != null) {
                    genreRecyclerView.setAdapter(new BookAdapter (R.layout.item_horizontal_recent_book, lastThreeBooks, false ));
                }
            }

            @Override
            public void onError(String errorMessage) {
                Toast.makeText(context, "An error has occurred: " + errorMessage, Toast.LENGTH_SHORT).show();
            }

        });

        ArrayList<LiteraryGenre> literaryGenres = new ArrayList<LiteraryGenre>();

        literaryGenres.add(new LiteraryGenre("Action and Adventure", "Fiction intended to provide a fast-paced, action-packed read"));
        literaryGenres.add(new LiteraryGenre("Art", "Fiction with a focus on art or artists"));
        literaryGenres.add(new LiteraryGenre("Alternate History", "Fiction where the author explores what might have happened if history had gone differently"));
        literaryGenres.add(new LiteraryGenre("Autobiography", "A non-fiction work in which the author writes about his or her own life"));
        literaryGenres.add(new LiteraryGenre("Anthology", "A collection of short stories or poems by different authors"));
        literaryGenres.add(new LiteraryGenre("Biography", "A non-fiction work in which the author writes about another person's life"));
        literaryGenres.add(new LiteraryGenre("Chick Lit", "Fiction targeted towards women, often featuring romance and humorous elements"));
        literaryGenres.add(new LiteraryGenre("Children's", "Fiction targeted towards children"));
        literaryGenres.add(new LiteraryGenre("Classics", "Fiction that has stood the test of time and is considered to be of high literary merit"));
        literaryGenres.add(new LiteraryGenre("Comic Book", "Fiction presented in the form of a comic book"));
        literaryGenres.add(new LiteraryGenre("Coming-of-Age", "Fiction that focuses on the protagonist's journey from adolescence to adulthood"));
        literaryGenres.add(new LiteraryGenre("Crime", "Fiction that focuses on crime and the criminal underworld"));
        literaryGenres.add(new LiteraryGenre("Drama", "Fiction that is intended to be performed on stage, often featuring serious or intense themes"));
        literaryGenres.add(new LiteraryGenre("Diary", "A non-fiction work in which the author writes about his or her own life, often presented in the form of a daily diary"));
        literaryGenres.add(new LiteraryGenre("Dictionary", "A reference work that contains definitions of words"));
        literaryGenres.add(new LiteraryGenre("Encyclopedia", "A reference work that contains information on a wide range of subjects"));
        literaryGenres.add(new LiteraryGenre("Fairytale", "Fiction that often features magical creatures, enchantments, and a hero or heroine who overcomes obstacles"));
        literaryGenres.add(new LiteraryGenre("Fantasy", "Fiction that features magic, supernatural elements, and often takes place in a fictional world"));
        literaryGenres.add(new LiteraryGenre("Guide", "A non-fiction work that provides advice or instruction on a particular topic"));
        literaryGenres.add(new LiteraryGenre("Health", "A non-fiction work that provides information on health and wellness"));
        literaryGenres.add(new LiteraryGenre("History", "A non-fiction work that focuses on past events and their significance"));
        literaryGenres.add(new LiteraryGenre("Horror", "Fiction that is intended to scare or horrify the reader"));
        literaryGenres.add(new LiteraryGenre("Humor", "Fiction that is intended to be humorous"));
        literaryGenres.add(new LiteraryGenre("Journal", "A non-fiction work in which the author writes about his or her own life, often presented in the form of a daily diary"));
        literaryGenres.add(new LiteraryGenre("Math", "A non-fiction work that provides information on mathematics"));
        literaryGenres.add(new LiteraryGenre("Mystery", "Fiction that focuses on solving a crime or uncovering a secret"));


        // genre literal view
        RecyclerView recentBooksRecyclerView = root.findViewById(R.id.horizontal_second_recycler_view);
        if (recentBooksRecyclerView != null) {
            recentBooksRecyclerView.setAdapter(new LiteraryGenreAdapter(this.context, literaryGenres));
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
