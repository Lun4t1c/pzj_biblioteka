package dao;

import models.*;

import java.util.ArrayList;
import java.util.List;

public class dataAcces {
    //region Get Data
    public static List<bookModel> GetAllBooks(){
        List<bookModel> books = new ArrayList<>();

        return  books;
    }
    //endregion


    //region Insert Data
    public static void InsertBook(bookModel book){
        throw new UnsupportedOperationException();
    }

    public static void InsertAuthor(authorModel author){
        throw new UnsupportedOperationException();
    }
    //endregion
}
