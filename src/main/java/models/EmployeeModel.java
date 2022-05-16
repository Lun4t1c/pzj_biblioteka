package models;

public class EmployeeModel extends UserInfoModel {
    //region Attributes
    private String position;
    //endregion

    public EmployeeModel(int id,
                         String login,
                         String password,
                         String first_name,
                         String surname,
                         String registration_date,
                         String position) {
        super(id, login, password, first_name, surname, registration_date);
        setPosition(position);
    }

    EmployeeModel(int id,
                String login,
                String password,
                String first_name,
                String second_name,
                String surname,
                String phone,
                String email,
                String address,
                String registration_date,
                String position) {
        super(id, login, password, first_name, second_name, surname, phone, email, address, registration_date);
        setPosition(position);
    }

    //region Get/Set
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    //endregion
}
