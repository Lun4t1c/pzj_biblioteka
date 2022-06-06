package controllers;

import dao.DataAccess;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import models.*;
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
    private ComboBox<AuthorModel> knownAuthorsComboBox;

    @FXML
    private ComboBox<PublisherModel> knownPublisherComboBox;

    @FXML
    private ComboBox<LanguageModel> knownLanguageComboBox;

    @FXML
    private ComboBox<CategoryModel> knownCategoryCombobox;

    @FXML
    private Button confirmbtn;

    @FXML
    private Button clearbtn;
    //endregion


    //region Attributes

    //endregion


    //region Constructor + Initialize
    public AddBookController(){
        ObservableList<EmployeeModel> benc = DataAccess.getAllEmployees();
        for (EmployeeModel em : benc){
            System.out.println("-: " + em.getLogin());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        knownAuthorsComboBox.setItems(DataAccess.getAllAuthor());
        knownCategoryCombobox.setItems(DataAccess.getAllCategories());
        knownLanguageComboBox.setItems(DataAccess.getAllLanguage());
        knownPublisherComboBox.setItems(DataAccess.getAllPublishers());

        /*
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
        */

        knownAuthorsComboBox.setConverter(new StringConverter<AuthorModel>() {
            @Override
            public String toString(AuthorModel authorModel) {
                if (authorModel == null) return "";
                return authorModel.getFullName();
            }

            @Override
            public AuthorModel fromString(String s) {
                return null;
            }
        });

        knownPublisherComboBox.setConverter(new StringConverter<PublisherModel>() {
            @Override
            public String toString(PublisherModel publisherModel) {
                if (publisherModel == null) return "";
                return publisherModel.getName();
            }

            @Override
            public PublisherModel fromString(String s) {
                return null;
            }
        });

        knownCategoryCombobox.setConverter(new StringConverter<CategoryModel>() {
            @Override
            public String toString(CategoryModel categoryModel) {
                if (categoryModel == null) return "";
                return categoryModel.getName();
            }

            @Override
            public CategoryModel fromString(String s) {
                return null;
            }
        });

        knownLanguageComboBox.setConverter(new StringConverter<LanguageModel>() {
            @Override
            public String toString(LanguageModel languageModel) {
                if (languageModel == null) return "";
                return languageModel.getName();
            }

            @Override
            public LanguageModel fromString(String s) {
                return null;
            }
        });
    }
    //endregion


    //region Methods
    private void confirm(){
        if (!isFormValid()) return;

        BookModel book = new BookModel(
                -1,
                isbnTextField.getText(),
                titleTextField.getText(),
                knownPublisherComboBox.getValue().getId(),
                knownAuthorsComboBox.getValue().getId(),
                knownCategoryCombobox.getValue().getId(),
                publication_dateTextField.getText(),
                knownLanguageComboBox.getValue().getId(),
                Integer.parseInt(pagesTextField.getText())
        );

        DataAccess.insertBook(book);
        resetForm();
    }

    private void resetForm(){
        isbnTextField.setText("");
        titleTextField.setText("");
        publication_dateTextField.setText("");
        pagesTextField.setText("");
        knownLanguageComboBox.setValue(null);
        knownCategoryCombobox.setValue(null);
        knownPublisherComboBox.setValue(null);
        knownAuthorsComboBox.setValue(null);
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
