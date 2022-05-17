package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.*;

import java.sql.*;

public class DataAccess {

    //region Database Credentials
    final static String url = "jdbc:postgresql://ec2-63-32-248-14.eu-west-1.compute.amazonaws.com:5432/dfk0ljleh92fmg";
    final static String user = "ggrndogukgouym";
    final static String password = "89e54c0e15055d0d65790d655f5962873ae627a73a93af232f83a03d9c19ee3b";
    static Connection conn = null;
    //endregion

    //region Utils
    public static void testConnection(){
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Got it!");

        } catch (SQLException e) {
            throw new Error("Problem", e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    //endregion

    //region Book Categories
    public static ObservableList<CategoryModel> getAllCategories() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM PUBLIC.\"Category\"";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet sqlReturnValues = statement.executeQuery();
            ObservableList<CategoryModel> categories = FXCollections.observableArrayList();
            while (sqlReturnValues.next()) {
                categories.add(new CategoryModel(sqlReturnValues.getInt("id"),
                        sqlReturnValues.getString("name")));
            }
            return categories;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static void insertCategory(AuthorModel author){
        throw new UnsupportedOperationException();
    }
    //endregion

    //region Department
    public static ObservableList<DepartmentModel> getAllDepartment() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM PUBLIC.\"Department\"";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet sqlReturnValues = statement.executeQuery();
            ObservableList<DepartmentModel> departments = FXCollections.observableArrayList();
            while (sqlReturnValues.next()) {
                departments.add(new DepartmentModel(sqlReturnValues.getInt("id"),
                        sqlReturnValues.getString("name")));
            }
            return departments;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static void insertDepartment(DepartmentModel department){
        throw new UnsupportedOperationException();
    }
    //endregion

    //region Department
    public static ObservableList<LanguageModel> getAllLanguage() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM PUBLIC.\"Language\"";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet sqlReturnValues = statement.executeQuery();
            ObservableList<LanguageModel> languages = FXCollections.observableArrayList();
            while (sqlReturnValues.next()) {
                languages.add(new LanguageModel(sqlReturnValues.getInt("id"),
                        sqlReturnValues.getString("name")));
            }
            return languages;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static void insertLanguage(LanguageModel language){
        throw new UnsupportedOperationException();
    }
    //endregion

    //region Books
    public static ObservableList<BookModel> getAllBooks() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM public.\"Book\"";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet sqlReturnValues = statement.executeQuery();
            ObservableList<BookModel> books = FXCollections.observableArrayList();

            while (sqlReturnValues.next()) {
                books.add(new BookModel(sqlReturnValues.getInt("id"),
                                        sqlReturnValues.getString("isbn"),
                                        sqlReturnValues.getString("title"),
                                        sqlReturnValues.getString("publication_date"),
                                        sqlReturnValues.getInt("pages")));
            }
            return  books;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static void insertBook(BookModel book) {

    }
    //endregion

    //region Authors
    public static ObservableList<AuthorModel> getAllAuthor() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM PUBLIC.\"Author\"";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet sqlReturnValues = statement.executeQuery();
            ObservableList<AuthorModel> authors = FXCollections.observableArrayList();
            while (sqlReturnValues.next()) {
                authors.add(new AuthorModel(sqlReturnValues.getInt("id"),
                                            sqlReturnValues.getString("name"),
                                            sqlReturnValues.getString("surname"),
                                            sqlReturnValues.getString("remarks")));
            }
            return authors;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static void insertAuthor(AuthorModel author){
        throw new UnsupportedOperationException();
    }
    //endregion

    //region Publisher
    public static ObservableList<PublisherModel> getAllPublishers() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM PUBLIC.\"Publisher\"";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet sqlReturnValues = statement.executeQuery();
            ObservableList<PublisherModel> languages = FXCollections.observableArrayList();
            while (sqlReturnValues.next()) {
                languages.add(new PublisherModel(sqlReturnValues.getInt("id"),
                                                 sqlReturnValues.getString("name"),
                                                 sqlReturnValues.getString("address"),
                                                 sqlReturnValues.getString("remarks")));
            }
            return languages;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    //endregion

    //region Readers
    public static ObservableList<ReaderModel> getAllReaders() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT * \n" +
                    "FROM PUBLIC.\"Reader\" \n" +
                    "INNER JOIN PUBLIC.\"User_Info\" \n" +
                    "ON \"User_Info\".id = \"Reader\".user_info_id";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet sqlReturnValues = statement.executeQuery(query);
            ObservableList<ReaderModel> readers = FXCollections.observableArrayList();
            while (sqlReturnValues.next()) {
                readers.add(new ReaderModel(sqlReturnValues.getInt("user_info_id"),
                                            sqlReturnValues.getString("login"),
                                            sqlReturnValues.getString("password"),
                                            sqlReturnValues.getString("first_name"),
                                            sqlReturnValues.getString("surname"),
                                            sqlReturnValues.getString("registration_date"),
                                            sqlReturnValues.getString("card_nr")));
            }
            return readers;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    //endregion

    //region Employees
    public static ObservableList<EmployeeModel> getAllEmployees() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT * \n" +
                    "FROM PUBLIC.\"Reader\" \n" +
                    "INNER JOIN PUBLIC.\"User_Info\" \n" +
                    "ON \"User_Info\".id = \"Reader\".user_info_id";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet sqlReturnValues = statement.executeQuery(query);
            ObservableList<EmployeeModel> employees = FXCollections.observableArrayList();
            while (sqlReturnValues.next()) {
                employees.add(new EmployeeModel(sqlReturnValues.getInt("user_info_id"),
                                                sqlReturnValues.getString("login"),
                                                sqlReturnValues.getString("password"),
                                                sqlReturnValues.getString("first_name"),
                                                sqlReturnValues.getString("surname"),
                                                sqlReturnValues.getString("registration_date"),
                                                sqlReturnValues.getString("position")));
            }
            return employees;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    //endregion
}
