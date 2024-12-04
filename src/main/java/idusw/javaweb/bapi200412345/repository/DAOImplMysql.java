package idusw.javaweb.bapi200412345.repository;

import idusw.javaweb.bapi200412345.model.Member;
import java.sql.*;


public class DAOImplMysql implements DAO {
    @Override
    public Connection getConnection() {
        Connection conn = null;
        String jdbcUrl = "jdbc:mysql://localhost:3306/db202312407b";
        String dbUser = "root";
        String dbPw = "1234";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버 로딩
            conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPw);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    @Override
    public void closeResources(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (conn != null) conn.close();
            if (stmt != null) stmt.close();
            if (pstmt != null) pstmt.close();
            if (rs != null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
