package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import static java.lang.System.out;

@WebServlet(value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    public boolean validateUser(String user , String pass){
        if(user.equals("Vinay") && pass.equals("123")){
            return true;
        }
        return false;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Username = req.getParameter("username");
        String Password = req.getParameter("password");
        if(validateUser(Username,Password)){
            HttpSession session = req.getSession();
            session.setAttribute("user", "Vinay");
            //setting session to expiry in 5 mins
            session.setMaxInactiveInterval(1*60);
            System.out.println("Welcome " + Username + ", you have successfully logged in!");
            // creating cookie
            Cookie c = new Cookie("username", Username);
            // attaching cookie to response object
            resp.addCookie(c);
            resp.sendRedirect("index.jsp");
        }
        else{
            System.out.println("Sorry invalid username or password!");
            resp.sendRedirect("login.html");
        }
    }
}
