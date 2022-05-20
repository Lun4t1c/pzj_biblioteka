package controllers;

import dao.DataAccess;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import models.BookModel;
import models.CopyModel;
import models.EmployeeModel;
import models.ReaderModel;

import java.net.URL;
import java.util.ResourceBundle;

public class BorrowBookController implements Initializable {

    //region Attributes

    //endregion

    //region FXML Controls
    @FXML
    private ComboBox<BookModel> booksComboBox;
    @FXML
    private ComboBox<CopyModel> copiesComboBox;
    @FXML
    public ComboBox<ReaderModel> readerComboBox;
    @FXML
    public ComboBox<EmployeeModel> employeesComboBox;
    //endregion

    //region Constructor + Initalize
    public BorrowBookController(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Load books from database
        booksComboBox.setItems(DataAccess.getAllBooks());

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

        // Load copies from database
        copiesComboBox.setItems(DataAccess.getAllCopies());
        // Configure custom copiesComboBox cell factory
        copiesComboBox.setCellFactory(param -> new ListCell<CopyModel>() {
            @Override
            protected void updateItem(CopyModel item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                } else {
                    String text = "";
                    text += item.getAccession_nr();

                    setText(text);
                }
            }
        });

        // Load readers from database
        readerComboBox.setItems(DataAccess.getAllReaders());
        // Configure custom readersComboBox cell factory
        readerComboBox.setCellFactory(param -> new ListCell<ReaderModel>() {
            @Override
            protected void updateItem(ReaderModel item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                } else {
                    String text = "";
                    text += item.getSurname();

                    setText(text);
                }
            }
        });

        // Load employees from database
        employeesComboBox.setItems(DataAccess.getAllEmployees());
        // Configure custom employeesComboBox cell factory
        employeesComboBox.setCellFactory(param -> new ListCell<EmployeeModel>() {
            @Override
            protected void updateItem(EmployeeModel item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                } else {
                    String text = "";
                    text += item.getSurname();

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
