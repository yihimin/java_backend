package idusw.javaweb.bapi200412345;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name="logoutController", urlPatterns = {"/logout"})
public class LogoutController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate(); // session 객체를 무효화 함, logined 속성이 사라짐
        // 로그인 또는 로그아웃 상태 가능한 페이지로 이동
        response.sendRedirect("./main/index.jsp"); // 전달할 내용이 없고,  서버 내부에서 이동, URL 변경됨

        //response.sendRedirect("https://www.naver.com"); // 지정한 URL로 이동
        // request.getRequestDispatcher("./main/index.jsp").forward(request, response);
        // 전달할 내용이 있는 경우, 서버 내부에서 이동, URL이 변경되지 않음
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
