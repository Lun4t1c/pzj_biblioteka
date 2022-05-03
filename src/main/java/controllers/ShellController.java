package controllers;

import com.pzj.View;
import com.pzj.ViewSwitcher;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ShellController {
    //region Attributes

    //endregion

    //region FXML Controls
    @FXML
    private BorderPane mainPane;
    //endregion

    //region Constructor
    public ShellController(){

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
    //endregion
}
