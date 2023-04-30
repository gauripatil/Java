import java.sql.*;

public class Main {

    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/gauri/Documents/Java/SqliteDbApp/" + DB_NAME;
    public static final String TABLE_NAME = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {
        try {
            // This line of code added to resolve - java.sql.SQLException: No suitable driver found for jdbc:sqlite
            Class.forName("org.sqlite.JDBC");

            Connection connection = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = connection.createStatement();

            statement.execute("DROP TABLE IF EXISTS " + TABLE_NAME);
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                    + " ( " + COLUMN_NAME + " TEXT, " + COLUMN_PHONE + " INTEGER, " + COLUMN_EMAIL + " TEXT)");

            insertContacts(statement, "Gauri", 465774, "gauri@email.com");
            insertContacts(statement, "Joe", 45632, "joe@anywhere.com");
            insertContacts(statement, "Jane", 4829484, "jane@somewhere.com");
            insertContacts(statement, "Fido", 9038, "dog@email.com");

            statement.execute("UPDATE " + TABLE_NAME + " SET " + COLUMN_PHONE + "=554433 WHERE " + COLUMN_NAME + "='Gauri'");
            statement.execute("DELETE from " + TABLE_NAME + "  WHERE " + COLUMN_NAME + "='Fido'");

            statement.execute("SELECT * FROM " + TABLE_NAME +  " ");
            ResultSet result = statement.getResultSet();

            while (result.next()) {
                System.out.println(result.getString( COLUMN_NAME ) + " " +
                        result.getString(COLUMN_PHONE ) + " " +
                        result.getString(COLUMN_EMAIL));
            }
            result.close();
            statement.close();
            connection.close();

            /**
             * Now every result set has a cursor.
             *
             * Now this cursor isn't the same as a database cursor.
             *
             * We could have had several result set objects and each one will have a cursor.
             *
             * However, and this is actually quite important,
             *
             * if we re-use a statement object to do a query,
             *
             * then any result set associated with that statement object is closed
             *
             * and a new one is created for the new query.
             *
             * So if we want to work with several query results at the same time
             *
             * then it's imperative to use a different statement instance for each query.
             *
             * And keep in mind that a statement object ultimately can only ever have one
             *
             * active result set associated with it.
             *
             * Now note that result set is a resource.
             *
             * So we have to close it. And you can see that I added
             *
             * the results dot close on line 35.
             *
             * And that's because it's associated with the statement instance.
             *
             * We have to close it before we close the statement.
             *
             * Now we're closing all our resources at the end of the try block.
             *
             * If an exception is thrown,
             *
             * it's possible that the closed methods won't be executed.
             */

            System.out.println("DONE");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Something went wrong" + e.toString());
            e.printStackTrace();
        }
    }

    public static void insertContacts(Statement statement, String name, int phone, String email) throws SQLException {
        statement.execute("INSERT INTO " + TABLE_NAME + " ( " + COLUMN_NAME + ", " + COLUMN_PHONE + " , " + COLUMN_EMAIL+ ") " +
                "VALUES ( '" + name + "', '" + phone + "', '"+ COLUMN_EMAIL +"') ");

    }
}