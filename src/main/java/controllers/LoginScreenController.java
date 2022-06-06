package controllers;

import dao.DataAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.HashMap;

public class LoginScreenController {

    //region FXML controls
    @FXML
    public Button login_Btn;
    @FXML
    public TextField login_TextField;
    @FXML
    public TextField password_TextField;
    public Label labelShow;

    public void loginClick(ActionEvent actionEvent) {
        DataAccess.login(login_TextField.getText(), password_TextField.getText());
    }
    //endregion


    //region Attributes

    //endregion
}
