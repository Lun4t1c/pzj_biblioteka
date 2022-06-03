package models;

import java.time.LocalDate;

public class BookModel {
    //region Attributes
    private int id;
    private String isbn;
    private String title;
    private int publisher_id;
    private int author_id;
    private int category_id;
    private LocalDate publication_date;
    private int lang_id;
    private int pages;
    //endregion

    //region Methods
    public BookModel(int id,
                     String isbn,
                     String title,
                     int publisher_id,
                     int author_id,
                     int category_id,
                     String publication_date,
                     int pages) {
        try {
            setId(id);
            setIsbn(isbn);
            setTitle(title);
            setPublication_date(LocalDate.parse(publication_date));
            setPages(pages);
        } catch (Exception ex) {
            System.out.println("BookModel Exception: " + ex.getMessage());
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

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public LocalDate getPublication_date() {
        return publication_date;
    }
    public void setPublication_date(LocalDate publication_date) {
        this.publication_date = publication_date;
    }

    public int getLang_id() {
        return lang_id;
    }

    public void setLang_id(int lang_id) {
        this.lang_id = lang_id;
    }

    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }

    //endregion


    //region Methods
    public void borrow(ReaderModel reader){

    }
    //endregion
}
