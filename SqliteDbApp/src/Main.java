import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Try to connect to db");
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
}