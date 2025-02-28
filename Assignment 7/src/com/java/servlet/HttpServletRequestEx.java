package servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(value="/HttpServletRequestEx")
public class HttpServletRequestEx extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        request.setAttribute("name", "Vinay");
        request.setAttribute("email", "vad@narola.email");
        request.getRequestDispatcher("httpServletRequest.jsp").include(request, response);
        //response.sendRedirect("httpServletRequest.jsp");
    }
}