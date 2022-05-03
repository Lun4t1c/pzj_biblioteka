package controllers;

import com.pzj.View;
import com.pzj.ViewSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainLibraryController {
    //region FXML Controls
    @FXML
    private Label testLabel;
    //endregion


    //region Methods
    private void testMethod(){
        testLabel.setText("Test text");
    }
    //endregion


    //region Button clicks
    @FXML
    protected void onTestButtonClick(){
        testMethod();
    }

    @FXML
    protected void onViewSwitchTestClick(){
        ViewSwitcher.switchTo(View.BOOK_INSPECTOR);
    }

    @FXML
    protected void onNewWindowTestClick(){
        ViewSwitcher.openWindow(View.BORROW_BOOK);
    }
    //endregion
}
