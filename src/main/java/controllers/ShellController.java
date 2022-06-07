package controllers;

import com.pzj.Globals;
import com.pzj.View;
import com.pzj.ViewSwitcher;
import dao.DataAccess;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
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
        if (!Globals.getIsLoggedUserEmployee()) {
            System.out.println("EMPLOEYYEEEDGHSATY");
            displayMainLibraryView();
        }
        else {
            System.out.println("READEREEDS");
            displayMainLibraryEmployeeView();
        }
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



    private void displayMainLibraryEmployeeView() {
        displayView(View.SHELL_EMPLOYEE);
    }

    /**
     * Display book borrowing view
     */
    /*private void displayBorrowBookView(){
        displayView(View.BORROW_BOOK);
    }*/

    private void displayAddBookView(){
        displayView(View.ADD_BOOK);
    }
    //endregion


    //region Button clicks
    @FXML
    protected void onMainLibraryViewButton(){
        if (!Globals.getIsLoggedUserEmployee()) {
            System.out.println("EMPLOEYYEEEDGHSATY");
            displayMainLibraryView();
        }
        else {
            System.out.println("READEREEDS");
            displayMainLibraryEmployeeView();
        }
    }

   /* @FXML
    protected void onBorrowBookViewButton(){
        displayBorrowBookView();
    }*/

    @FXML
    protected void onAddBookViewButton(){
        displayAddBookView();
    }
    //endregion
}
