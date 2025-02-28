package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import static java.lang.System.out;

@WebServlet(value = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Logout Called !!!");
        resp.setContentType("text/html");
        Cookie[] cookies = req.getCookies();
        System.out.println("Session before invalidate: "+ req.getSession(false));
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("JSESSIONID")){
                    System.out.println("JSESSIONID="+cookie.getValue());
                    break;
                }
            }
        }
        //invalidate the session if exists
        HttpSession session = req.getSession(false);
        System.out.println("User="+session.getAttribute("user"));
        if(session != null){
            session.invalidate();
        }
        System.out.println("Session after invalidate: "+ req.getSession(false));

        Cookie c = new Cookie("username","");
        c.setMaxAge(0);
        resp.addCookie(c);
        out.println("<h2>You have successfully logged out !!! </h2>");
        resp.sendRedirect("index.jsp");
    }
}
