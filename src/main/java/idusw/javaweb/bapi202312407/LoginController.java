package idusw.javaweb.bapi202312407;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;

@WebServlet(name = "memberController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    // GET 요청을 처리하는 메서드
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
        // GET 요청이 왔을 때 "doGet"을 출력합니다.
        // doPost(request, response); // POST 메서드를 호출할 수도 있음
    }

    // POST 요청을 처리하는 메서드
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // POST 요청을 처리하여 로그인 로직을 수행합니다.

        HttpSession session = request.getSession();
        // 현재 요청에 대한 세션을 가져옵니다. 로그인 상태를 세션에 저장하기 위해 사용됩니다.

        String fixedPw = "cometrue"; // 데이터베이스에서 가져온 비밀번호를 임시로 저장할 변수입니다.

        Mysql mysql = new Mysql(); // Mysql 클래스 인스턴스를 생성하여 데이터베이스 연결을 준비합니다.

        try {
            Connection conn = mysql.getConnection(); // 데이터베이스와 연결하고 Connection 객체를 가져옵니다.
            Statement stmt = conn.createStatement(); // SQL 쿼리를 실행하기 위한 Statement 객체를 생성합니다.

            String query = "select * from member where id='"
                    + request.getParameter("email")
                    + "' and pw='" + request.getParameter("pw") + "'";
            // 사용자가 입력한 'email'과 'pw'를 이용하여 member 테이블에서 일치하는 데이터를 조회하는 쿼리를 정의합니다.
            // 보안을 위해 PreparedStatement 사용을 권장합니다.

            ResultSet rs = stmt.executeQuery(query); // 질의 수행하고 결과를 ResultSet 객체에 저장
            if (rs.next()) {
                // 암호 일치 -> 로그인 성공
                request.setAttribute("attr", "로그인 성공"); // 로그인 성공 메시지를 request 객체에 설정

                String email = request.getParameter("email");
                int idx = email.length(); // 이메일 전체 길이를 idx에 저장합니다.

                session.setAttribute("logined", email); // 세션에 이메일을 저장합니다.

                // ResultSet에서 각 컬럼 값을 가져와 request 객체에 설정
                request.setAttribute("seq", rs.getString("seq"));
                request.setAttribute("id", rs.getString("id"));
                request.setAttribute("pw", rs.getString("pw"));
                request.setAttribute("name", rs.getString("name"));
                request.setAttribute("email", rs.getString("email"));
            } else {
                // 암호 불일치 -> 로그인 실패
                request.setAttribute("attr", "로그인 실패"); // 로그인 실패 메시지를 request 객체에 설정
                session.setAttribute("logined", null); // 로그인 상태를 null로 설정하여 로그인 실패를 표시
            }

            // JSP 페이지 `pages/blank.jsp`로 포워드하여 로그인 결과를 표시합니다.
            request.getRequestDispatcher("pages/blank.jsp").forward(request, response);

        } catch (SQLException e) {
            throw new RuntimeException(e); // SQL 예외가 발생하면 런타임 예외로 변환하여 던집니다.
        }
    }
}
