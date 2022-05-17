package models;

public class DepartmentModel {
    //region Attributes
    private int id;
    private String name;

    public DepartmentModel(int id, String name) {
        setId(id);
        setName(name);
    }
    //endregion

    //region Get/Set
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //endregion
}
