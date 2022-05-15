package models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class BookModel {
    //region Attributes
    private int id;
    private String isbn;
    private String title;
    private LocalDate publication_date;
    private int pages;
    private AuthorModel author;
    private List<CategoryModel> categories;
    //endregion

    //region Methods
    public BookModel(int id, String isbn, String title, String publication_date, int pages) {
        try {
            setId(id);
            setIsbn(isbn);
            setTitle(title);
            setPublication_date(LocalDate.parse(publication_date));
            setPages(pages);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }
    //endregion

    //region Get/Set
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublication_date() {
        return publication_date;
    }
    public void setPublication_date(LocalDate publication_date) {
        this.publication_date = publication_date;
    }

    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }

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
