package models;

public class CopyModel {
    //region Attributes
    private int id;
    private String bookId;
    private String accession_nr;
    private String department_id;
    private boolean availability;
    private String remarks;
    //endregion

    //region Constructors
    public CopyModel(int id,
                     String bookId,
                     String accession_nr,
                     String department_id,
                     boolean availability,
                     String remarks) {
        setId(id);
        this.bookId = bookId;
        setAccession_nr(accession_nr);
        this.department_id = department_id;
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

    public String getAccession_nr() {
        return accession_nr;
    }

    public void setAccession_nr(String accession_nr) {
        this.accession_nr = accession_nr;
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
