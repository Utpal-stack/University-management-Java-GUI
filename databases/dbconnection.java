package databases;
import java.sql.*;


//public class tables{

//}
public class dbconnection {

    Connection con;
java.sql.PreparedStatement pst;
    public static Connection dbconnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connection Successful");

        } catch (ClassNotFoundException ex) {
            System.out.println("Exception :" + ex.getMessage());

        }
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "ppks*8167");
            System.out.println("Database Connected");
            return conn;
        } catch (SQLException ex) {
            System.out.println("Exception :" + ex.getMessage());
            return null;

        }


    }


public static void main(String[]args){

}
}
