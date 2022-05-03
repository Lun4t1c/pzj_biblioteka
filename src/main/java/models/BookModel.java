package models;

import java.util.List;

public class BookModel {
    //region Attributes
    private int id;
    private String title;
    private int publicationYear;
    private AuthorModel author;
    private List<GenreModel> genres;
    //endregion

    //region Get/Set
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public AuthorModel getAuthor() {
        return author;
    }
    public void setAuthor(AuthorModel author) {
        this.author = author;
    }
    //endregion


    //region Methods
    public void borrow(ReaderModel reader){

    }
    //endregion
}
