package idusw.javaweb.bapi202312407.controller;
import java.util.List;
import idusw.javaweb.bapi202312407.model.Member;
import idusw.javaweb.bapi202312407.repository.MemberDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = { "/member/login", "/member/logout", "/member/post", "/member/get", "/member/list", "/member/update", "/member/delete" })
public class MemberController extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        String uri = request.getRequestURI();
        String action = uri.substring(uri.lastIndexOf('/') + 1);

        if (action.equals("list")) {
            MemberDAOImpl dao = new MemberDAOImpl();
            List<Member> memberList = dao.readList();
            if (memberList != null) {
                request.setAttribute("title", "목록 조회 성공");
                request.setAttribute("memberList", memberList);
                request.getRequestDispatcher("../pages/memberList.jsp").forward(request, response);
            } else {
                request.setAttribute("title", "목록 조회 실패");
                request.getRequestDispatcher("../pages/blank.jsp").forward(request, response);
            }
        } else if (action.equals("login")) {
            Member member = new Member();
            member.setEmail(request.getParameter("email")); // email 필드로 로그인 처리
            member.setPw(request.getParameter("pw"));

            MemberDAOImpl dao = new MemberDAOImpl();
            Member ret = dao.read(member);

            if (ret != null) {
                System.out.println("로그인 성공"); // 성공 뷰로 이동
                session.setAttribute("member", ret);
                request.getRequestDispatcher("../pages/success.jsp").forward(request, response);
            } else {
                System.out.println("로그인 실패"); // 실패 뷰로 이동
                request.getRequestDispatcher("../pages/blank.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }
}
