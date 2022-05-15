package models;

public class AuthorModel {
    //region Attributes
    private int id;
    private String name;
    private String surname;
    private String remarks;
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
    public void setSurname(String name) { this.name = name; }
    public String getSurname() {
        return surname;
    }
    public String getFullName(){
        return name + " " + surname;
    }
    public String getRemarks() { return remarks; }
    public void setRemarks() { this.remarks = remarks; }
    //endregion


    //region Methods

    //endregion
}
