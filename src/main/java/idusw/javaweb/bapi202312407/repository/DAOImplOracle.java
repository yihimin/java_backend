package idusw.javaweb.bapi202312407.repository;

import java.sql.*;

public class DAOImplOracle implements DAO{
    @Override
    public Connection getConnection() {
        Connection conn = null;
        //String jdbcUrl = "jdbc:oracle:thin:@210.102.226.241:8080:XE";
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        String dbUser = "system";
        String dbPw = "cometrue";
        try{
            Class.forName("oracle.jdbc.OracleDriver"); //드라이버 로딩
            conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPw);
            // 적재된 드라이버 관리자 객체의 getConnection() 정적메소드를 호출하여 Connection 객체 생성
            // Connection -> statement / PreparedStatement 객체 생성 -> query 실행
            // -> ResultSet (read) or 영향받은 row 수(create, update, delete) 반환
        } catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

    @Override
    public void closeResources(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
