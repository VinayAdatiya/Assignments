package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


@WebServlet(value="/ServletRequestResponseEx")
public class ServletRequestResponseEx extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        request.setAttribute("user", "Vinay");
        request.setAttribute("email", "vad@narola.email");

        // Downcast to access HttpServletResponse-specific methods
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Custom-Header", "ServletDemo");
        httpResponse.addCookie(new Cookie("sessionUser", "Vinay"));

        request.getRequestDispatcher("servletRequestResponse.jsp").forward(request, response);
    }
}
