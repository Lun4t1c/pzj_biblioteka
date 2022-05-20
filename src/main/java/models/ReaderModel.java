package models;

import java.time.LocalDate;

public class ReaderModel extends UserInfoModel {
    //region Attributes
    private int id;
    private String card_nr;
    //endregion

    public ReaderModel(int id,
                       int user_info_id,
                       String card_nr,
                       String login,
                       String password,
                       String first_name,
                       String second_name,
                       String surname,
                       String phone,
                       String email,
                       String address,
                       String registration_date) {
        super(user_info_id, login, password, first_name, second_name, surname, phone, email, address, registration_date);
        setId(id);
        setCardNr(card_nr);
    }

    //region Get/Set
    public int getId() { return id; }
    public void setId(int id) {
        this.id = id;
    }
    public String getCardNr() {
        return card_nr;
    }
    public void setCardNr(String card_nr) {
        this.card_nr = card_nr;
    }
    //endregion
}
