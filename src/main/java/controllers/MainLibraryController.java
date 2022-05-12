package controllers;

import com.pzj.View;
import com.pzj.ViewSwitcher;
import dao.DataAcces;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.BookModel;

public class MainLibraryController {
    //region FXML Controls
    @FXML
    private TextField SearchTextField;
    //endregion


    //region Attributes
    ObservableList<BookModel> books = DataAcces.getAllBooks();
    //endregion]


    //region Methods
    private void filterBooks(){

    }
    //endregion


    //region Button clicks

    //endregion
}
