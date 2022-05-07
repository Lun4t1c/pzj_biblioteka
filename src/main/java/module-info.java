module com.pzj2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.pzj to javafx.fxml;
    exports com.pzj;
    exports controllers;
    opens controllers to javafx.fxml;
}