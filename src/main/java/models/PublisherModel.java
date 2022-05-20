package models;

public class PublisherModel {
    //region Attributes
    private int id;
    private String name;
    private String address;
    private String remarks;

    public PublisherModel(int id,
                          String name,
                          String address,
                          String remarks) {
        setId(id);
        setName(name);
        setAddress(address);
        setRemarks(remarks);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    //endregion
}
