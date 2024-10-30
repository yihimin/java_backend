package idusw.javaweb.bapi200412345;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

// @WebServlet : url과 서블릿을 매핑하는 애노테이션
@WebServlet(name = "helloServlet", urlPatterns = {"/hello-servlet", "/hello", "/reset"})
// Servlet 으로 Controller 작성, Servlet 이 Controller 역할 수행
public class HelloServlet extends HttpServlet {
    // HttpServlet 을 상속하면, HttpServletRequest, HttpServletResponse 사용할 수 있음
    private String message;
    public void init() {
        message = "Hello World!";
    }
    // HttpServletRequest 형 request 객체는 요청을 처리하기 위한 메소드와 객체로 구성
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        // View로 요청, 응답 객체를 전달하는 방식으로 처리
        // 예) View는 404.jsp 사용
        request.getRequestDispatcher("./pages/404.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("reset-doPost");
        HttpSession session = request.getSession();
        session.setAttribute("logined", "1234"); // reset pw : comso -> 1234
        request.getRequestDispatcher("./pages/login.jsp").forward(request, response);
    }
    public void destroy() {
    }
}