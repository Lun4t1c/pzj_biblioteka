package controllers;

// TODO searching modes (whole words, case sensitive etc...)

import com.pzj.SortMode;
import dao.DataAccess;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
    @FXML
    private TextField titletf;
    @FXML
    private Label authorValuelbl;
    @FXML
    private Label publisherValuelbl;
    @FXML
    private Label categoryValuelbl;
    @FXML
    private Label publicationDateValuelbl;
    @FXML
    private Label pagesValuelbl;
    //endregion


    //region Attributes
    private SortMode sortMode = SortMode.TITLE_ASC;
    private ObservableList<BookModel> books = DataAccess.getAllBooks();
    private ObservableList<BookModel> filteredBooks = books;
    private BookModel selectedBook = null;
    //endregion

    //region Constructor + Initialize
    public MainLibraryController(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> filterBooks());
        booksListView.setItems(filteredBooks);

        // Set custom list item display
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

        // Add listener to book selection change
        booksListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<BookModel>() {
            @Override
            public void changed(ObservableValue<? extends BookModel> observableValue, BookModel bookModel, BookModel t1) {
                selectNewBook(t1);
            }
        });

        sortBooks();
    }
    //endregion

    //region Methods
    private void filterBooks(){
        String searchText = searchTextField.getText();

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
            case TITLE_ASC  -> sortBooksByTitleAsc();
            case TITLE_DESC -> sortBooksByTitleDesc();
            case PUBLICATION_DATE_ASC   -> sortBooksByPublicationDateAsc();
            case PUBLICATION_DATE_DESC  -> sortBooksByPublicationDateDesc();
        }
    }

    private void selectNewBook(BookModel book){
        selectedBook = book;

        titletf.setText(book.getTitle());
        authorValuelbl.setText( String.valueOf(book.getAuthor_id()) );
        publisherValuelbl.setText( String.valueOf(book.getPublisher_id()) );
        categoryValuelbl.setText( String.valueOf(book.getCategory_id()) );
        publicationDateValuelbl.setText(book.getPublication_date().toString());
        pagesValuelbl.setText( String.valueOf(book.getPages()) );
    }

    private void sortBooksByTitleAsc(){
        Collections.sort(filteredBooks, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
    }

    private void sortBooksByTitleDesc(){
        Collections.sort(filteredBooks, (b1, b2) -> b2.getTitle().compareTo(b1.getTitle()));
    }

    private void sortBooksByPublicationDateAsc(){
        throw new UnsupportedOperationException("YET TO BE IMLPEMENTED");
    }

    private void sortBooksByPublicationDateDesc(){
        throw new UnsupportedOperationException("YET TO BE IMLPEMENTED");
    }
    //endregion


    //region Button clicks

    //endregion
}
