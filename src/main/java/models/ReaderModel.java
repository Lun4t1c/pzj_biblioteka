package models;

public class ReaderModel extends UserInfoModel {
    //region Attributes
    private String card_nr;
    //endregion

    public ReaderModel(int id,
                       String login,
                       String password,
                       String first_name,
                       String surname,
                       String registration_date,
                       String card_nr) {
        super(id, login, password, first_name, surname, registration_date);
        setCardNr(card_nr);
    }

    ReaderModel(int id,
                String login,
                String password,
                String first_name,
                String second_name,
                String surname,
                String phone,
                String email,
                String address,
                String registration_date,
                String card_nr) {
        super(id, login, password, first_name, second_name, surname, phone, email, address, registration_date);
        setCardNr(card_nr);
    }

    //region Get/Set
    public String getCardNr() {
        return card_nr;
    }
    public void setCardNr(String name) {
        this.card_nr = card_nr;
    }
    //endregion
}
