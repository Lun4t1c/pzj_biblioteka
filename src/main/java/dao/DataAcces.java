package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DataAcces {
    public static ObservableList<BookModel> getDummyBooks(){
        ObservableList<BookModel> books = FXCollections.observableArrayList();


        AuthorModel tempAuthor = new AuthorModel();
        tempAuthor.setFirstName("Mateusz");
        tempAuthor.setLastName("Kupiec");
        tempAuthor.setId(3);

        GenreModel tempGenre = new GenreModel();
        tempGenre.setId(4);
        tempGenre.setName("Mitomania");

        BookModel tempBook = new BookModel();
        tempBook.setAuthor(tempAuthor);
        tempBook.setId(2);
        tempBook.setTitle("Jakby byla melina to bysmy nie mogli jedli kotletu");
        tempBook.setPublicationYear(2015);

        books.add(tempBook);
        //books.add(tempBook);

        return  books;
    }

    //region Utils
    public static void testConnection(){
        String url = "jdbc:postgresql://ec2-176-34-211-0.eu-west-1.compute.amazonaws.com:5432/d6rtrjpgj3e5e4";
        Properties prop = new Properties();
        prop.setProperty("user","edztrbhrtbejew");
        prop.setProperty("password","c830a89bd18dfe84ce7dae9566b2182d426ddca0edf031cb9dc3b0ef713f27fe");

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, prop);

            Statement statement = conn.createStatement();
            //String sql = String.format("INSERT INTO books(title, author) VALUES('%s', '%s')", "Beng beng", "Mati kupiec");
            //String sql = String.format("CREATE TABLE books (Id serial PRIMARY KEY, title VARCHAR(50), author VARCHAR(50))");
            //statement.executeUpdate(sql);

            String sql = String.format("SELECT id, title, author FROM books");
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                System.out.println("id: " + resultSet.getInt("Id") +
                        ", title: " + resultSet.getString("title") +
                        ", author: " + resultSet.getString("author"));
            }

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

    //region Get Data
    public static ObservableList<BookModel> getAllBooks(){
        ObservableList<BookModel> books = FXCollections.observableArrayList();

        return  books;
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
