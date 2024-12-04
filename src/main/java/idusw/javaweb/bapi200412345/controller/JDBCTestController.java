package idusw.javaweb.bapi200412345.controller;

import idusw.javaweb.bapi200412345.model.Member;
import idusw.javaweb.bapi200412345.repository.DAOImplMysql;
import idusw.javaweb.bapi200412345.repository.DAOImplOracle;
import idusw.javaweb.bapi200412345.repository.MemberDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet( urlPatterns = {"/main/oracle", "/main/mysql"})
public class JDBCTestController extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String uri = request.getRequestURI();
        String action = uri.substring(uri.lastIndexOf('/') + 1);

        Member member = new Member();
        member.setId(request.getParameter("id"));
        member.setPw(request.getParameter("pw"));

        MemberDAOImpl dao = new MemberDAOImpl();
        Member ret = dao.read(member);
        if(ret != null)
            System.out.println(ret.getSeq() + ")" + ret.getId() + ":" + ret.getEmail() + ":" + ret.getName());
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
