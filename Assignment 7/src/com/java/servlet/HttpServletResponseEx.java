package servlet;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(value="/HttpServletResponseEx")
public class HttpServletResponseEx extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        response.setHeader("Custom-Header", "Vinay'sServlet");
        Cookie cookie = new Cookie("user", "Vinay");
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);

        response.setStatus(HttpServletResponse.SC_OK);
        
        request.setAttribute("status", response.getStatus());
        request.setAttribute("contentType", response.getContentType());
        request.setAttribute("characterEncoding", response.getCharacterEncoding());
        
        request.getRequestDispatcher("httpServletResponse.jsp").include(request, response);
    }
}
