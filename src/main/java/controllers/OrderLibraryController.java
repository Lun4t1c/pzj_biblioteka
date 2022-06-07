package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class OrderLibraryController {
    //region FXML controls
    @FXML
    private TextField searchTextField;

    @FXML
    private ListView ordersListView;

    @FXML
    private TextField titletf;

    @FXML
    private Label copyValuelbl;

    @FXML
    private Label reservationDateValuelbl;

    @FXML
    private Label reservationTermValuelbl;

    @FXML
    private Label borrowDateValuelbl;

    @FXML Label borrowTermValuelbl;

    @FXML
    private Label returnDateValuelbl;

    @FXML
    private Button cancelButton;

    @FXML
    private Button confirmButton;
    //endregion


    //region Constructor + Initialize

    //endregion


    //region Methods
    public void onConfirmButton(){

    }

    public void onCancelButton(){

    }
    //endregion
}
