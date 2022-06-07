package models;

import java.time.LocalDate;

abstract public class UserInfoModel {
    //region Attributes
    private int user_info_id;
    private String login;
    private String password;
    private String first_name;
    private String second_name;
    private String surname;
    private String phone;
    private String email;
    private String address;
    private LocalDate registration_date;
    //endregion

    //region Constructors

    UserInfoModel(int user_info_id,
                  String login,
                  String password,
                  String first_name,
                  String second_name,
                  String surname,
                  String phone,
                  String email,
                  String address,
                  String registration_date) {
        setUser_info_id(user_info_id);
        setLogin(login);
        setPassword(password);
        setFirst_name(first_name);
        setSecond_name(second_name);
        setSurname(surname);
        setPhone(phone);
        setEmail(email);
        setAddress(address);
        setRegistration_date(LocalDate.parse(registration_date));
    }
    //endregion

    //region Get/Set
    public int getUser_info_id() { return user_info_id; }

    public void setUser_info_id(int read_id) {
        this.user_info_id = read_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(LocalDate registration_date) {
        this.registration_date = registration_date;
    }

    //endregion
}
