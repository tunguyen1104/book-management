package connect;

import java.sql.*;

public class JDBCConnection {
    public Connection getJDBCConnection() {
        try {
            String url = "jdbc:sqlserver://TUNGUYEN\\TUNGUYEN:1433;databaseName=QUANLISACH;encrypt=true;trustServerCertificate=true;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return (Connection) DriverManager.getConnection(url, "sa", "sa123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}
