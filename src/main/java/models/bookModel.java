package models;

public class bookModel {
    //region Attributes
    private int id;
    private String title;
    private int publicationYear;
    private authorModel author;
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

    public authorModel getAuthor() {
        return author;
    }

    public void setAuthor(authorModel author) {
        this.author = author;
    }
    //endregion


    //region Methods
    public void rent(){

    }
    //endregion
}
