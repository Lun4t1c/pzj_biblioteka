package models;

import java.sql.Date;
import java.time.LocalDate;

public class TransactionModel {
    //region Attributes
    private int id;
    private int copy_id;
    private int reader_id;
    private int employee_id;
    private LocalDate reservation_date;
    private LocalDate reservation_term;
    private LocalDate borrow_date;
    private LocalDate borrow_term;
    private LocalDate return_date;
    private double debt;
    //endregion

    //region Constructors
    public TransactionModel(int id,
                            int copy_id,
                            int reader_id,
                            int employee_id,
                            String reservation_date,
                            String reservation_term,
                            String borrow_date,
                            String borrow_term,
                            String return_date,
                            double debt) {
        setId(id);
        setCopy_id(copy_id);
        setReader_id(reader_id);
        setEmployee_id(employee_id);
        setReservation_date(LocalDate.parse(reservation_date));
        setReservation_term(LocalDate.parse(reservation_term));
        setBorrow_date(LocalDate.parse(borrow_date));
        setBorrow_term(LocalDate.parse(borrow_term));
        setReturn_date(LocalDate.parse(return_date));
        setDebt(debt);
    }
    public TransactionModel(int id,
                            int copy_id,
                            int reader_id,
                            int employee_id,
                            LocalDate reservation_date,
                            LocalDate reservation_term,
                            LocalDate borrow_date,
                            LocalDate borrow_term,
                            LocalDate return_date,
                            double debt) {
        setId(id);
        setCopy_id(copy_id);
        setReader_id(reader_id);
        setEmployee_id(employee_id);
        setReservation_date(reservation_date);
        setReservation_term(reservation_term);
        setBorrow_date(borrow_date);
        setBorrow_term(borrow_term);
        setReturn_date(return_date);
        setDebt(debt);
    }

    public TransactionModel(int id,
                            int copy_id,
                            int reader_id,
                            int employee_id,
                            Date reservation_date,
                            Date reservation_term,
                            Date borrow_date,
                            Date borrow_term,
                            Date return_date,
                            double debt) {
        setId(id);
        setCopy_id(copy_id);
        setReader_id(reader_id);
        setEmployee_id(employee_id);
        setReservation_date(LocalDate.parse((CharSequence) reservation_date));
        setReservation_term(LocalDate.parse((CharSequence) reservation_term));
        setBorrow_date(LocalDate.parse((CharSequence) borrow_date));
        setBorrow_term(LocalDate.parse((CharSequence) borrow_term));
        setReturn_date(LocalDate.parse((CharSequence) return_date));
        setDebt(debt);
    }
    //endregion

    //region Get/Set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCopy_id() {
        return copy_id;
    }

    public void setCopy_id(int copy_id) {
        this.copy_id = copy_id;
    }

    public int getReader_id() {
        return reader_id;
    }

    public void setReader_id(int reader_id) {
        this.reader_id = reader_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
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
