package models;

public class CopyModel {
    //region Attributes
    private int id;
    private int book_id;
    private String accession_nr;
    private int department_id;
    private boolean availability;
    private String remarks;
    //endregion

    //region Constructors
    public CopyModel(int id,
                     int book_id,
                     String accession_nr,
                     int department_id,
                     boolean availability,
                     String remarks) {
        setId(id);
        setBook_id(book_id);
        setAccession_nr(accession_nr);
        setDepartment_id(department_id);
        setAvailability(availability);
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

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getAccession_nr() {
        return accession_nr;
    }

    public void setAccession_nr(String accession_nr) {
        this.accession_nr = accession_nr;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    //endregion

}
