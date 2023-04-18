package com.winseslas.refactoring.myFragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.winseslas.refactoring.R;
import com.winseslas.refactoring.adapter.BookAdapter;
import com.winseslas.refactoring.adapter.LiteraryGenreAdapter;
import com.winseslas.refactoring.databinding.FragmentBooksBinding;
import com.winseslas.refactoring.models.Book;
import com.winseslas.refactoring.models.LiteraryGenre;

import java.util.ArrayList;

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
        ArrayList<Book> booksList = new ArrayList<Book> ( );
        ArrayList<LiteraryGenre> literaryGenres = new ArrayList<LiteraryGenre>();

        // Register our book in our list
        booksList.add(new Book("Il était une fois Nelson Mandela","Il était une fois Nelson Mandela\" est une biographie racontant l'histoire inspirante de l'ancien président sud-africain, Nelson Mandela. Écrit par Lenny Lanchester, ce livre retrace la vie de Mandela depuis sa jeunesse dans une famille royale jusqu'à sa lutte pour la libération de son pays du régime de l'apartheid, en passant par sa détention de 27 ans dans la prison de Robben Island. Cette biographie explore également les relations personnelles de Mandela, ainsi que son mariage avec Winnie Madikizela-Mandela et son rôle en tant que père de famille. \"Il était une fois Nelson Mandela\" est une histoire inspirante de persévérance, de courage et de leadership, offrant un regard fascinant sur l'un des plus grands leaders du XXe siècle","https://cdn.shopify.com/s/files/1/1520/8066/products/9782376060932-475x500-2.jpg?v=1580670529",0,false) );
        booksList.add(new Book("Le Livre Vert","I\"Le Livre Vert\" de Mouammar El-Kadhafi est un livre publié en 1975 qui présente la philosophie politique de l'auteur et sa vision pour la société. L'ouvrage est divisé en trois parties, chacune abordant un thème différent : la démocratie directe, l'économie socialiste et la solution de la question des femmes. El-Kadhafi y expose sa théorie du pouvoir populaire, prônant une forme de démocratie directe qui s'oppose à la représentation politique. Il y développe également sa vision d'une économie socialiste où les moyens de production appartiennent au peuple, ainsi que sa conception de l'égalité des sexes, dans laquelle les femmes doivent être considérées comme des égales des hommes dans tous les domaines. Bien que controversé, \"Le Livre Vert\" a influencé de nombreux mouvements politiques dans le monde arabe et ailleurs.","https://m.media-amazon.com/images/W/IMAGERENDERING_521856-T1/images/I/7127R9578hL._AC_UF1000,1000_QL80_.jpg",0,false) );
        booksList.add(new Book("L'homme qui m'offrait le paradis ","\" L'homme qui m'offrait le paradis \" est un roman de l'écrivaine camerounaise Calixthe Beyala. L'histoire raconte l'histoire d'une jeune femme africaine qui rencontre un homme mystérieux qui lui offre un avenir meilleur. Elle est transportée dans un monde nouveau et enchanteur, mais elle doit bientôt faire face aux conséquences de son choix. Le roman aborde des thèmes tels que l'amour, l'identité, la migration, l'immigration, la mondialisation et la recherche de soi. Il offre une perspective unique sur l'expérience de l'Afrique contemporaine et la complexité des relations humaines.","https://www.albin-michel.fr/sites/default/files/styles/extra_large/public/couvertures/9782226177155-j.jpg?itok=hFxcFUKL",0,false) );
        booksList.add(new Book("Maman a un amant","\"Maman a un amant\" est un roman de l'écrivaine camerounaise Calixthe Beyala. L'histoire suit une jeune femme appelée Prudence, qui vit dans un petit village africain avec sa mère, une veuve. La vie de Prudence est bouleversée lorsqu'elle découvre que sa mère a un amant, un homme blanc qui vit dans la ville voisine.\n" + "Le roman explore les thèmes de la famille, de la sexualité, de la race et de la religion, en abordant des sujets tels que la polygamie, la corruption, la prostitution et la pauvreté. Il décrit également la lutte de Prudence pour trouver sa place dans un monde qui est souvent hostile aux femmes.\n" + "\"Maman a un amant\" est un livre poignant qui offre une perspective unique sur la vie des femmes en Afrique et qui examine les défis auxquels elles sont confrontées dans leur quête de liberté et d'indépendance.","https://i0.wp.com/soldiersmedia237.com/wp-content/uploads/2021/10/CB801B1D-0CF7-422E-B861-E1B60D9825C5.jpeg?fit=294%2C475&ssl=1",0,false));
        booksList.add(new Book("Le Jeune Entrepreneur Africain","Le Jeune Entrepreneur Africain\" de Claudel Noubissi est un livre qui s'adresse aux jeunes entrepreneurs africains et à toutes les personnes intéressées par la création d'entreprise sur le continent. Il fournit des conseils pratiques pour réussir dans le monde des affaires en Afrique, en prenant en compte les spécificités économiques et culturelles du continent. À travers des exemples concrets, des études de cas et des témoignages, l'auteur aborde des thèmes tels que la gestion financière, la stratégie commerciale, le marketing, les ressources humaines et la gestion de la croissance. Ce livre est une source d'inspiration pour les jeunes entrepreneurs africains qui souhaitent créer et développer leur entreprise avec succès.","https://m.media-amazon.com/images/W/IMAGERENDERING_521856-T1/images/I/5134g6fRZJL.jpg",0, false) );

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

        // books recycler view
        RecyclerView horizontalRecyclerView = root.findViewById( R.id.horizontal_recycler_view);
        if (horizontalRecyclerView != null) {
            horizontalRecyclerView.setAdapter(new BookAdapter (R.layout.item_horizontal_book, booksList, true));
        }

        // genre literal view
        RecyclerView recentBooksRecyclerView = root.findViewById(R.id.horizontal_second_recycler_view);
        if (horizontalRecyclerView != null) {
            recentBooksRecyclerView.setAdapter(new LiteraryGenreAdapter(this.context, literaryGenres));
        }

        // recent books
        RecyclerView genreRecyclerView = root.findViewById(R.id.horizontal_last_recycler_view);
        if (genreRecyclerView != null) {
            genreRecyclerView.setAdapter(new BookAdapter (R.layout.item_horizontal_recent_book, booksList, false ));
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
