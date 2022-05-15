package controllers;

import dao.DataAcces;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import models.BookModel;

import java.net.URL;
import java.util.ResourceBundle;

public class BorrowBookController implements Initializable {
    //region Attributes

    //endregion

    //region FXML Controls
    @FXML
    private ComboBox<BookModel> booksComboBox;
    //endregion

    //region Constructor + Initalize
    public BorrowBookController(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Load books from database
        booksComboBox.setItems(DataAcces.getAllBooks());

        // Configure custom booksComboBox cell factory
        booksComboBox.setCellFactory(param -> new ListCell<BookModel>() {
            @Override
            protected void updateItem(BookModel item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                } else {
                    String text = "";
                    text += item.getTitle() + " ";
                    text += "(" + item.getPublication_date() + ")";

                    setText(text);
                }
            }
        });
    }
    //endregion

    //region Methods
    /**
     * Confirm borrowing book and add borrow info to database
     */
    private void confirm(){

    }
    //endregion

    //region Button clicks
    @FXML
    protected void onConfirmButton(){
        confirm();
    }
    //endregion
}
