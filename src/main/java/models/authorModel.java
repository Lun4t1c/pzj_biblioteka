package models;

public class authorModel {
    //region Attributes
    private int Id;
    private String FirstName;
    private String LastName;
    //endregion

    //region Get/Set
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFullName(){
        return FirstName + " " + LastName;
    }
    //endregion


    //region Methods

    //endregion
}
