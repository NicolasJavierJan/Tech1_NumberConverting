import javax.management.Query;
import java.sql.*;

public class UnicodeToDatabase {

    private static Connection connect;
    private static String db;
    private static String url = "jdbc:mysql://localhost:3306/unicode";
    private static String user = "root";
    private static String password = "";
    private static Statement statement = null;
    private static ResultSet rs = null;
    private static String query;

    public static Connection connect(String username, String password) {
        try {
            connect = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Connection failed");
            // Precise way of telling you what went wrong
            e.printStackTrace();
        }

        return connect;
    }

    private static void executeQuery(String query){
        try {
            statement =  connect.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void insertInto(String tblName, int decimal, long binary, char unicode){
        if (decimal == 39){
            // The ' gave problems.
            query = "insert into " + tblName +
                    "(`decimal`, `binary`, `unicode`) values " + "('" + decimal + "', '" +
                    + binary + "', '" + "\\\u0027" + "');";

        } else {
            query = "insert into " + tblName +
                    "(`decimal`, `binary`, `unicode`) values " + "('" + decimal + "', '" +
                    + binary + "', N'" + unicode + "');";
        }



        executeQuery(query);
    }

    // Only for Basic Latin, can be changed
    public static void uTD(){
        connect(user, password);
        for (int i = 0; i <= 127; i++){
            char c = (char) i;
            long binary = DecimalToBinary.decimalToBinary(i);
            insertInto("unicode", i, binary, c);
        }
    }

}
