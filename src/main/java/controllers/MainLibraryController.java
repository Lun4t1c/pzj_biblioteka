package controllers;

import dao.DataAccess;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.BookModel;

public class MainLibraryController {
    //region FXML Controls
    @FXML
    private TextField SearchTextField;
    //endregion


    //region Attributes
    ObservableList<BookModel> books = DataAccess.getAllBooks();
    //endregion]


    //region Methods
    private void filterBooks(){

    }
    //endregion


    //region Button clicks

    //endregion
}
