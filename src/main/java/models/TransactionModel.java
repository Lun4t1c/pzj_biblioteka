package models;

import java.time.LocalDate;

public class TransactionModel {
    //region Attributes
    private int id;
    private String copy_id;
    private String reader_id;
    private String employee_id;
    private LocalDate reservation_date;
    private LocalDate reservation_term;
    private LocalDate borrow_date;
    private LocalDate borrow_term;
    private LocalDate return_date;
    private double debt;
    //endregion

    //region Constructors
    public TransactionModel(int id,
                     String copy_id,
                     String reader_id,
                     String employee_id,
                     LocalDate reservation_date,
                     LocalDate reservation_term,
                     LocalDate borrow_date,
                     LocalDate return_date,
                     double debt) {
        setId(id);
        this.copy_id = copy_id;

    }
    //endregion

    //region Get/Set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCopy_id() {
        return copy_id;
    }

    public void setCopy_id(String copy_id) {
        this.copy_id = copy_id;
    }

    public String getReader_id() {
        return reader_id;
    }

    public void setReader_id(String reader_id) {
        this.reader_id = reader_id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public LocalDate getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(LocalDate reservation_date) {
        this.reservation_date = reservation_date;
    }

    public LocalDate getReservation_term() {
        return reservation_term;
    }

    public void setReservation_term(LocalDate reservation_term) {
        this.reservation_term = reservation_term;
    }

    public LocalDate getBorrow_date() {
        return borrow_date;
    }
    public void setBorrow_date(LocalDate borrow_date) {
        this.borrow_date = borrow_date;
    }

    public LocalDate getBorrow_term() {
        return borrow_term;
    }

    public void setBorrow_term(LocalDate borrow_term) {
        this.borrow_term = borrow_term;
    }

    public LocalDate getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDate return_date) {
        this.return_date = return_date;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }
    //endregion
}
