package model.connection;

import java.sql.*;

public class ConnectionFactory {

    private static final String DRIVE = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/FinancialApp" +
            "?autoReconnect=true&useSSL=false";
    private static final String USER = "FinancialAppUser";
    private static final String PASS = "Z7PmQaNtKC6H";

    /*  OBS:
     *  na url '?autoReconnect=true&useSSL=false'
     *  remove o warning do banco    *
     */

    public static Connection getConnection() {
        try {
            Class.forName(DRIVE);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Database connection error!");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return null;
    }

    public static boolean closeConnection(Connection con) {
        if (con == null) return false;
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Close Connection error!");
            return false;
        }
        return true;
    }

    public static boolean closeConnection(Connection con, PreparedStatement stmt) {
        closeConnection(con);
        if (stmt == null) return false;
        try {
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Close Statement error!");
            return false;
        }
        return true;
    }

    public static boolean closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);

        if (rs == null) return false;

        try {
             rs.close();
        } catch (SQLException ex) {
            System.out.println("Close ResultSet error!");
            return false;
        }
        return true;
    }


}
