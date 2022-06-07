package controllers;

import com.pzj.View;
import com.pzj.ViewSwitcher;
import dao.DataAccess;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import models.UserInfoModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShellController implements Initializable {

    //region Attributes

    //endregion


    //region FXML Controls
    @FXML
    private BorderPane mainPane;
    //endregion


    //region Constructor + Initialize
    public ShellController(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayMainLibraryView();
    }
    //endregion


    //region Methods
    /**
     * Helper function to avoid code redundancy in corresponding methods
     * @param view View to display
     */
    private void displayView(View view){
        Parent parent = null;
        try {
            parent = ViewSwitcher.getView(view);
            mainPane.setCenter(parent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Display main library view
     */
    private void displayMainLibraryView(){
        displayView(View.MAIN_LIBRARY);
    }

    /**
     * Display book borrowing view
     */
    private void displayBorrowBookView(){
        displayView(View.BORROW_BOOK);
    }

    private void displayAddBookView(){
        displayView(View.ADD_BOOK);
    }
    //endregion


    //region Button clicks
    @FXML
    protected void onMainLibraryViewButton(){
        displayMainLibraryView();
    }

    @FXML
    protected void onBorrowBookViewButton(){
        displayBorrowBookView();
    }

    @FXML
    protected void onAddBookViewButton(){
        displayAddBookView();
    }
    //endregion
}
