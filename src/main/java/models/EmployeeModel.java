package models;

public class EmployeeModel extends UserInfoModel {
    //region Attributes
    private int emp_id;
    private String position;
    //endregion

    public EmployeeModel(int emp_id,
                         int user_info_id,
                         String position,
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
        setEmp_id(emp_id);
        setPosition(position);
    }

    //region Get/Set
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public int getEmp_id() {
        return emp_id;
    }
    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }
    //endregion
}
