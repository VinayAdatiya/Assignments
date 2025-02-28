package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/ProfileServlet")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();

            String name = "";

            // request object will return an array of cookies
            Cookie[] cookies = req.getCookies();
            if (cookies == null) {
                out.println("<h1> You are a new user, kindly login. </h1>");
                req.getRequestDispatcher("login.html")
                        .include(req, resp);
                // Above statement includes login.html for the
                // user to re-login if username or password is
                // invalid.
            } else {
                int flag = 0;
                for (Cookie c : cookies) {
                    String tempName
                            = c.getName(); // For every cookie, add
                    // cookie name to the
                    // tempName.

                    if (tempName.equals("username"))
                    // If tempName and username (that we had set
                    // in the cookie c in LoginServlet) are
                    // same, then this is an already logged in
                    // user and the request is not from a new
                    // user. So let the user access profile page.
                    {
                        flag=1;
                        name = c.getValue(); // From the (name,
                        // value) pair of
                        // cookie, fetch
                        // value
                        out.println("<a href='LogoutServlet' style='font-size:25px;'>Logout </a>");
                        out.println("<h1>Welcome to your profile, " + name);

                    }
                    else if(tempName.equals("JSESSIONID")){
                        HttpSession session = req.getSession(false);
                        String sessionId = c.getValue();
                        out.println("<h1>Your Session ID is :- " + sessionId);
                        out.println("<h1>Session User :- "+ session.getAttribute("user"));
                    }
                    else{
                        if(flag==0){
                            out.println("<h2>Please Authenticate Yourself</h2>");
                            out.println("<a href='login.html' style='font-size:25px;'>login</a>");
                        }
                    }
                }
            }
        }
    }
}
