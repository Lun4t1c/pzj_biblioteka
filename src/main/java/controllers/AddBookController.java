package controllers;

import dao.DataAccess;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import models.AuthorModel;
import models.BookModel;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class AddBookController implements Initializable {

    //region FXML controls
    @FXML
    private Label warningMessageLabel;

    @FXML
    private TextField isbnTextField;

    @FXML
    private TextField titleTextField;

    @FXML
    private TextField publication_dateTextField;

    @FXML
    private TextField pagesTextField;

    @FXML
    private Button confirmbtn;

    @FXML
    private Button clearbtn;

    // TODO Wykminic jakis sposob na wygodny wybor autora
    @FXML
    private ComboBox<AuthorModel> knownAuthorsComboBox;
    //endregion


    //region Attributes
    private ObservableList<AuthorModel> knownAuthors = DataAccess.getAllAuthor();
    //endregion


    //region Constructor + Initialize
    public AddBookController(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        knownAuthorsComboBox.setItems(DataAccess.getAllAuthor());

        knownAuthorsComboBox.setCellFactory(param -> new ListCell<AuthorModel>() {
            @Override
            protected void updateItem(AuthorModel item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getFullName());
                }
            }
        });
    }
    //endregion


    //region Methods
    private void confirm(){
        if (!isFormValid()) return;


        /*
        BookModel book = new BookModel(
                -1,
                isbnTextField.getText(),
                titleTextField.getText(),
                publication_dateTextField.getText(),
                Integer.parseInt(pagesTextField.getText()),
                knownAuthorsComboBox.getValue().getId()
        );


        DataAccess.insertBook(book);
        */

        resetForm();
    }

    private void resetForm(){
        isbnTextField.setText("");
        titleTextField.setText("");
        publication_dateTextField.setText("");
        pagesTextField.setText("");
    }

    private boolean isFormValid(){
        boolean result = true;
        //warningMessageLabel.setText("");

        //if (!isPublicationDateValid())
        //    warningMessageLabel.setText(warningMessageLabel.getText() + "Publication date invalid!\n");

        return result;
    }

    private boolean isPublicationDateValid(){
        return true;
    }
    //endregion


    //region Button clicks
    @FXML
    protected void onConfirmButton(){
        confirm();
    }
    //endregion
}
