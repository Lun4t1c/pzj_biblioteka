package controllers;

import com.pzj.Globals;
import com.pzj.View;
import com.pzj.ViewSwitcher;
import dao.DataAccess;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.UserInfoModel;


public class LoginController {
    //region FXML controls
    @FXML
    private TextField loginTextField;

    @FXML
    private PasswordField paswordPasswordField;

    @FXML
    private Button loginbtn;

    @FXML
    private Button registerbtn;
    //endregion


    //region Constructor + Initialize
    public LoginController(){

    }
    //endregion


    //region Methods
    private void login(){
        UserInfoModel user = DataAccess.login(loginTextField.getText(), paswordPasswordField.getText());
        if (user != null){
            System.out.println("Login succesfull: " + user.getLogin());
            Globals.loggedUser = user;
            startupMainShell();
        }
        else System.out.println("Couldn log in");
    }

    private void register(){

    }

    private void startupMainShell(){
        Stage stage = (Stage) loginbtn.getScene().getWindow();
        stage.close();

        ViewSwitcher.openWindow(View.SHELL);
    }
    //endregion


    //region Button clicks
    public void onloginbtn(){
        login();
    }

    public void onregisterbtn(){

    }
    //endregion
}
