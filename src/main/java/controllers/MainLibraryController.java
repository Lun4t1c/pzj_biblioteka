package controllers;

import dao.DataAccess;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import models.BookModel;

import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

public class MainLibraryController implements Initializable {
    //region FXML Controls
    @FXML
    private TextField searchTextField;

    @FXML
    private ListView<BookModel> booksListView;
    //endregion


    //region Attributes
    ObservableList<BookModel> books = DataAccess.getAllBooks();
    ObservableList<BookModel> filteredBooks = books;
    final String sortMode = "title";
    //endregion

    //region Constructor + Initialize
    public MainLibraryController(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> filterBooks());

        booksListView.setItems(filteredBooks);

        booksListView.setCellFactory(param -> new ListCell<BookModel>() {
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
    private void filterBooks(){
        String searchText = searchTextField.getText();
        System.out.println("FILTERING " + searchText);

        ObservableList<BookModel> tempList = FXCollections.observableArrayList();

        for (BookModel bm : books){
            if (bm.getTitle().contains(searchText))
                tempList.add(bm);
        }

        filteredBooks = tempList;
        booksListView.setItems(filteredBooks);

        sortBooks();
    }

    private void sortBooks(){
        switch (sortMode){
            case "title"-> sortBooksByTitle();
        }
    }

    private void sortBooksByTitle(){
        Collections.sort(filteredBooks, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
    }
    //endregion


    //region Button clicks

    //endregion
}
