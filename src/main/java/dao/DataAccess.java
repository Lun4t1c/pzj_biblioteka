package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.*;

import java.sql.*;

public class DataAccess {

    //region Database Credentials
    final static String url = "jdbc:postgresql://ec2-54-75-184-144.eu-west-1.compute.amazonaws.com:5432/d9gq3vr2vd5rpr";
    final static String user = "atvjedtrzlznco";
    final static String password = "39106a59a941117591115a4dc185994429dd86c51349d9f40b93992ece980e19";
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
    public static void insertCategory(CategoryModel category) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "INSERT INTO PUBLIC.\"Category\" (NAME) VALUES '" + category.getName() + "'";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void deleteCategory(int id) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "DELETE FROM PUBLIC.\"Category\" WHERE id = " + id;
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void updateCategory(CategoryModel category) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "UPDATE PUBLIC.\"Category\" SET name = " + category.getName() +
                           " WHERE id = " + category.getId();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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
    public static void insertDepartment(DepartmentModel department) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "INSERT INTO PUBLIC.\"Department\" (name) VALUES '" + department.getName() + "'";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void deleteDepartment(int id) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "DELETE FROM PUBLIC.\"Department\" WHERE id = " + id;
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void updateDepartment(DepartmentModel department) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "UPDATE PUBLIC.\"Department\" SET name = " + department.getName() +
                           " WHERE id = " + department.getId();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //endregion

    //region Language
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
    public static void insertLanguage(LanguageModel language) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "INSERT INTO PUBLIC.\"Language\" (NAME) VALUES '" + language.getName() + "'";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void deleteLanguage(int id) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "DELETE FROM PUBLIC.\"Language\" WHERE id = " + id;
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void updateLanguage(LanguageModel language) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "UPDATE PUBLIC.\"Language\" SET name = " + language.getName() +
                           " WHERE id = " + language.getId();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //endregion

    //region Copies
    public static ObservableList<CopyModel> getAllCopies() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM PUBLIC.\"Copy\"";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet sqlReturnValues = statement.executeQuery();
            ObservableList<CopyModel> copies = FXCollections.observableArrayList();
            while (sqlReturnValues.next()) {
                copies.add(new CopyModel(sqlReturnValues.getInt("id"),
                        sqlReturnValues.getInt("book_id"),
                        sqlReturnValues.getString("accession_nr"),
                        sqlReturnValues.getInt("department_id"),
                        sqlReturnValues.getBoolean("availability"),
                        sqlReturnValues.getString("remarks")));
            }
            return copies;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static void insertCopy(CopyModel copy){
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "INSERT INTO PUBLIC.\"Copy\" (book_id, accession_nr, department_id, availability, remarks) " +
                           "VALUES (" + copy.getBook_id() + ", '" + copy.getAccession_nr() + "', " + copy.getDepartment_id() + ", " + copy.isAvailability() + ", '" + copy.getRemarks() + "')";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void deleteCopy(int id) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "DELETE FROM PUBLIC.\"Copy\" WHERE id = " + id;
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void updateCopy(CopyModel copy) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "UPDATE PUBLIC.\"Copy\" " +
                           "SET book_id = " + copy.getBook_id() + ", accession_nr = " + copy.getAccession_nr() + ", department_id = " + copy.getDepartment_id() + ", availability = " + copy.isAvailability() + ", remarks = " + copy.getRemarks() +
                           "WHERE id = " + copy.getId();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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
                                        sqlReturnValues.getInt("publisher_id"),
                                        sqlReturnValues.getInt("author_id"),
                                        sqlReturnValues.getInt("category_id"),
                                        sqlReturnValues.getString("publication_date"),
                                        sqlReturnValues.getInt("lang_id"),
                                        sqlReturnValues.getInt("pages")));
            }
            return  books;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static void insertBook(BookModel book) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "INSERT INTO PUBLIC.\"Book\" (isbn, title, publisher_id, author_id, category_id, publication_date, lang_id, pages) " +
                           "VALUES ('" + book.getIsbn() + "', '" + book.getTitle() + "', " + book.getPublisher_id() + ", " + book.getAuthor_id() + ", " + book.getCategory_id() +
                           ", '" + book.getPublication_date().toString() + "', " + book.getLang_id() + ", " + book.getPages() + ")" ;
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void deleteBook(int id) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "DELETE FROM PUBLIC.\"Book\" WHERE id = " + id;
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void updateBook(BookModel book) { //int id, String isbn, String title, int publisher_id, int author_id, int category_id, LocalDate publication_date, int lang_id, int pages) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "UPDATE PUBLIC.\"Book\" " +
                            "SET isbn = " + book.getIsbn() +
                            ", title = " + book.getTitle() +
                            ", publisher_id = " + book.getPublisher_id() +
                            ", author_id = " + book.getAuthor_id() +
                            ", category_id = " + book.getCategory_id() +
                            ", publication_date = " + book.getPublication_date() +
                            ", lang_id = " + book.getLang_id() +
                            ", pages = " + book.getPages() +
                            "WHERE id = " + book.getId();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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
            try {
                Connection connection = DriverManager.getConnection(url, user, password);
                String query = "INSERT INTO PUBLIC.\"Author\" (name, surname, remarks)" +
                               "VALUES ('" + author.getName() + "', '" + author.getSurname() + "', '" + author.getRemarks() + "')";
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    public static void deleteAuthor(int id) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "DELETE FROM PUBLIC.\"Author\" WHERE id = " + id;
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void updateAuthor(AuthorModel author) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "UPDATE PUBLIC.\"Author\" " +
                           "SET name = " + author.getName() + ", surname = " + author.getSurname() + ", remarks = " + author.getRemarks() +
                           " WHERE id = " + author.getId();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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
    public static void insertPublisher(PublisherModel publisher){
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "INSERT INTO PUBLIC.\"Publisher\" (name, address, remarks) " +
                           "VALUES ('" + publisher.getName() + "', '" + publisher.getAddress() + "', '" + publisher.getRemarks() + "')";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void deletePublisher(int id) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "DELETE FROM PUBLIC.\"Publisher\" WHERE id = " + id;
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void updatePublisher(PublisherModel publisher) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "UPDATE PUBLIC.\"Publisher\" " +
                    "SET name = " + publisher.getName() + ", address = " + publisher.getAddress() + ", remarks = " + publisher.getRemarks() +
                    "WHERE id = " + publisher.getId();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //endregion

    //region Readers
    public static ObservableList<ReaderModel> getAllReaders() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT PUBLIC.\"Reader\".id id, user_info_id, card_nr, login, PASSWORD, first_name, second_name, surname, phone, email, address, registration_date " +
                    "FROM PUBLIC.\"Reader\" " +
                    "INNER JOIN PUBLIC.\"User_Info\" " +
                    "ON PUBLIC.\"User_Info\".id = PUBLIC.\"Reader\".user_info_id;";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet sqlReturnValues = statement.executeQuery();
            ObservableList<ReaderModel> readers = FXCollections.observableArrayList();

            while (sqlReturnValues.next()) {
                readers.add(new ReaderModel(sqlReturnValues.getInt("id"),
                                            sqlReturnValues.getInt("user_info_id"),
                                            sqlReturnValues.getString("card_nr"),
                                            sqlReturnValues.getString("login"),
                                            sqlReturnValues.getString("password"),
                                            sqlReturnValues.getString("first_name"),
                                            sqlReturnValues.getString("second_name"),
                                            sqlReturnValues.getString("surname"),
                                            sqlReturnValues.getString("phone"),
                                            sqlReturnValues.getString("email"),
                                            sqlReturnValues.getString("address"),
                                            sqlReturnValues.getString("registration_date")));
            }
            return readers;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static void insertReader(ReaderModel reader){
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "CALL insert_reader(" + reader.getLogin() + ", " +
                            reader.getPassword() + ", " +
                            reader.getFirst_name() + ", " +
                            reader.getSecond_name() + ", " +
                            reader.getSurname() + ", " +
                            reader.getPhone() + ", " +
                            reader.getEmail() + ", " +
                            reader.getAddress() + ", " +
                            reader.getRegistration_date() + ", " +
                            reader.getCardNr() + ")";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void deleteReader(int id) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "CALL delete_reader(" + id + ")";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void updateReader(ReaderModel reader) { // (int id, String login, String password, String first_name, String second_name, String surname, String phone, String email, String address, String card_nr) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "CALL update_reader(" + reader.getId() + ", " +
                            reader.getLogin() + ", " +
                            reader.getPassword() + ", " +
                            reader.getFirst_name() + ", " +
                            reader.getSecond_name() + ", " +
                            reader.getSurname() + ", " +
                            reader.getPhone() + ", " +
                            reader.getEmail() + ", " +
                            reader.getAddress() + ", " +
                            reader.getCardNr() + ")";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //endregion

    //region Employees
    public static ObservableList<EmployeeModel> getAllEmployees() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT PUBLIC.\"Employee\".id id, user_info_id, position, login, password, first_name, second_name, surname, phone, email, address, registration_date " +
                    "FROM PUBLIC.\"Employee\" INNER JOIN PUBLIC.\"User_Info\" ON \"User_Info\".id = \"Employee\".user_info_id\n";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet sqlReturnValues = statement.executeQuery();
            ObservableList<EmployeeModel> employees = FXCollections.observableArrayList();

            while (sqlReturnValues.next()) {
                employees.add(new EmployeeModel(sqlReturnValues.getInt("id"),
                                                sqlReturnValues.getInt("user_info_id"),
                                                sqlReturnValues.getString("login"),
                                                sqlReturnValues.getString("password"),
                                                sqlReturnValues.getString("first_name"),
                                                sqlReturnValues.getString("second_name"),
                                                sqlReturnValues.getString("surname"),
                                                sqlReturnValues.getString("phone"),
                                                sqlReturnValues.getString("email"),
                                                sqlReturnValues.getString("address"),
                                                sqlReturnValues.getString("registration_date"),
                                                sqlReturnValues.getString("position")));
            }
            return employees;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static void insertEmployee(EmployeeModel employee){
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "CALL insert_employee( " + employee.getLogin() + ", " +
                            employee.getPassword() + ", " +
                            employee.getFirst_name() + ", " +
                            employee.getSecond_name() + ", " +
                            employee.getSurname() + ", " +
                            employee.getPhone() + ", " +
                            employee.getEmail() + ", " +
                            employee.getAddress() + ", " +
                            employee.getRegistration_date() + ", " +
                            employee.getPosition() + ")";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void deleteEmployee(int id) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "CALL delete_employee(" + id + ")";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void updateEmployee(EmployeeModel employee) { // (int id, String login, String password, String first_name, String second_name, String surname, String phone, String email, String address, String position) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "CALL update_employee(" + employee.getId() + ", " +
                            employee.getLogin() + ", " +
                            employee.getPassword() + ", " +
                            employee.getFirst_name() + ", " +
                            employee.getSecond_name() + ", " +
                            employee.getSurname() + ", " +
                            employee.getPhone() + ", " +
                            employee.getEmail() + ", " +
                            employee.getAddress() + ", " +
                            employee.getPosition() + ")";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //endregion

    //region Transactions
    public static ObservableList<TransactionModel> getAllTransaction() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM public.\"Transaction\"";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet sqlReturnValues = statement.executeQuery();
            ObservableList<TransactionModel> transactions = FXCollections.observableArrayList();
            while (sqlReturnValues.next()) {
                transactions.add(new TransactionModel(sqlReturnValues.getInt("id"),
                                                    sqlReturnValues.getInt("copy_id"),
                                                    sqlReturnValues.getInt("reader_id"),
                                                    sqlReturnValues.getInt("employee_id"),
                                                    sqlReturnValues.getDate("reservation_date"),
                                                    sqlReturnValues.getDate("reservation_term"),
                                                    sqlReturnValues.getDate("borrow_date"),
                                                    sqlReturnValues.getDate("borrow_term"),
                                                    sqlReturnValues.getDate("return_date"),
                                                    sqlReturnValues.getDouble("debt")));
            }
            return  transactions;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static void insertTransaction(TransactionModel transaction) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "INSERT INTO PUBLIC.\"Transaction\" (copy_id, " +
                                                                "reader_id, " +
                                                                "employee_id, " +
                                                                "reservation_date, " +
                                                                "reservation_term, " +
                                                                "borrow_date, " +
                                                                "borrow_term, " +
                                                                "return_date, " +
                                                                "debt)" +
                    "VALUES (" + transaction.getCopy_id() + ", " +
                                 transaction.getReader_id() + ", " +
                                 transaction.getEmployee_id() + ", " +
                                 transaction.getReservation_date() + ", " +
                                 transaction.getReservation_term() + ", " +
                                 transaction.getBorrow_date() + ", " +
                                 transaction.getBorrow_term() + ", " +
                                 transaction.getReturn_date() + ", " +
                                 transaction.getDebt() + ")";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void deleteTransaction(int id) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "DELETE FROM PUBLIC.\"Transaction\" WHERE id = " + id;
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void updateTransaction(TransactionModel transaction) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "UPDATE PUBLIC.\"Transaction\"" +
                            "SET copy_id = " + transaction.getCopy_id() +
                            ", reader_id = " + transaction.getReader_id() +
                            ", employee_id = " + transaction.getEmployee_id() +
                            ", reservation_date = " + transaction.getReservation_date() +
                            ", reservation_term = " + transaction.getReservation_term() +
                            ", borrow_date = " + transaction.getBorrow_date() +
                            ", borrow_term = " + transaction.getBorrow_term() +
                            ", return_date = " +transaction.getReturn_date() +
                            ", debt = " + transaction.getDebt() +
                            "WHERE id = " + transaction.getId();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //endregion

    //region Dummy data
    public static UserInfoModel getDummyAdmin(){
        return new EmployeeModel(
                -1,
                -1,
                "admin",
                "admin",
                "Mateusz",
                "",
                "Kupiec",
                "696969696",
                "tiger.bronzo@onet.pl",
                "Mineralna 3 Uć",
                "2011-12-12",
                "A to to wgl nwm co to jest"
        );
    }
//    public static ObservableList<BookModel> getDummyBooks(){
//        ObservableList<BookModel> dummyBooks = FXCollections.observableArrayList();
//
//        dummyBooks.add(new BookModel(
//                -1,
//                "6969696",
//                "Benc benc",
//                "02/07/2015",
//                100
//        ));
//
//        dummyBooks.add(new BookModel(
//                -2,
//                "E23415",
//                "Kcecie sprubowaś nożu",
//                "08/10/2014",
//                47
//        ));
//
//        dummyBooks.add(new BookModel(
//                -3,
//                "T54234523",
//                "Dooobry jeees",
//                "27/04/2019",
//                256
//        ));
//
//        return dummyBooks;
//    }
    //endregion
}
