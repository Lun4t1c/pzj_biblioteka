module com.pzj2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.pzj to javafx.fxml;
    exports com.pzj;
    exports controllers;
    opens controllers to javafx.fxml;
}