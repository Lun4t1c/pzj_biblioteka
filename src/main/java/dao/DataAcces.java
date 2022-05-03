package dao;

import models.*;

import java.util.ArrayList;
import java.util.List;

public class DataAcces {
    //region Get Data
    public static List<BookModel> GetAllBooks(){
        List<BookModel> books = new ArrayList<>();

        return  books;
    }
    //endregion


    //region Insert Data
    public static void InsertBook(BookModel book){
        throw new UnsupportedOperationException();
    }

    public static void InsertAuthor(AuthorModel author){
        throw new UnsupportedOperationException();
    }
    //endregion
}
