package idusw.javaweb.bapi200412345;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet (name = "memberController", urlPatterns = { "/login" })
public class MemberController extends HttpServlet {
    // get method 요청 처리
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
        //doPost(request, response);
    }
    // post method 요처 처리
    // exception propagation , 예외 전파 - 연관된 예외 처리 클래스나 호출한 클래스로 전파
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String fixedPw = "comso"; // database에서 가져올 계획임, 인스턴스 변수로 선언
        /*
            request : 요청을 처리하기 위한 객체, HTTP 프로토콜은 무상태 프로토콜로 요청하고, 응답을 받으면 더 이상 상태를 유지하지 않음
            session : 연속적인 요청을 처리하기 위해 상태를 유지할 목적으로 사용되는 지정한 시간동안 상태를 유지하는 객체
         */
        if(request.getParameter("pw").equals(fixedPw)) {
            // 암호 일치 -> 로그인 성공
            request.setAttribute("attr", "로그인 성공");  // request.getAttribute("attr")
            String email = request.getParameter("email");
            int idx = email.indexOf("@"); // @ 위치에 해당하는 위치 번호를 제공
            session.setAttribute("logined", email.substring(0, idx)); // session.getAttribute("logined")
            // 0 ~ idx-1 위치의 문자열을 추출 : comso@induk.ac.kr -> idx는 5가 됨, 그리고 0 ~ 4 인덱스에 해당하는 값을 문자열로 서브스트링
            // attribute 설정은 setAttribute(), 접근은 getAttribute() 함.  getParameter()로는 접근 안됨
        } else {
            // 암호 불일치 -> 로그인 실패
            request.setAttribute("attr", "로그인 실패");
            session.setAttribute("logined", null);
        }
        // ./pages == pages 같음. 이유는 현재디렉터리(url 경로)가 '/' 임.
        request.getRequestDispatcher("pages/blank.jsp").forward(request, response);
    }

    /*
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("service");
    }
    */
}
