package com.pzj;

public enum View {
    MAIN_LIBRARY("views/main-library-view.fxml"),
    BOOK_INSPECTOR("views/book-inspector-view.fxml"),
    BORROW_BOOK("views/borrow-book-view.fxml");

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
