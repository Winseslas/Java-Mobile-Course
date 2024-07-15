package com.winseslas.refactoring.repository;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.winseslas.refactoring.interfaces.BookRepositoryCallback;
import com.winseslas.refactoring.models.Book;

import java.util.ArrayList;

public class BookRepository {

    private static BookRepository instance;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private ArrayList<Book> booksList;

    private BookRepository() {
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("books");
        booksList = new ArrayList<>();
    }

    public static synchronized BookRepository getInstance() {
        if (instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }

    public void findAll(final BookRepositoryCallback callback) {
        // Read from the database
        databaseReference.addValueEventListener(new ValueEventListener () {
            /**
             * This method will be called with a snapshot of the data at this location. It will also be called
             * each time that data changes.
             *
             * @param snapshot The current data at the location
             */
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                booksList.clear ();
                for(DataSnapshot ds : snapshot.getChildren()) {
                    Book book = ds.getValue(Book.class);
                    if (book != null){
                        booksList.add(book);
                    }
                }
                callback.onBooksLoaded(booksList);
            }

            /**
             * This method will be triggered in the event that this listener either failed at the server, or
             * is removed as a result of the security and Firebase Database rules. For more information on
             * securing your data, see: <a
             * href="https://firebase.google.com/docs/database/security/quickstart" target="_blank"> Security
             * Quickstart</a>
             *
             * @param error A description of the error that occurred
             */
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Recover the error code from the database
                int errorCode = error.getCode();
                String errorMessage = "";

                switch (errorCode) {
                    case DatabaseError.PERMISSION_DENIED:
                        errorMessage = "Access to the database has been denied";
                        break;
                    case DatabaseError.NETWORK_ERROR:
                        errorMessage = "Unable to connect to the database";
                        break;
                    case DatabaseError.OPERATION_FAILED:
                        errorMessage = "The operation failed";
                        break;
                    default:
                        errorMessage = "An error occurred while accessing the database";
                        break;
                }

                callback.onError(errorMessage);
            }
        });

    }

    public void updateByIsLiked(Book book){

    }

    public void findByIsLiked(final BookRepositoryCallback callback) {

    }

}
