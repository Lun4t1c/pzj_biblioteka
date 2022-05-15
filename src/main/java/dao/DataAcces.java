package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.Properties;

public class DataAcces {

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

            // Statement statement = conn.createStatement();
            //String sql = String.format("INSERT INTO books(title, author) VALUES('%s', '%s')", "Beng beng", "Mati kupiec");
            //String sql = String.format("CREATE TABLE books (Id serial PRIMARY KEY, title VARCHAR(50), author VARCHAR(50))");
            //statement.executeUpdate(sql);

//            String sql = String.format("SELECT id, title, author FROM books");
//            ResultSet resultSet = statement.executeQuery(sql);
//
//            while(resultSet.next()){
//                System.out.println("id: " + resultSet.getInt("Id") +
//                        ", title: " + resultSet.getString("title") +
//                        ", author: " + resultSet.getString("author"));
//            }

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

    public static ObservableList<BookModel> getDummyBooks(){
        ObservableList<BookModel> books = FXCollections.observableArrayList();


//        AuthorModel tempAuthor = new AuthorModel();
//        tempAuthor.setFirstName("Mateusz");
//        tempAuthor.setLastName("Kupiec");
//        tempAuthor.setId(3);
//
//        CategoryModel tempGenre = new CategoryModel();
//        tempGenre.setId(4);
//        tempGenre.setName("Mitomania");
//
//        BookModel tempBook = new BookModel();
//        tempBook.setAuthor(tempAuthor);
//        tempBook.setId(2);
//        tempBook.setTitle("Jakby byla melina to bysmy nie mogli jedli kotletu");
//        tempBook.setPublicationYear(LocalDate.ofEpochDay(2022-05-13));
//
//        books.add(tempBook);
        //books.add(tempBook);

        return  books;
    }

    //region Get Data
    public static ObservableList<BookModel> getAllBooks(){
        try {
            conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM public.\"Book\"";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet sqlReturnValues = statement.executeQuery();
            ObservableList<BookModel> books = FXCollections.observableArrayList();

            while (sqlReturnValues.next()) {
                books.add(new BookModel(sqlReturnValues.getInt("id"), sqlReturnValues.getString("isbn"), sqlReturnValues.getString("title"), sqlReturnValues.getString("publication_date"), sqlReturnValues.getInt("pages")));
            }
            return  books;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    //endregion

    //region Insert Data
    public static void insertBook(BookModel book){
        throw new UnsupportedOperationException();
    }

    public static void insertAuthor(AuthorModel author){
        throw new UnsupportedOperationException();
    }
    //endregion
}
