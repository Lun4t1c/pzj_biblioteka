package controllers;

import com.pzj.View;
import com.pzj.ViewSwitcher;
import dao.DataAccess;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.EmployeeModel;
import models.ReaderModel;
import models.UserInfoModel;

import java.time.LocalDate;


public class RegisterController {
    //region FXML controls
    @FXML
    private TextField loginTextField;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField surnameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private CheckBox employerCheckBox;

    @FXML
    private Button backButton;

    @FXML
    private Button registerButton;
    //endregion


    //region Constructor + Initialize
    public RegisterController(){

    }
    //endregion


    //region Methods
    private void back(){
        Stage stage = (Stage) registerButton.getScene().getWindow();
        stage.close();

        ViewSwitcher.openWindow(View.LOGIN);
    }

    private void register(){
        if (employerCheckBox.isSelected()){
            EmployeeModel employee = new EmployeeModel(
                    -1,
                    -1,
                    "p",
                    loginTextField.getText(),
                    passwordPasswordField.getText(),
                    nameTextField.getText(),
                    "p",
                    surnameTextField.getText(),
                    "p",
                    emailTextField.getText(),
                    "p",
                    LocalDate.now().toString()
            );

            DataAccess.insertEmployee(employee);
            System.out.println("Succesfully added employee");
        }
        else {
            ReaderModel reader = new ReaderModel(
                    -1,
                    -1,
                    "p",
                    loginTextField.getText(),
                    passwordPasswordField.getText(),
                    nameTextField.getText(),
                    "p",
                    surnameTextField.getText(),
                    "p",
                    emailTextField.getText(),
                    "p",
                    LocalDate.now().toString()
            );

            DataAccess.insertReader(reader);
            System.out.println("Succesfully added reader");
        }
    }
    //endregion


    //region Button clicks
    public void onbackButton(){
        back();
    }

    public void onregisterButton(){
        register();
    }
    //endregion
}
