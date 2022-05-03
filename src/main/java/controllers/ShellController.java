package controllers;

import com.pzj.View;
import com.pzj.ViewSwitcher;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ShellController {
    //region FXML Controls
    @FXML
    private BorderPane mainPane;
    //endregion


    //region Constructor
    public ShellController(){

    }
    //endregion


    //region Methods

    //endregion


    //region Button clicks
    @FXML
    protected void onButton1Click(){
        System.out.println("BENG");

        Parent parent = null;
        try {
            parent = ViewSwitcher.getView(View.BOOK_INSPECTOR);
            mainPane.setCenter(parent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onButton2Click(){
        System.out.println("BENG");

        Parent parent = null;
        try {
            parent = ViewSwitcher.getView(View.BORROW_BOOK);
            mainPane.setCenter(parent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //endregion
}
