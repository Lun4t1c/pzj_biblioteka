package models;

import java.time.LocalDate;

public class AuthorModel {
    //region Attributes
    private int id;
    private String name;
    private String surname;
    private String remarks;
    //endregion

    //region Methods
    public AuthorModel(int id, String name, String surname, String remarks) {
        try {
            setId(id);
            setName(name);
            setSurname(surname);
            setRemarks(remarks);
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
    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) { this.surname = surname; }
    public String getFullName(){
        return name + " " + surname;
    }
    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
    //endregion


    //region Methods

    //endregion
}
