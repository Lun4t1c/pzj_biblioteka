package models;

public class ReaderModel {
    //region Attributes
    private int Id;
    private String name;
    //endregion

    //region Get/Set
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //endregion
}
