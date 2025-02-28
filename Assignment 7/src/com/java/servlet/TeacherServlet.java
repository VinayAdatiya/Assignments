package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class TeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = getServletConfig().getInitParameter("username");
        String emailExtension = getServletConfig().getServletContext().getInitParameter("emailext");
        PrintWriter out = resp.getWriter();
        out.println("Config Parameter username:- "+username);
        out.println("Context Parameter email extension :- "+emailExtension);
        out.println("Your Generated Email :- "+username+"_teacher"+emailExtension);
    }
}
