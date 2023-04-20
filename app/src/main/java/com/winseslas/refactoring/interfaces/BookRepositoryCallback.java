package com.winseslas.refactoring.interfaces;

import com.winseslas.refactoring.models.Book;
import java.util.ArrayList;


public interface BookRepositoryCallback {
    void onBooksLoaded(ArrayList<Book> books);
    void onError(String errorMessage);
}
