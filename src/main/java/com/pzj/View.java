package com.pzj;

public enum View {
    MAIN_LIBRARY("views/main-library-view.fxml"),
    BOOK_INSPECTOR("views/book-inspector-view.fxml"),
    BORROW_BOOK("views/borrow-book-view.fxml"),
    ADD_BOOK("views/add-book-view.fxml"),
    SHELL("views/shell-view.fxml"),
    LOGIN("views/login-view.fxml"),
    REGISTER("views/register-view.fxml")
    ;

    private String fileName;

    View(String fileName){
        this.fileName = fileName;
    }

    public String getFileName()
    {
        if (fileName != null) return fileName;
        else{
            throw new RuntimeException("View.fileName is null.");
        }
    }
}
