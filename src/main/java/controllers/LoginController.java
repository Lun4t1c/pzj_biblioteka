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
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import models.UserInfoModel;

import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable{
    //region FXML controls
    @FXML
    private BorderPane pane;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image bg = new Image("https://img.freepik.com/darmowe-zdjecie/szare-abstrakcyjne-tlo-technologii-szkieletowej_53876-101941.jpg?w=2000");
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO, false, false, true, false);

        Background background = new Background(new BackgroundImage(bg,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize));

        pane.setBackground(background);
    }
    //endregion


    //region Methods
    private void login(){
        UserInfoModel user = DataAccess.login(loginTextField.getText(), paswordPasswordField.getText());
        if (user != null){
            System.out.println("Login succesfull: " + user.getLogin());
            Globals.setLoggedUser(user);

            if (Globals.getIsLoggedUserEmployee())
                startupMainShellEmployee();
            else
                startupMainShell();
        }
        else System.out.println("Could not log in");
    }

    private void register(){
        Stage stage = (Stage) loginbtn.getScene().getWindow();
        stage.close();

        ViewSwitcher.openWindow(View.REGISTER);
    }

    private void startupMainShell(){
        Stage stage = (Stage) loginbtn.getScene().getWindow();
        stage.close();

        ViewSwitcher.openWindow(View.SHELL);
    }

    private void startupMainShellEmployee(){
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
        register();
    }
    //endregion
}
