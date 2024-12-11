package idusw.javaweb.bapi202312407;

import java.sql.*;

public class Mysql {
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/db202312407";
        String user = "u_b202312407";
        String password = "cometrue";

        try {
            System.out.println("Loading MySQL driver...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established!");

            stmt = conn.createStatement();
            System.out.println("Statement created!");

            System.out.println("db connect");
            return conn;
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL driver not found.");
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.err.println("Database connection failed.");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
