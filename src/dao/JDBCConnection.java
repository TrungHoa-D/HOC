package dao;
import java.sql.*;
public class JDBCConnection {
    public static Connection getConnection(){
        final String user = "sa";
        final String password = "1";
        final String url = "jdbc:sqlserver://localhost:1433;databaseName=HOCM;user=" + user + ";password=" + password;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
