package com.pzj;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewSwitcher {

    private static Scene scene;

    public static void setScene(Scene scene){
        ViewSwitcher.scene = scene;
    }

    public static void switchTo(View view){
        if (scene == null){
            System.out.println("No scene was set");
            return;
        }

        try {
            Parent root = FXMLLoader.load(
                    ViewSwitcher.class.getResource(view.getFileName())
            );

            scene.setRoot(root);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    /**
     * Open new window with specified view
     * @param view View to load upon creating new window
     */
    public static void openWindow(View view){
        try {
            Parent root = FXMLLoader.load(
                    ViewSwitcher.class.getResource(view.getFileName())
            );

            Stage stage = new Stage();
            stage.setTitle("New window");
            stage.setScene(new Scene(root, 700, 700));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Parent getView(View view) throws IOException{
        Parent out = FXMLLoader.load(
          ViewSwitcher.class.getResource(view.getFileName())
        );

        return  out;
    }
}
