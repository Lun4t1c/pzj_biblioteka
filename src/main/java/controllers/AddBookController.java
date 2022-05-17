package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import models.AuthorModel;

import java.net.URL;
import java.util.ResourceBundle;

public class AddBookController implements Initializable {
    //region Attributes

    //endregion

    //region FXML controls
    @FXML
    private TextField isbnTextField;

    @FXML
    private TextField titleTextField;

    // TODO Moze lepszy bylby zwykly TextField
    @FXML
    private Spinner<Integer> publication_dateSpinner;

    // TODO Moze lepszy bylby zwykly TextField
    @FXML
    private Spinner<Integer> pagesSpinner;

    // TODO Wykminic jakis sposob na wygodny wybor autora
    //endregion

    //region Constructor + Initialize
    public AddBookController(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    //endregion

    //region Methods
    private void confirm(){
        if (!isFormValid()) return;
        System.out.println(publication_dateSpinner.getValue());
    }

    // TODO Zaimplementowac
    private boolean isFormValid(){

        return true;
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

    //region Utilities

    //endregion
}
