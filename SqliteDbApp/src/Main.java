import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            // This line of code added to resolve - java.sql.SQLException: No suitable driver found for jdbc:sqlite
            Class.forName("org.sqlite.JDBC");

            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/gauri/Documents/Java/SqliteDbApp/testjava.db");
            Statement statement = connection.createStatement();

            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, EMAIL TEXT)");
            statement.close();
            connection.close();


            System.out.println("Try to connect to db");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Something went wrong" + e.toString());
        }
    }
}