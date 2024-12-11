package idusw.javaweb.bapi202312407;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/list"})
public class MemberList extends HttpServlet {
    // GET 요청을 처리하는 메서드
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Mysql mysql = new Mysql(); // Mysql 객체를 생성하여 데이터베이스 연결 준비

        try {
            Connection conn = mysql.getConnection(); // 데이터베이스 연결을 가져옵니다.
            Statement stmt = conn.createStatement(); // SQL 쿼리 실행을 위한 Statement 객체 생성
            ResultSet rs = stmt.executeQuery("select * from member"); // member 테이블의 모든 데이터를 조회

            PrintWriter out = response.getWriter(); // HTTP 응답의 출력 스트림 가져오기

            // ResultSet의 데이터를 반복하여 출력
            while (rs.next()) {
                out.print(rs.getString("seq") + ", " + rs.getString("id") + ", " + rs.getString("pw") + ", ");
                out.print(rs.getString("name") + ", " + rs.getString("email") + "<br/>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e); // SQL 예외가 발생하면 런타임 예외로 던집니다.
        }
    }
}
