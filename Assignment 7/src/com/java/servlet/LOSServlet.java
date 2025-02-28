package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

public class LOSServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("Load On Startup LOSServlet is Initialized");
    }
}
