package com.pzj;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewSwitcher {

    //region Loaded scenes
    private static Parent MainLibraryParent = null;
    private static Parent AddBookParent = null;
    private static Parent BorrowBookParent = null;
    //endregion

    private static Scene scene;

    public static void setScene(Scene scene){
        ViewSwitcher.scene = scene;
    }

    @Deprecated
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
            stage.setScene(new Scene(root, 700, 700));
            stage.setMaximized(true);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialize() {
        Thread mainThread = new Thread() {
            @Override
            public void run() {
                System.out.println("crt main");
                try {
                    MainLibraryParent = FXMLLoader.load(ViewSwitcher.class.getResource(View.MAIN_LIBRARY.getFileName()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("crt main finish");
            }
        };
        Thread addThread = new Thread() {
            @Override
            public void run() {
                try {
                    BorrowBookParent = FXMLLoader.load(ViewSwitcher.class.getResource(View.BORROW_BOOK.getFileName()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };

            Thread borrowThread = new Thread() {
                @Override
                public void run() {
                    try {
                        AddBookParent = FXMLLoader.load(ViewSwitcher.class.getResource(View.ADD_BOOK.getFileName()));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
            mainThread.start();
            borrowThread.start();
            addThread.start();
        }

    public static Parent getView(View view) throws IOException{
        /*
        Parent out = FXMLLoader.load(
          ViewSwitcher.class.getResource(view.getFileName())
        );
        */


        switch (view){
            case MAIN_LIBRARY:
                if (MainLibraryParent != null) return MainLibraryParent;

                MainLibraryParent = FXMLLoader.load(ViewSwitcher.class.getResource(view.getFileName()));
                return MainLibraryParent;


            case ADD_BOOK:
                if (AddBookParent != null) return AddBookParent;

                AddBookParent = FXMLLoader.load(ViewSwitcher.class.getResource(view.getFileName()));
                return AddBookParent;


            case BORROW_BOOK:
                if (BorrowBookParent != null) return BorrowBookParent;

                BorrowBookParent = FXMLLoader.load(ViewSwitcher.class.getResource(view.getFileName()));
                return BorrowBookParent;
        }

        return null;
    }
}
