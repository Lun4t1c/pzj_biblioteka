package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.*;

import java.util.ArrayList;
import java.util.List;

public class DataAcces {
    public static ObservableList<BookModel> getDummyBooks(){
        ObservableList<BookModel> books = FXCollections.observableArrayList();


        AuthorModel tempAuthor = new AuthorModel();
        tempAuthor.setFirstName("Mateusz");
        tempAuthor.setLastName("Kupiec");
        tempAuthor.setId(3);

        GenreModel tempGenre = new GenreModel();
        tempGenre.setId(4);
        tempGenre.setName("Mitomania");

        BookModel tempBook = new BookModel();
        tempBook.setAuthor(tempAuthor);
        tempBook.setId(2);
        tempBook.setTitle("Jakby byla melina to bysmy nie mogli jedli kotletu");
        tempBook.setPublicationYear(2015);

        books.add(tempBook);
        //books.add(tempBook);

        return  books;
    }

    //region Get Data
    public static ObservableList<BookModel> getAllBooks(){
        ObservableList<BookModel> books = FXCollections.observableArrayList();

        return  books;
    }
    //endregion


    //region Insert Data
    public static void insertBook(BookModel book){
        throw new UnsupportedOperationException();
    }

    public static void insertAuthor(AuthorModel author){
        throw new UnsupportedOperationException();
    }
    //endregion
}
